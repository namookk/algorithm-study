package com.algorithm.smh.week2;

public class Solution {
    static int[][] ch;
    static int m,n;
    static int[][] dirs = {{1,0}, {-1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        char[][] map = {
                        { '0', '0', '.', '.', '.', '0'},
                        { '0', '.', '.', '.', '0', '0' },
                        { '.', '.', '.', '.', '.', '.' },
                        { '0', '.', '0', '.', '0', '.' },
                        { '0', '.', '.', '.', '.', '.'}
                        };

        System.out.println(solution(map));
    }

    private static int solution(char[][] map){
        int answer = 0;
        m = map.length;
        n = map[0].length;
        ch = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(ch[i][j] == 0 && map[i][j] == '0'){
                    dfs(i, j, map);
                    answer++;
                }
            }
        }

        return answer;
    }

    private static void dfs(int i, int j, char[][] map){
        if(i < 0 || j < 0 || i == m || j == n || ch[i][j] == 1 || map[i][j] == '.') return;
        ch[i][j] = 1;

        for(int[] dir : dirs){
            dfs(i + dir[0], j + dir[1], map);
        }
    }
}
