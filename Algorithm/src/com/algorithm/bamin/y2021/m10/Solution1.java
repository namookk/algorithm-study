package com.algorithm.bamin.y2021.m10;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    String value;
    Node left;
    Node right;

    public Node(String _value) {
        value = _value;
        left = null;
        right = null;
    }
}

class BinaryTree {
    Node root = null;

    public void insert(String val) {
        if(root == null) {
            root = new Node(val);
        }else{
            Node head = root;
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);

            while(!queue.isEmpty()) {
                Node tn = queue.poll();

                if(tn.left == null) {
                    tn.left = new Node(val);
                    break;
                }else {
                    queue.add(tn.left);
                }

                if(tn.right == null) {
                    tn.right = new Node(val);
                    break;
                }else{
                    queue.add(tn.right);
                }
            }
        }
    }

    public String postorderTree(Node root, int depth) {
        if (root != null) {
            String result = "";
            result += postorderTree(root.left, depth + 1);
            result += postorderTree(root.right, depth + 1);
            result += root.value;
            return result;
        }
        return "";
    }
}

public class Solution1 {
    public static void main(String[] args) {
        String message = "ABCDEF";
        System.out.println(solution(message));
    }

    public static String solution(String message) {
        String answer = "";
        BinaryTree tree = new BinaryTree();
        for(char c : message.toCharArray()) {
            tree.insert(String.valueOf(c));
        }
        answer = tree.postorderTree(tree.root, 0);
        return answer;
    }
}