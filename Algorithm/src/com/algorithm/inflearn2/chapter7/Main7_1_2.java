package com.algorithm.inflearn2.chapter7;

import java.util.LinkedList;
import java.util.Queue;

public class Main7_1_2 {
    static int answer;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int[][] ch;
    static int m,n;

    public static void main(String[] args) {
        int[][] grid =  {
                {1,1,1,1,0},
                {1,1,1,1,0},
                {1,1,0,0,0},
                {0,0,0,0,0}
        };

        int[][] grid2 = {
                {1, 1, 0 ,0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1}
        };

        System.out.println(solve_dfs(grid));
        System.out.println(solve_dfs(grid2));

        System.out.println();

        System.out.println(solve_bfs(grid));
        System.out.println(solve_bfs(grid2));

    }

    public static int solve_dfs(int[][] grid) {
        answer = 0;
        m = grid.length;
        n = grid[0].length;
        ch = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && ch[i][j] == 0) {
                    answer++;
                    dfs(grid, i, j);
                }
            }
        }

        return answer;
    }

    public static void dfs(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] != 1 || ch[i][j] == 1) return;
        ch[i][j] = 1;

        for(int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }


    //=====================================================


    public static int solve_bfs(int[][] grid) {
        answer = 0;
        m = grid.length;
        n = grid[0].length;
        int[][] ch = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && ch[i][j] == 0) {
                    answer++;

                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    while(!queue.isEmpty()) {
                        int len = queue.size();
                        for(int k = 0; k < len; k++) {
                            int[] arr = queue.poll();
                            ch[arr[0]][arr[1]] = 1;

                            for(int[] dir : dirs) {
                                int x = arr[0] + dir[0];
                                int y = arr[1] + dir[1];

                                if(x < 0 || y < 0 || x == m || y == n || ch[x][y] == 1 || grid[x][y] == 0) continue;
                                queue.offer(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}
