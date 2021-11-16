package com.algorithm.inflearn.y2021.m11.d16;

import java.util.*;
import java.util.stream.Collectors;

public class Main8_8 {
    static List<List<Integer>> combinationList = new ArrayList<>();
    static int n,k;
    static String answer = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        System.out.println(solution());
    }

    public static String solution() {
        setCombination(new int[n+1], new ArrayList<Integer>());
        return answer;
    }

    public static void setCombination(int[] ch, List<Integer> list){
        if(answer != null) return;
        if(list.size() == n) {
            List<Integer> combination = new ArrayList<>(list);
            Collections.copy(combination, list);
            Queue<Integer> queue = new LinkedList<>();
            for(Integer num : list) {
                queue.offer(num);
            }

            while(!queue.isEmpty()) {
                int len = queue.size();
                int prev = queue.poll();
                if(queue.isEmpty()){
                    if(prev == k) answer = list.stream().map(String::valueOf).collect(Collectors.joining(" "));
                    break;
                }
                for(int i = 0; i < len -1; i++) {
                    int curr = queue.poll();
                    queue.offer(prev + curr);
                    prev = curr;
                }
            }
        }else {
            List<Integer> copyList = new ArrayList<>(list);
            Collections.copy(copyList, list);
            for (int i = 1; i <= n; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    copyList.add(i);
                    setCombination(ch, copyList);
                    ch[i] = 0;
                    copyList.remove( copyList.size() - 1);
                }
            }
        }
    }
}
