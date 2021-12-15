package com.algorithm.inflearn2.chapter7;

public class Main7_8 {
    static boolean answer = false;
    static int m,n;
    static int[][] ch;
    static int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    static String word;
    static String org_word;
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        word = "ABCCED";
        org_word = word;
        System.out.println(solve(board));
    }

    public static boolean solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        ch = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(word.charAt(0) == board[i][j] && ch[i][j] == 0 ) {
                    dfs(board, i, j);
                    if(word.length() > 0) word = org_word;
                    else return true;
                }
            }
        }

        return answer;
    }

    public static void dfs(char[][] board, int i, int j) {
        if(word.length() == 0){
            answer = true;
        }else{
            if(i < 0 || j < 0 || i == m || j == n || word.charAt(0) != board[i][j] || ch[i][j] == 1) return;
            ch[i][j] = 1;
            word = word.substring(1, word.length());

            for(int[] dir : dirs) {
                dfs(board, i + dir[0], j + dir[1]);
            }
        }
    }
}
