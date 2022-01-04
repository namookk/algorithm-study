package com.algorithm.smh.week1;

public class Solution4 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3,4,1,2,3,4,6,2};
        System.out.println(solution(arr));
    }

    private static int solution(int[] arr){
        int answer = 0;
        int[] peeks = new int[arr.length];
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] > arr[i+1]){
                answer = 1;
                peeks[i] = 1;
            }
        }

        for(int i = 2; i < arr.length / 2; i++){
            if(arr.length % i > 0) continue;
            int val = arr.length / i;
            int lt = 0;
            int rt = i;
            int count = 0;
            while(rt <= arr.length){
                for(int j = lt; j < rt; j++){
                    if(peeks[j] == 1) {
                        count++;
                        break;
                    }
                }
                lt += i;
                rt += i;
            }
            if(count == val) return count;
        }


        return answer;
    }
}
