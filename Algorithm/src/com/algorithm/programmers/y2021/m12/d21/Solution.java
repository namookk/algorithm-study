package com.algorithm.programmers.y2021.m12.d21;

import java.util.HashMap;
import java.util.Map;
//https://programmers.co.kr/learn/courses/30/lessons/77486
//정확성  테스트
//        테스트 1 〉	통과 (0.35ms, 78.8MB)
//        테스트 2 〉	통과 (0.26ms, 77.1MB)
//        테스트 3 〉	통과 (0.45ms, 76MB)
//        테스트 4 〉	통과 (0.54ms, 78.9MB)
//        테스트 5 〉	통과 (1.02ms, 74.8MB)
//        테스트 6 〉	통과 (5.44ms, 110MB)
//        테스트 7 〉	통과 (3.50ms, 99.8MB)
//        테스트 8 〉	통과 (4.64ms, 101MB)
//        테스트 9 〉	통과 (10.31ms, 94.8MB)
//        테스트 10 〉	통과 (43.01ms, 145MB)
//        테스트 11 〉	통과 (35.73ms, 150MB)
//        테스트 12 〉	통과 (30.04ms, 138MB)
//        테스트 13 〉	통과 (53.67ms, 144MB)
public class Solution {
    static int answer = 1;
    static int[][] dirs = {{1,0}, {0, 1}, {1,1}};

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        for(int i : solution(enroll, referral, seller, amount)) System.out.print(i + " ");;

    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Node> map = new HashMap<>();

        for(int i = 0; i < enroll.length; i++) {
            Node node = new Node(enroll[i], referral[i], i);
            map.put(node.name, node);
        }
        for(int i = 0; i < seller.length; i++) {
            getMoney(map, seller[i], amount[i] * 100);
        }

        for(int i = 0; i < enroll.length; i++) {
            answer[i] = map.get(enroll[i]).amount;
        }

        return answer;
    }

    public static void getMoney(Map<String, Node> map, String key, int pay) {
        if(pay == 0) return;

        Node node = map.get(key);
        int parentPay = pay >= 10 ? pay/10 : 0;
        int myPay = pay - parentPay;
        node.plus(myPay);
        map.put(node.name, node);

        if(map.containsKey(node.parent)) getMoney(map, node.parent, parentPay);
    }
}


class Node{
    String name, parent;
    int idx;
    int amount;

    Node(String name, String parent, int idx) {
        this.name = name;
        this.parent = parent;
        this.idx = idx;
        this.amount = 0;
    }
    public void plus(int amount){
        this.amount += amount;
    }
}

