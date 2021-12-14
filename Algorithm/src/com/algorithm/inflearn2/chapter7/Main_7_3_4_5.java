package com.algorithm.inflearn2.chapter7;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main_7_3_4_5 {
    static int answer;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(solve_recursive(root));
        System.out.println(solve_bfs(root));
        System.out.println(solve_dfs(root));
    }

    public static int solve_recursive(TreeNode root) {
        if(root == null) return 0;
        answer = 0;

        recursive(root, 1);

        return answer;
    }

    public static void recursive(TreeNode node, int level) {
        if(node == null) return;

        answer = Math.max(answer, level);
        recursive(node.left, level+1);
        recursive(node.right, level+1);
    }

    //=========================================================

    public static int solve_bfs(TreeNode root) {
        answer = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            answer++;
        }

        return answer;
    }

    //=========================================================

    public static int solve_dfs(TreeNode root){
        answer = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> valuestack = new Stack<>();
        stack.push(root);
        valuestack.push(1);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int count = valuestack.pop();
            answer = Math.max(answer, count);
            if(node.left != null) {
                stack.push(node.left);
                valuestack.push(count+1);
            }
            if(node.right != null) {
                stack.push(node.right);
                valuestack.push(count+1);
            }
        }
        return answer;
    }
}

class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int val){
        this.val = val;
    }
}