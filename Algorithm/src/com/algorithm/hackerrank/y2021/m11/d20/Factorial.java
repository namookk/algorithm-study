package com.algorithm.hackerrank.y2021.m11.d20;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        Result.extraLongFactorials(30);
    }
}

class Result {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */
    static BigInteger answer = BigInteger.valueOf(1);
    public static void extraLongFactorials(int n) {
        // Write your code here
        if(n == 1){
            System.out.println(answer);
        }else{
            answer = answer.multiply(BigInteger.valueOf(n));
            extraLongFactorials(n-1);
        }
    }

}

