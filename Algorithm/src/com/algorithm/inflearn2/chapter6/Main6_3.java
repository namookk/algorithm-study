package com.algorithm.inflearn2.chapter6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main6_3 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        for(List<Integer> list : solve(root)) {
            for(Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> solve(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);

                list.add(node.val);
            }
            result.add(list);
        }

        return result;
    }
}

class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        this.val = x;
    }
}
