package com.algorithm.inflearn.y2021.m10.d4;

import java.util.*;
import java.util.stream.Collectors;

public class Main5_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print(solution(N, k, arr));
    }

    public static int solution(int N, int k, int[] arr) {
        int answer = 0;
        Queue<Patient> queue = new LinkedList<>();
        List<Integer> riskList = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        for(int i = 0; i < arr.length; i++) {
            queue.offer(new Patient(arr[i], k == i ? true : false));
        }

        while(true) {
            Patient patient = queue.poll();
            if(patient.getRisk().intValue() == riskList.get(0)) {
                answer++;
                if(patient.isMine()) break;
                riskList.remove(0);
            }else{
                queue.offer(patient);
            }
        }

        return answer;
    }
}

class Patient {
    private Integer risk;
    private boolean mine;

    public Patient(Integer _risk, boolean _mine) {
        this.risk = _risk;
        this.mine = _mine;
    }

    public boolean isMine() {
        return mine;
    }
    public Integer getRisk() {
        return risk;
    }
}