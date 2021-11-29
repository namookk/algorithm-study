package com.algorithm.inflearn.chapter7;

import java.util.LinkedList;
import java.util.Queue;

public class Main7_7 {
    public static void main(String[] args) {
        BinaryTree2 tree = new BinaryTree2();
        solution(tree);
    }

    public static void solution(BinaryTree2 tree) {
        int level = 1;
        Queue<Node2> queue = new LinkedList<Node2>();
        queue.offer(tree.root);
        while(!queue.isEmpty()) {
            for(int i = 0; i < queue.size(); i++) {
                Node2 node = queue.poll();
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
class Node2{
    int value;
    Node2 left;
    Node2 right;

    public Node2(int _value) {
        value = _value;
        left = null;
        right = null;
    }
}

class BinaryTree2{
    Node2 root;

    public BinaryTree2(){
        root = new Node2(1);
        root.left = new Node2(2);
        root.right = new Node2(3);
        root.left.left = new Node2(4);
        root.left.right = new Node2(5);
        root.right.left = new Node2(6);
        root.right.right = new Node2(7);
    }
}
