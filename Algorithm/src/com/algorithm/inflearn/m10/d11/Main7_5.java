package com.algorithm.inflearn.m10.d11;

import java.util.LinkedList;
import java.util.Queue;

public class Main7_5 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        System.out.println(tree.postorderTree(tree.root));
        System.out.println(tree.preorderTree(tree.root));
        System.out.println(tree.inorderTree(tree.root));
    }
}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int _root) {
        value = _root;
        left = null;
        right = null;
    }
}

class BinaryTree {
    Node root = null;

    public void insert(int num) {
        if(root == null) {
            root = new Node(num);
        }else {
            Node head = root;
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);

            while (!queue.isEmpty()) {
                Node tn = queue.poll();

                if (tn.left == null) {
                    tn.left = new Node(num);
                    break;
                } else {
                    queue.add(tn.left);
                }

                if (tn.right == null) {
                    tn.right = new Node(num);
                    break;
                } else {
                    queue.add(tn.right);
                }
            }
        }
    }

    public String postorderTree(Node root) {
        if (root != null) {
            String result = "";
            result += postorderTree(root.left);
            result += postorderTree(root.right);
            result += root.value;
            return result;
        }
        return "";
    }
    public String preorderTree(Node root) {
        if (root != null) {
            String result = "";
            result += preorderTree(root.left);
            result += root.value;
            result += preorderTree(root.right);
            return result;
        }
        return "";
    }
    public String inorderTree(Node root) {
        if (root != null) {
            String result = "";
            result += root.value;
            result += inorderTree(root.left);
            result += inorderTree(root.right);
            return result;
        }
        return "";
    }
}
