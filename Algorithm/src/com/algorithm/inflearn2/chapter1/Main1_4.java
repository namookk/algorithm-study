package com.algorithm.inflearn2.chapter1;

public class Main1_4 {
    public static void main(String[] args) {
        int[] digits = {1,2,3};
        int[] digits2 = {9,9,9};

        for(int i : solve2(digits)) System.out.print(i +" ");
        System.out.println();
        for(int i : solve2(digits2)) System.out.print(i +" ");

    }

    public static int[] solve(int[] digits) {
        StringBuffer sb = new StringBuffer();
        for(int digit : digits) sb.append(digit +"");
        Integer num = Integer.parseInt(sb.toString()) + 1;
        String numStr = num.toString();
        int[] answer = new int[numStr.length()];
        for(int i = 0; i < numStr.length(); i++) {
            char c = numStr.charAt(i);
            answer[i] = Character.getNumericValue(c);
        }
        return answer;
    }

    public static int[] solve2(int[] digits) {
        int n = digits.length;
        for(int i = n-1; i >= 0; i--) {
            digits[i]++;
            if(digits[i] < 10) {
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[n+1];
        result[0] = 1;

        return result;
    }
}
