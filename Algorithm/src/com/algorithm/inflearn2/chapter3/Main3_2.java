package com.algorithm.inflearn2.chapter3;

public class Main3_2 {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] temperatures2 = {30,40,50,60};

        for(int i : solve(temperatures)) System.out.print(i + " ");
        System.out.println();
        for(int i : solve(temperatures2)) System.out.print(i + " ");
    }

    //Worst Case O(n^2)
    public static int[] solve(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        int lt = 0;
        int rt = 1;
        int cnt = 1;
        while(lt < temperatures.length - 1) {
            if(temperatures[lt] < temperatures[rt]) {
                answer[lt] = cnt;
                cnt = 1;
                lt++;
                rt = lt + 1;
            }else if(rt == temperatures.length -1) {
                answer[lt] = 0;
                cnt = 1;
                lt++;
                rt = lt + 1;
            }else{
                rt++;
                cnt++;
            }
        }

        return answer;
    }
}
