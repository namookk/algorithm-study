package com.algorithm.programmers.y2021.m12.d31;

//https://programmers.co.kr/learn/courses/30/lessons/1829
//정확성  테스트
//        테스트 1 〉	통과 (8.55ms, 85.1MB)
public class Solution2 {
    static int[][] ch;
    static int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    static int row,col;
    static int area;
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        for(int i : solution(m, n, picture)) System.out.print(i +" ");
    }

    public static int[] solution(int m, int n, int[][] picture){
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        ch = new int[m][n];
        row = m;
        col = n;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(ch[i][j] == 0 && picture[i][j] != 0) {
                    area = 0;
                    dfs(i,j,picture, picture[i][j]);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void dfs(int i, int j, int[][] picture, int color){
        if(i < 0 || j < 0 || i == row || j == col || ch[i][j] == 1 || picture[i][j] != color) return;
        ch[i][j] = 1;
        area++;
        for(int[] dir : dirs){
            dfs(i + dir[0], j + dir[1], picture, color);
        }
    }
}
