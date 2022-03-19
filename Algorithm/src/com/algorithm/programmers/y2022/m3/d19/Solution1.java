package com.algorithm.programmers.y2022.m3.d19;

import java.util.Stack;

public class Solution1 {
    static final Bank bank = Bank.getInstance();
    static int[] monthOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) {
        String[] ledgers = {"01/01 4 50000","01/11 6 3555","02/01 0 -23555","02/25 5 5000","03/25 0 -15000","06/09 8 43951","12/30 9 99999"};
        System.out.println(solution(ledgers));

        String[] ledgers2 = {"04/01 1 40000","05/01 5 20000","08/31 4 10000","11/11 0 -45000"};
        System.out.println(solution(ledgers2));
    }

    private static int solution(String[] ledgers) {
        int interest = 0;

        for(String ledger : ledgers) {
            String[] ledgerSplit = ledger.split(" ");
            int day = getDay(ledgerSplit[0]);
            int interestRatio = Integer.parseInt(ledgerSplit[1]);
            int money = Integer.parseInt(ledgerSplit[2]);

            if(money > 0) { //입금
                bank.deposit(new Deposit(day, money, interestRatio));
            }else { //출금
                interest += bank.withdrawal(Math.abs(money), day);
            }
        }
        interest += bank.totalWithdrawal(getDay("12/31"));

        return interest;
    }

    private static int getDay(String dateStr) {
        String[] dateStrSplit = dateStr.split("/");
        int month = Integer.parseInt(dateStrSplit[0]);
        int day = Integer.parseInt(dateStrSplit[1]);

        if(month == 1) return day;

        int sum = 0;
        for(int i = 0; i < month - 1; i++) {
            sum += monthOfDays[i];
        }
        return sum + day;
    }
}

class Deposit{
    int day, money, interestRatio;

    Deposit(int day, int money, int interestRatio) {
        this.day = day;
        this.money = money;
        this.interestRatio = interestRatio;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "day=" + day +
                ", money=" + money +
                ", interestRatio=" + interestRatio +
                '}';
    }
}

class Bank{
    private Stack<Deposit> account;
    private Bank() { this.account = new Stack<>(); }
    private static class BankHolder{
        public static final Bank INSTANCE = new Bank();
    }
    public static Bank getInstance() {
        return BankHolder.INSTANCE;
    }

    public int totalWithdrawal(int lastday) {
       return withdrawal(Integer.MAX_VALUE, lastday);
    }

    public void deposit(Deposit deposit) {
        account.add(deposit);
    }

    public int withdrawal(int money, int today) {
        int interest = 0;
        while(!account.isEmpty() && money > 0) {
            Deposit recentDeposit = account.pop();
            //출금 금액
            int withdrawalMoney = 0;
            if (recentDeposit.money >= money) {
                withdrawalMoney = money;
                recentDeposit.money -= money;
            } else {
                withdrawalMoney = recentDeposit.money;
                recentDeposit.money = 0;
            }
            // 이자 구하기
            interest += getInterest(withdrawalMoney, recentDeposit.interestRatio, today - recentDeposit.day);

            //잔액이 남았으면 다시 넣는다.
            if(recentDeposit.money > 0) {
                account.add(recentDeposit);
            }
            money -= withdrawalMoney;
        }
        return interest;
    }


    private int getInterest(int withdrawalMoney, int ratio, int duringDay) {
        return (int)((withdrawalMoney * ((double)ratio / 100)) * ((double)duringDay / 365));
    }
}