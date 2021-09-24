package com.algorithm.day24;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2_4 {
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
    public static String solution(int n) {
        String answer = "";
        for(int i = 1; i <= n; i++) {
            System.out.print(pibonachi(i) + " ");
        }
        return answer;
    }

    public static int pibonachi(int n) {
        int num = 0;
        if(n <= 2){
            num = 1;
        }else{
            if(map.get(n) != null) return map.get(n);
            else{
                int n2 = 0;
                if(map.get(n-2) != null) n2 = map.get(n-2);
                else{
                    n2 = pibonachi(n - 2);
                    map.put(n - 2, n2);
                }
                int n1 = 0;
                if(map.get(n-1) != null) n1 = map.get(n-1);
                else{
                    n1 = pibonachi(n-1);
                    map.put(n - 1, n1);
                }
                num = n1 + n2;
            }
        }
        return num;
    }

}
