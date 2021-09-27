package com.algorithm.inflearn.y2021.m9.d26;
import java.util.*;

public class Main2_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0 ; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, m,  arr));
    }

    public static int solution(int n, int m, int[][] arr) {
        int answer = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++){
                if(i != j) {
                    List<Integer> list = map.get(i);
                    if(list == null) list = new ArrayList<>();
                    list.add(j);
                    map.put(i, list);
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int mento = arr[i][j];
                for(int k = j; k < n; k++){
                    if(k == j) continue;
                    int menti = arr[i][k];
                    List<Integer> list = map.get(menti);
                    list.removeIf(a -> {
                        return a == mento;
                    });
                    map.put(menti, list);
                }
            }
        }
        for(Integer key: map.keySet()) {
            List<Integer> list = map.get(key);
            answer += list.size();
        }

        return answer;
    }
}
