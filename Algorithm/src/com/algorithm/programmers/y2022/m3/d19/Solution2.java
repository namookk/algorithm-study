package com.algorithm.programmers.y2022.m3.d19;

public class Solution2 {
    public static void main(String[] args) {
        int[] black_caps = {1, 1, 2, 0};
        int[] result = solution(black_caps);
        for(int i : result) System.out.print(i + " ");

        System.out.println();

        int[] black_caps2 = {1, 1, 1};
        int[] result2 = solution(black_caps2);
        for(int i : result2) System.out.print(i + " ");
    }

    private static int[] solution(int[] black_caps) {
        int len = black_caps.length;
        int[] people = new int[len];
        people[1] = black_caps[0] == 1 ? 1 : 2;
        people[len - 2] = black_caps[len - 1] == 1 ? 1 : 2;

        //확실한 사람 판별 개수가 0이거나 2이거나
        for(int i = 0; i < len; i++) {
            if(black_caps[i] == 2) {
                people[i - 1] = 1;
                people[i + 1] = 1;
            }
            if(black_caps[i] == 0) {
                if(i > 0) people[i - 1] = 2;
                if(i < len - 1) people[i + 1] = 2;
            }
        }

        //UP
        for(int i = 0; i < len - 2; i++) {
            if(people[i] == 0) {
                if(people[i + 2] == 1) people[i] = 2;
                if(people[i + 2] == 2) people[i] = 1;
            }
        }

        //DOWN
        for(int i = len - 1; i >= 2; i--) {
            if(people[i] == 0) {
                if(people[i - 2] == 1) people[i] = 2;
                if(people[i - 2] == 2) people[i] = 1;
            }
        }

        return people;
    }
}
