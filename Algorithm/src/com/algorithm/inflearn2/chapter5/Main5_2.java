package com.algorithm.inflearn2.chapter5;

public class Main5_2 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);

        ListNode result = solve(listNode);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
        System.out.println();
        ListNode result2 = re_solve(listNode);
        while(result2 != null) {
            System.out.println(result2.val);
            result2 = result2.next;
        }
    }

    public static ListNode solve(ListNode listNode) {
        ListNode head = new ListNode();
        ListNode p = listNode;

        while(p != null) {
            head.val = p.val;
            p = p.next;
            if(p != null) {
                ListNode new_head = new ListNode();
                new_head.next = head;
                head = new_head;
            }
        }

        return head;
    }

    public static ListNode re_solve(ListNode listNode) {
        //1.ds
        ListNode next = null;
        ListNode prev = null;

        while(listNode != null) {
            next = listNode.next;
            listNode.next = prev;
            prev = listNode;
            listNode = next;
        }

        return prev;
    }
}
