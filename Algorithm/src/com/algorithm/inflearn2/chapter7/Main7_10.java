package com.algorithm.inflearn2.chapter7;

import java.util.LinkedList;
import java.util.Queue;

public class Main7_10 {
    static int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean answer;
    public static void main(String[] args) {
        int[][] maze = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        int[][] maze2 = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };

        int[] start = {0,4};
        int[] destination = {4,4};

        int[] start2 = {0,4};
        int[] destination2 = {3,2};

        System.out.println(solve_dfs(maze, start, destination));
        System.out.println(solve_dfs(maze2, start2, destination2));
        System.out.println(solve_bfs(maze, start, destination));
        System.out.println(solve_bfs(maze2, start2, destination2));
    }

    public static boolean solve_dfs(int[][] maze, int[] start, int[] destination) {
        answer = false;
        int[][] ch = new int[maze.length][maze[0].length];
        dfs(maze, destination, ch, start[0], start[1]);
        return answer;
    }

    public static void dfs(int[][] maze,int[] destination, int[][] ch, int i, int j){
        if(i < 0 || j < 0 || i == maze.length || j == maze[0].length || maze[i][j] == 1 || ch[i][j] == 1) return;
        ch[i][j] = 1;
        if(i == destination[0] && j == destination[1]) {
            answer = true;
        }else{
            for(int[] dir : dirs) {
                dfs(maze, destination, ch, i + dir[0], j + dir[1]);
                if(answer) break;
            }
        }
    }

    // ======================================================
    public static boolean solve_bfs(int[][] maze, int[] start, int[] destination) {
        Queue<int[][]> chq = new LinkedList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        int[][] ch = new int[maze.length][maze[0].length];
        ch[start[0]][start[1]] = 1;
        chq.offer(ch);

        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int[][] visited = chq.poll();
                int[] point = queue.poll();
                if(point[0] == destination[0] && point[1] == destination[1]) return true;
                for(int[] dir : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    if(x >= 0 && y >=0 && x < maze.length && y < maze[0].length && maze[x][y] == 0 && visited[x][y] == 0) {
                        queue.offer(new int[]{x,y});
                        visited[x][y] = 1;
                        chq.offer(visited);
                    }
                }
            }
        }

        return false;
    }
}
