package com.algorithm.codility.y2022.m1.d3;

public class Solution_4 {
    static boolean result;
    public static void main(String[] args) {
        int[] arr = {16, 16};
        System.out.println(solution(arr));
    }

    private static int solution(int[] arr){
        int len = arr.length;
        for(int i = len; i > 1; i--){
            result = false;
            recursive(arr, 0, i, 0);
            if(result) return i;
        }
        return 1;
    }

    private static void recursive(int[] arr ,int start, int count, int value){
        if(result) return;
        if(count == 0){
            if(value > 0 ) result = true;
            return;
        }
        for (int i = start; i < arr.length; i++) {
            int val = (value > 0 ? arr[i] & value : arr[i]);
            if(val > 0) {
                recursive(arr, i + 1, count - 1, val);
            }
        }
    }
}
