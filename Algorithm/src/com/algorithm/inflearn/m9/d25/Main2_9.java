package com.algorithm.inflearn.m9.d25;
import java.util.*;

public class Main2_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        System.out.println(solution(n, arr));
    }

    public static int solution(int n, int[][] arr) {
        int rowSumMax = Integer.MIN_VALUE;
        int colSumMax = Integer.MIN_VALUE;
        int crossSumMax = 0;
        int[] crossArr = new int[n];
        int[] crossArr2 = new int[n];
        for(int i = 0; i < n; i++) {
            int[] rowArr = new int[n];
            for(int j = 0; j < n; j++) {
                rowArr[j] = arr[j][i];
            }
            int colSum = Arrays.stream(arr[i]).sum();
            if(colSumMax < colSum) colSumMax = colSum;
            int rowSum = Arrays.stream(rowArr).sum();
            if(rowSumMax < rowSum) rowSumMax = rowSum;

            crossArr[i] = arr[i][i];
            crossArr2[i] = arr[n-1-i][n-1-i];
        }
        crossSumMax = Math.max(Arrays.stream(crossArr).sum(), Arrays.stream(crossArr2).sum());
        return Math.max(colSumMax,Math.max(rowSumMax,crossSumMax));
    }
}