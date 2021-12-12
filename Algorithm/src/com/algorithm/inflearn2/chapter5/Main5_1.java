package com.algorithm.inflearn2.chapter5;

import java.util.ArrayList;
import java.util.List;

public class Main5_1 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode answer = solve(l1, l2);
        while(answer != null) {
            System.out.print(answer.val + " -> ");
            answer = answer.next;
        }
    }
    public static ListNode solve(ListNode l1, ListNode l2) {
        //1.ds
        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3 = newHead;
        int carry = 0;

        //2
        while(p1 != null || p2 != null) {
            if(p1 != null) {
               carry += p1.val;
               p1 = p1.next;
            }
            if(p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }
            p3.next = new ListNode(carry % 10);
            p3 = p3.next;

            carry /= 10;
        }
        if(carry > 0) p3.next = new ListNode(carry);

        return newHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
