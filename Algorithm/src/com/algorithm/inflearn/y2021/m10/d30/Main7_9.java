package com.algorithm.inflearn.y2021.m10.d30;

import java.util.LinkedList;
import java.util.Queue;

public class Main7_9 {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println(DFS(0, tree.root));
    }

    public static int DFS(int L, Node root){
         if(root.left == null && root.right == null) return L;
         else return Math.min(DFS(L+1, root.left), DFS(L+1, root.right));
    }
}

class BinaryTree{
    Node root;
}

class Node{
    int val;
    Node left;
    Node right;

    public Node(int _val) {
        val = _val;
        left = null;
        right = null;
    }
}
