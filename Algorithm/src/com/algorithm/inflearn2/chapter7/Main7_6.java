package com.algorithm.inflearn2.chapter7;

public class Main7_6 {
    static int answer = 0;
    static int[][] ch;
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int m,n;
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 1}, {0, 1, 1, 0, 0}, {0, 0, 0, 0, 0}, {1, 1,0,1,1}, {1, 0,1,1,1}, {1, 0,1,1,1}};

        System.out.println(solve(grid));
    }

    public static int solve(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        m = grid.length;
        n = grid[0].length;
        ch = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && ch[i][j] == 0) {
                    dfs(grid, i, j, 1);
                }
            }
        }
        return answer;
    }

    public static void dfs(int[][] grid, int i, int j, int cnt) {
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == 0 || ch[i][j] == 1) return;
        answer = Math.max(answer, cnt);
        ch[i][j] = 1;
        for(int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1], cnt+1);
        }
    }
}
