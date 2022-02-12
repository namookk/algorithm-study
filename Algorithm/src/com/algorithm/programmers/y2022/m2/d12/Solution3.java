package com.algorithm.programmers.y2022.m2.d12;

public class Solution3 {
    public static void main(String[] args) {
        int[] A = {7, 4, -2, 4, -2, -9};
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        int answer = 0;
        int len = A.length;
        int lt = 0;
        int rt = 0;

        while(rt < len) {
            int length = (rt - lt + 1);

            if(length % 2 == 0  && A[lt+1] == A[rt]){ //길이가 짝수일 때
                answer = Math.max(answer, length);
                rt++;
            }else if(length % 2 == 1  && A[lt] == A[rt]){ //길이가 홀수일 때
                answer = Math.max(answer, length);
                rt++;
            }else{
                lt = rt - 1;
                rt++;
            }
        }

        return answer;
    }
}
