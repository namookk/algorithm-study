package com.algorithm.inflearn2.chapter5;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main5_3 {
    public static void main(String[] args) {
        List<ListNode> nodeList = new ArrayList<>();

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(7);

        nodeList.add(node1);
        nodeList.add(node2);
        nodeList.add(node3);

        ListNode result = solve(nodeList);
        while(result != null) {
            System.out.print(result.val +" -> ");
            result = result.next;
        }
    }

    public static ListNode solve(List<ListNode> nodeList) {
        ListNode head = new ListNode();
        ListNode p = head;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nodeList.size(); i++) {
            ListNode node = nodeList.get(i);
            while(node != null) {
                System.out.println(node.val);
                pq.offer(node.val);
                node = node.next;
            }
        }

        while(!pq.isEmpty()){
            p.val = pq.poll();
            if(!pq.isEmpty()) {
                p.next = new ListNode();
                p = p.next;
            }
        }

        return head;
    }
}
