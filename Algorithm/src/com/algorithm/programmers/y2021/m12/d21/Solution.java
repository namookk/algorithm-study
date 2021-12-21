package com.algorithm.programmers.y2021.m12.d21;

import java.util.HashMap;
import java.util.Map;
//https://programmers.co.kr/learn/courses/30/lessons/77486
//정확성  테스트
//        테스트 1 〉	통과 (0.20ms, 71.7MB)
//        테스트 2 〉	통과 (0.31ms, 76.4MB)
//        테스트 3 〉	통과 (0.27ms, 74.4MB)
//        테스트 4 〉	통과 (0.48ms, 69.9MB)
//        테스트 5 〉	통과 (1.01ms, 75.9MB)
//        테스트 6 〉	통과 (3.13ms, 104MB)
//        테스트 7 〉	통과 (3.51ms, 98.8MB)
//        테스트 8 〉	통과 (4.89ms, 100MB)
//        테스트 9 〉	통과 (13.86ms, 109MB)
//        테스트 10 〉	통과 (65.17ms, 143MB)
//        테스트 11 〉	실패 (시간 초과)
//        테스트 12 〉	실패 (시간 초과)
//        테스트 13 〉	실패 (시간 초과)
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

