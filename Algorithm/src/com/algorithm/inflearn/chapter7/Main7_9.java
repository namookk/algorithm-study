package com.algorithm.inflearn.chapter7;

import java.util.LinkedList;
import java.util.Queue;

public class Main7_9 {

    public static void main(String[] args) {
        BinaryTree3 tree = new BinaryTree3();
        tree.root = new Node3(1);
        tree.root.left = new Node3(2);
        tree.root.right = new Node3(3);
        tree.root.left.left = new Node3(4);
        tree.root.left.right = new Node3(5);
        System.out.println(DFS(0, tree.root));
        System.out.println(BFS(tree.root));
    }

    public static int DFS(int L, Node3 root){
         if(root.left == null && root.right == null) return L;
         else return Math.min(DFS(L+1, root.left), DFS(L+1, root.right));
    }

    public static int BFS(Node3 root) {
        Queue<Node3> queue = new LinkedList<>();
        queue.offer(root);
        int L = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Node3 Node3 = queue.poll();
                if(Node3.left == null && Node3.right == null){
                    return L;
                }
                if(Node3.left != null) {
                    queue.offer(Node3.left);
                }
                if(Node3.right != null) {
                    queue.offer(Node3.right);
                }
            }
            L++;
        }
        return L;
    }
}

class BinaryTree3{
    Node3 root;
}

class Node3{
    int val;
    Node3 left;
    Node3 right;

    public Node3(int _val) {
        val = _val;
        left = null;
        right = null;
    }
}
