package com.algorithm.programmers.y2022.m1.d10;

import java.util.LinkedList;
import java.util.Queue;

//https://programmers.co.kr/learn/courses/30/lessons/68936
//정확성  테스트
//    테스트 1 〉	통과 (1.02ms, 77.1MB)
//    테스트 2 〉	통과 (0.93ms, 65.9MB)
//    테스트 3 〉	통과 (0.43ms, 75.8MB)
//    테스트 4 〉	통과 (0.29ms, 76.9MB)
//    테스트 5 〉	통과 (102.89ms, 119MB)
//    테스트 6 〉	통과 (59.64ms, 117MB)
//    테스트 7 〉	통과 (28.91ms, 106MB)
//    테스트 8 〉	통과 (20.29ms, 90.6MB)
//    테스트 9 〉	통과 (15.23ms, 98.5MB)
//    테스트 10 〉	통과 (15.72ms, 140MB)
//    테스트 11 〉	통과 (0.18ms, 75.8MB)
//    테스트 12 〉	통과 (0.20ms, 72.7MB)
//    테스트 13 〉	통과 (16.49ms, 93.9MB)
//    테스트 14 〉	통과 (42.38ms, 123MB)
//    테스트 15 〉	통과 (63.17ms, 123MB)
//    테스트 16 〉	통과 (74.58ms, 109MB)
public class Solution {
    public static void main(String[] args) {
        int[][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
        int[] result = solution(arr);
        System.out.println(result[0] +" , " + result[1]);
    }

    private static int[] solution(int[][] arr){
        int oneCnt = 0;
        int zeroCnt = 0;
        Queue<int[][]> queue = new LinkedList<>();
        queue.offer(arr);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                int[][] array = queue.poll();
                int m = array.length;
                boolean flag = true;

                if(m == 1){
                    if(array[0][0] == 1) oneCnt++;
                    else zeroCnt++;
                    continue;
                }

                int num = array[0][0];
                int[][][] new_array = new int[4][m / 2][m / 2];
                // 왼쪽 위
                for(int row = 0; row < m / 2; row++){
                    for(int col = 0; col < m / 2; col++){
                        if(num != array[row][col]) flag = false;
                        new_array[0][row][col] = array[row][col];
                    }
                }
                //오른쪽 위
                for(int row = 0; row < m / 2; row++){
                    for(int col = m / 2; col < m; col++){
                        if(num != array[row][col]) flag = false;
                        new_array[1][row][col - m / 2] = array[row][col];
                    }
                }
                // 왼쪽 아래
                for(int row = m / 2; row < m; row++){
                    for(int col = 0; col < m / 2; col++){
                        if(num != array[row][col]) flag = false;
                        new_array[2][row - m / 2][col] = array[row][col];
                    }
                }
                //오른쪽 아래
                for(int row = m / 2; row < m; row++){
                    for(int col = m / 2; col < m; col++){
                        if(num != array[row][col]) flag = false;
                        new_array[3][row - m/2][col - m/2] = array[row][col];
                    }
                }
                if(flag){
                    if(num == 0) zeroCnt++;
                    else oneCnt++;
                }else{
                    for(int idx = 0; idx < 4; idx++){
                        queue.offer(new_array[idx]);
                    }
                }
            }
        }


        return new int[]{zeroCnt, oneCnt};
    }
}
