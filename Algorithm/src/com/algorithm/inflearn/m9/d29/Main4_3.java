package com.algorithm.inflearn.m9.d29;
import java.util.*;

public class Main4_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(Integer i : solution(k, arr)) {
            System.out.print( i +" ");
        }
    }

    public static List<Integer> solution(int k, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> kindMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for(Integer money : arr) {
            queue.offer(money);
            Integer cnt = kindMap.get(money);
            if(cnt == null) cnt = 0;
            cnt++;
            kindMap.put(money, cnt);
            if(queue.size() > k) {
                Integer prevKey = queue.poll();
                Integer prevCnt = kindMap.get(prevKey);
                if(prevCnt != null) {
                    if(prevCnt > 1) {
                        prevCnt--;
                        kindMap.put(prevKey, prevCnt);
                    }else{
                        kindMap.remove(prevKey);
                    }
                }
            }
            if(queue.size() == k) {
                answer.add(kindMap.size());
            }
        }
        return answer;
    }
}