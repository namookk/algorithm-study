package com.algorithm.baekjoon.silver5;

import java.util.*;

public class Solution_2238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limit = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        List<Auction> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            int price = Integer.parseInt(arr[1]);
            int idx = list.indexOf(new Auction(price));
            if(idx > -1){
                Auction auction = list.get(idx);
                auction.addPeopleList(arr[0]);
            }else{
                Auction auction = new Auction(Integer.parseInt(arr[1]), new ArrayList<>(List.of(arr[0])));
                list.add(auction);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0).price);
        System.out.println(list.get(0).peopleList.get(0));
    }
}

class Auction implements Comparable<Auction> {
    int price;
    List<String> peopleList;

    Auction(int price){
        this(price, null);
    }

    Auction(int price, List<String> peopleList){
        this.price = price;
        this.peopleList = peopleList;
    }

    public void addPeopleList(String people){
        this.peopleList.add(people);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auction auction = (Auction) o;
        return price == auction.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public int compareTo(Auction o) {
        if(o.peopleList.size() == this.peopleList.size()){
            return this.price - o.price;
        }
        return this.peopleList.size() - o.peopleList.size();
    }
}
