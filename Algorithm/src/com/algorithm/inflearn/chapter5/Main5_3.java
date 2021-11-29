package com.algorithm.inflearn.chapter5;
import java.util.*;

public class Main5_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] box = new int[N][N];
        for(int i = 0; i< box.length; i++) {
            for(int j = 0; j < box[i].length; j++) {
                box[i][j] = sc.nextInt();
            }
        }
        int move = sc.nextInt();
        int[] moves = new int[move];
        for(int i = 0; i < moves.length; i++) {
            moves[i] = sc.nextInt();
        }
        System.out.print(solution(box, moves));
    }

    public static int solution(int[][] box, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int move : moves) {
            int doll = 0;
            for(int i = 0; i < box.length; i++) {
                if(box[i][move-1] > 0) {
                    doll = box[i][move-1];
                    box[i][move-1] = 0;
                    break;
                }
            }
            if(doll > 0) {
                if(stack.size() > 0 && doll == stack.peek()) {
                    stack.pop();
                    answer += 2;
                }else{
                    stack.push(doll);
                }
            }
        }
        return answer;
    }
}