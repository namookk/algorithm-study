package com.algorithm.inflearn.chapter7;

import java.util.ArrayList;
import java.util.List;

public class Main7_6 {
    public static void main(String[] args) {
        solution(3);
    }

    public static void solution(int n) {
        List<String> answer = new ArrayList<>();
        Tree tree = new Tree(n);
        tree.dfs(1);
    }
}

class Tree{
    int max;
    boolean[] flags;

    public Tree(int _max) {
        max = _max;
        flags = new boolean[max+1];
    }

    public void dfs(int num) {
        if(num == max + 1) {
            String result =  "";
            for(int i = 1; i <= max; i++) {
                if(flags[i]) result += i + " ";
            }
            if(result.length() > 0) System.out.println(result);
        }else{
            flags[num] = true;
            dfs(num + 1);
            flags[num] = false;
            dfs(num + 1);
        }
    }
}
