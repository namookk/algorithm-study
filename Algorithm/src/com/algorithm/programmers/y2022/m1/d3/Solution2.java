package com.algorithm.programmers.y2022.m1.d3;

import java.util.LinkedList;
import java.util.Queue;

//https://programmers.co.kr/learn/courses/30/lessons/42895#
//정확성  테스트
//    테스트 1 〉	통과 (14.41ms, 82.1MB)
//    테스트 2 〉	통과 (0.47ms, 72MB)
//    테스트 3 〉	통과 (1.28ms, 78MB)
//    테스트 4 〉	통과 (23.23ms, 95.1MB)
//    테스트 5 〉	통과 (18.14ms, 92MB)
//    테스트 6 〉	통과 (1.30ms, 79.4MB)
//    테스트 7 〉	통과 (1.39ms, 72.9MB)
//    테스트 8 〉	통과 (7.33ms, 79.1MB)
//    테스트 9 〉	통과 (0.50ms, 79.4MB)
public class Solution2 {
    public static void main(String[] args) {
        int N = 8;
        int number = 53;
        System.out.println(solution(N, number));
    }

    private static int solution(int N, int number){
        Queue<Node> queue = new LinkedList<>();
        int countNum2 = Integer.parseInt(String.valueOf(N).repeat(2));
        int countNum3 = Integer.parseInt(String.valueOf(N).repeat(3));
        int countNum4 = Integer.parseInt(String.valueOf(N).repeat(4));
        int countNum5 = Integer.parseInt(String.valueOf(N).repeat(5));
        int countNum6 = Integer.parseInt(String.valueOf(N).repeat(6));
        int countNum7 = Integer.parseInt(String.valueOf(N).repeat(7));
        int countNum8 = Integer.parseInt(String.valueOf(N).repeat(8));

        queue.offer(new Node(N,1));
        queue.offer(new Node(countNum2, 2));
        queue.offer(new Node(countNum3, 3));
        queue.offer(new Node(countNum4, 4));
        queue.offer(new Node(countNum5, 5));
        queue.offer(new Node(countNum6, 6));
        queue.offer(new Node(countNum7, 7));
        queue.offer(new Node(countNum8, 8));

        while(!queue.isEmpty()){
            int len = queue.size();
            int count = Integer.MAX_VALUE;
            for(int i = 0; i < len; i++){
                Node node = queue.poll();
                if(node.val == number) {
                    count = Math.min(count, node.count);
                }else{
                    //1개 사용
                    if(node.count < 8) {
                        queue.offer(new Node(node.val * N, node.count + 1));
                        queue.offer(new Node(node.val - N, node.count + 1));
                        queue.offer(new Node(node.val / N, node.count + 1));
                        queue.offer(new Node(node.val + N, node.count + 1));
                    }
                    //2개 사용
                    if(node.count < 7){
                        // NN 사용
                        queue.offer(new Node(node.val * countNum2, node.count + 2));
                        queue.offer(new Node(node.val + countNum2, node.count + 2));
                        queue.offer(new Node(node.val / countNum2, node.count + 2));
                        queue.offer(new Node(node.val - countNum2, node.count + 2));

                        // (N/N) 사용
                        queue.offer(new Node(node.val + 1, node.count + 2));
                        queue.offer(new Node(node.val - 1 , node.count + 2));
                    }
                    for(int j = 3; j < 8; j++){
                        if(node.count <= 8 - j) {
                            int prevCountNum = Integer.parseInt(String.valueOf(N).repeat(j - 1));
                            int currCountNum = Integer.parseInt(String.valueOf(N).repeat(j));

                            offerQueue(node, queue, prevCountNum, currCountNum, N, j);
                        }
                    }
                }
            }
            if(count != Integer.MAX_VALUE) return count;
        }

        return -1;
    }

    private static void offerQueue(Node node, Queue<Node> queue, int prevCountNum, int currCountNum, int N, int count){
        //NNNN 사용
        queue.offer(new Node(node.val * currCountNum, node.count + count));
        queue.offer(new Node(node.val + currCountNum, node.count + count));
        queue.offer(new Node(node.val / currCountNum, node.count + count));
        queue.offer(new Node(node.val - currCountNum, node.count + count));

        // (NN/N)
        queue.offer(new Node(node.val - (prevCountNum / N), node.count + count));
        queue.offer(new Node(node.val + (prevCountNum / N), node.count + count));

        // (NN*N)
        queue.offer(new Node(node.val - (prevCountNum * N), node.count + count));
        queue.offer(new Node(node.val + (prevCountNum * N), node.count + count));
    }
}

class Node{
    int val;
    int count;

    Node(int val, int count){
        this.val = val;
        this.count = count;
    }
}
