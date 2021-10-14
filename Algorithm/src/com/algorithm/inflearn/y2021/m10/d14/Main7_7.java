package com.algorithm.inflearn.y2021.m10.d14;

import java.util.LinkedList;
import java.util.Queue;

public class Main7_7 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        solution(tree);
    }

    public static void solution(BinaryTree tree) {
        int level = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(tree.root);
        while(!queue.isEmpty()) {
            for(int i = 0; i < queue.size(); i++) {
                Node node = queue.poll();
                if (node != null) {
                    System.out.print(node.value + " ");
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null) queue.offer(node.right);
                }
                level++;
            }
        }
    }
}
class Node{
    int value;
    Node left;
    Node right;

    public Node(int _value) {
        value = _value;
        left = null;
        right = null;
    }
}
class BinaryTree{
    Node root;

    public BinaryTree(){
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
    }
}
