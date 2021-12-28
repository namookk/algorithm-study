package com.algorithm.programmers.y2021.m12.d29;
//https://programmers.co.kr/learn/courses/30/lessons/17679
//정확성  테스트
//    테스트 1 〉	통과 (0.19ms, 75.5MB)
//    테스트 2 〉	통과 (0.40ms, 77.8MB)
//    테스트 3 〉	통과 (0.02ms, 75.4MB)
//    테스트 4 〉	통과 (13.38ms, 84.2MB)
//    테스트 5 〉	통과 (24.80ms, 104MB)
//    테스트 6 〉	통과 (14.13ms, 90.5MB)
//    테스트 7 〉	통과 (5.07ms, 76.8MB)
//    테스트 8 〉	통과 (9.52ms, 81.5MB)
//    테스트 9 〉	통과 (0.21ms, 73.5MB)
//    테스트 10 〉	통과 (2.96ms, 76.2MB)
//    테스트 11 〉	통과 (15.09ms, 91.3MB)
public class Solution {
    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};


        int m2 = 4;
        int n2 = 5;
        String[] board2 = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(m2, n2, board2));
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        int cnt = 0;
        int[][] ch = new int[m][n];
        while(true){
           for(int i = 0; i < m-1; i++){
               for(int j = 0; j < n-1; j++){
                   char c1 = board[i].charAt(j);
                   if(c1 == 'X') continue;
                   char c2 = board[i+1].charAt(j);
                   char c3 = board[i].charAt(j+1);
                   char c4 = board[i+1].charAt(j+1);
                   if(c1 == c2 && c2 == c3 && c3 == c4){
                       if(ch[i][j] == 0) {
                           ch[i][j] = 1;
                           cnt++;
                       }
                       if(ch[i][j+1] == 0) {
                           ch[i][j+1] = 1;
                           cnt++;
                       }
                       if(ch[i+1][j] == 0) {
                           ch[i+1][j] = 1;
                           cnt++;
                       }
                       if(ch[i+1][j+1] == 0) {
                           ch[i+1][j+1] = 1;
                           cnt++;
                       }
                   }
               }
           }
           if(cnt == 0) break;
           board = moveDown(board, ch);
           ch = new int[m][n];
           answer += cnt;
           cnt = 0;
        }

        return answer;
    }

    public static String[] moveDown(String[] board, int[][] ch){
        for(int i = 0; i < ch[0].length; i++){
            for(int j = 0; j < ch.length; j++){
                if(ch[j][i] == 1){
                    for(int k = j; k > 0; k--){
                       String s = String.valueOf(board[k-1].charAt(i));
                       StringBuffer sb1 = new StringBuffer(board[k]);
                       StringBuffer sb2 = new StringBuffer(board[k-1]);
                       board[k] = sb1.replace(i, i+1, s).toString();
                       board[k-1] = sb2.replace(i, i+1, "X").toString();
                    }
                }
            }
        }

        return board;
    }
}
