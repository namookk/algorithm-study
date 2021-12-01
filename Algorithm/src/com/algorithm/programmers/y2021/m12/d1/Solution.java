package com.algorithm.programmers.y2021.m12.d1;

import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/42885
/*정확성  테스트
    테스트 1 〉	통과 (15.69ms, 78MB)
    테스트 2 〉	통과 (1.04ms, 79.7MB)
    테스트 3 〉	통과 (10.59ms, 78.4MB)
    테스트 4 〉	통과 (12.29ms, 81.8MB)
    테스트 5 〉	통과 (7.19ms, 82.8MB)
    테스트 6 〉	통과 (3.65ms, 68.9MB)
    테스트 7 〉	통과 (6.10ms, 70.2MB)
    테스트 8 〉	통과 (0.41ms, 71.3MB)
    테스트 9 〉	통과 (0.91ms, 71.4MB)
    테스트 10 〉	통과 (10.50ms, 85MB)
    테스트 11 〉	통과 (10.92ms, 73.9MB)
    테스트 12 〉	통과 (10.65ms, 84.3MB)
    테스트 13 〉	통과 (10.50ms, 77.2MB)
    테스트 14 〉	통과 (1.00ms, 87.7MB)
    테스트 15 〉	통과 (0.45ms, 71.1MB)
효율성  테스트
    테스트 1 〉	실패 (시간 초과)
    테스트 2 〉	실패 (시간 초과)
    테스트 3 〉	실패 (시간 초과)
    테스트 4 〉	통과 (10.14ms, 53.6MB)
    테스트 5 〉	통과 (10.49ms, 54.1MB)*/


// Solution2 풀이로 통과
public class Solution {
    public static void main(String[] args) {
        int[] people = {70, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
        System.out.println(solution2(people, limit)); // 재풀이
    }
    public static int solution2(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int lt = people.length - 1;
        int rt = 0;

        int len = people.length;

        for(int i = 0; i < people.length; i++) {
            if(people[lt] <= limit/2) {
                answer += len % 2 == 0 ? len / 2 : len / 2 + 1;
                break;
            }
            if(people[lt] + people[rt] > limit){
                lt--;
                len--;
            }else {
                lt--;
                rt++;
                len -= 2;
            }
            answer++;
        }

        return answer;
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        int[] ch = new int[people.length];
        Arrays.sort(people);
        for(int i = 0; i < people.length; i++) {
            if(ch[i] == 1) continue;
            int sum = people[i];
            ch[i] = 1;
            for(int j = people.length - 1; j > i; j--) {
                if(ch[j] == 1) continue;
                if(sum + people[j] <= limit) {
                    sum += people[j];
                    ch[j] = 1;
                }

                if(limit - sum < people[i+1]) break;
            }
            answer++;
        }

        return answer;
    }
}
