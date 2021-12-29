package com.algorithm.programmers.y2021.m12.d31;

//https://programmers.co.kr/learn/courses/30/lessons/81302#fn1
//정확성  테스트
//    테스트 1 〉	통과 (0.92ms, 76.3MB)
//    테스트 2 〉	통과 (0.91ms, 75.6MB)
//    테스트 3 〉	통과 (0.99ms, 74.9MB)
//    테스트 4 〉	통과 (0.70ms, 74.9MB)
//    테스트 5 〉	통과 (0.95ms, 75.3MB)
//    테스트 6 〉	통과 (0.86ms, 77.8MB)
//    테스트 7 〉	통과 (0.88ms, 65.3MB)
//    테스트 8 〉	통과 (0.98ms, 78.3MB)
//    테스트 9 〉	통과 (3.61ms, 73MB)
//    테스트 10 〉	통과 (0.72ms, 71.4MB)
//    테스트 11 〉	통과 (0.95ms, 80.4MB)
//    테스트 12 〉	통과 (0.96ms, 74.4MB)
//    테스트 13 〉	통과 (1.10ms, 73.3MB)
//    테스트 14 〉	통과 (1.11ms, 73MB)
//    테스트 15 〉	통과 (0.70ms, 73.7MB)
//    테스트 16 〉	통과 (0.77ms, 75.4MB)
//    테스트 17 〉	통과 (1.02ms, 78.4MB)
//    테스트 18 〉	통과 (0.82ms, 71.7MB)
//    테스트 19 〉	통과 (0.72ms, 79.6MB)
//    테스트 20 〉	통과 (1.11ms, 77.2MB)
//    테스트 21 〉	통과 (0.64ms, 72.8MB)
//    테스트 22 〉	통과 (0.95ms, 77.5MB)
//    테스트 23 〉	통과 (1.02ms, 74.5MB)
//    테스트 24 〉	통과 (0.92ms, 74.3MB)
//    테스트 25 〉	통과 (1.22ms, 73.3MB)
//    테스트 26 〉	통과 (0.88ms, 66.7MB)
//    테스트 27 〉	통과 (0.75ms, 74.4MB)
//    테스트 28 〉	통과 (1.11ms, 78.3MB)
//    테스트 29 〉	통과 (0.61ms, 77.6MB)
//    테스트 30 〉	통과 (1.03ms, 75.3MB)

public class Solution {
    static int[][] dirs = {{1,0},{-1,0}, {0, 1}, {0, -1}};
    static int danger = 1;
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        for(int i : solution(places)) System.out.print( i + " ");
    }

    public static int[] solution(String[][] places){
        int[] answer = new int[5];
        for(int i = 0; i < 5; i++){
            String[][] place = new String[5][5];
            for(int j = 0; j < 5; j++){
                place[j] = places[i][j].split("");
            }
            answer[i] = isDanger(place);
        }
        return answer;
    }

    public static int isDanger(String[][] places) {
        danger = 1;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(places[i][j].equals("P")){
                    int[][] ch = new int[5][5];
                    ch[i][j] = 1;
                    dfs(i, j, places, 0, ch);
                    if(danger == 0) return danger;
                }
            }
        }
        return danger;
    }

    public static void dfs(int i, int j, String[][] places, int depth, int[][] ch){
        if(ch[i][j] == 0 && places[i][j].equals("P"))danger = 0;
        else if(places[i][j].equals("X")) return;

        ch[i][j] = 1;
        if(depth < 2){
            for(int[] dir : dirs){
                int newI = i + dir[0];
                int newJ = j + dir[1];
                if(newI >= 0 && newJ >= 0 && newI < 5 && newJ < 5 && ch[newI][newJ] == 0){
                    dfs(newI, newJ, places, depth + 1, ch);
                    ch[newI][newJ] = 0;
                    if(danger == 0) break;
                }
            }
        }
    }
}
