package com.algorithm.sk.y2022.m3.d20;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution2 {
    public static void main(String[] args) {
        String[] arr = {"1","2","4","3","3","4","1","5"};
        String[] processes = {"read 1 3 1 2","read 2 6 4 7","write 4 3 3 5 2","read 5 2 2 5","write 6 1 3 3 9", "read 9 1 0 7"};

        String[] result = solution(arr, processes);
        for(String str : result) System.out.println(str);

        System.out.println();

        String[] arr2 = {"1","1","1","1","1","1","1"};
        String[] processes2 = {"write 1 12 1 5 8","read 2 3 0 2","read 5 5 1 2","read 7 5 2 5","write 13 4 0 1 3","write 19 3 3 5 5","read 30 4 0 6","read 32 3 1 5"};

        String[] result2 = solution(arr2, processes2);
        for(String str : result2) System.out.println(str);
    }

    private static String[] solution(String[] arr, String[] processes) {
        String[] answer = new String[processes.length + 1];

        //우선순위 큐로 작업이 가장 먼저 끝나는 Job을 꺼냄
        PriorityQueue<Job> pq = new PriorityQueue<>((a,b) -> {
            return a.getEndTime() - b.getEndTime();
        });
        //작업 대기열 FIFO를 적용하기 위해 Queue사용
        Queue<Job> writeSchedule = new LinkedList<>();
        Queue<Job> readSchedule = new LinkedList<>();

        int usingTime = 0; //실제 사용 시간
        int time = 1; //현재 시간
        int idx = 0; //process의 idx

        while(idx < processes.length || !pq.isEmpty()) {
            //작업중인 Job 끝내기 ( 꺼내온 작업의 종료시간이 현재시간보다 작거나 같을 경우 작업을 종료해야함 )
            while(!pq.isEmpty() && pq.peek().getEndTime() <= time) {
                Job job = pq.poll();
                System.out.println("processes["+job.idx+"] 작업 종료 시간 = " + job.getEndTime());
                if(job.command.equals("read")) {
                    StringBuffer sb = new StringBuffer();
                    for(int i = job.startIdx; i <= job.endIdx; i++) {
                        sb.append(arr[i]);
                    }
                    answer[job.idx] = sb.toString();
                }else {
                    for(int i = job.startIdx; i <= job.endIdx; i++) {
                        arr[i] = job.changeValue;
                    }
                }
            }

            //신규 작업 판별
            if(idx < processes.length) {
                String process = processes[idx];
                String[] split = process.split(" ");
                String command = split[0];
                int startTime = Integer.parseInt(split[1]);
                int duringTime = Integer.parseInt(split[2]);
                int startIdx = Integer.parseInt(split[3]);
                int endIdx = Integer.parseInt(split[4]);
                String changeValue = command.equals("write") ? split[5] : null;

                //새로운 Job 스케쥴링 등록 새로운 Job의 시작시간이 현재시간일 경우
                if (startTime == time) {
                    Job newJob = new Job(idx, command, startTime, duringTime, startIdx, endIdx, changeValue);
                    if (newJob.command.equals("read")) {
                        if(!pq.isEmpty()
                                && pq.peek().command.equals("read")
                                && writeSchedule.isEmpty()) { //읽기작업이 실행중이고 쓰기대기열이 비어있을 경우 새로운 작업을 바로 시작한다.
                           pq.offer(newJob);
                        }else {
                            readSchedule.offer(newJob);
                        }
                    } else {
                        writeSchedule.offer(newJob);
                    }
                    idx++;
                }
            }

            //진행중인 작업이 없을경우 대기중인 Job 시작
            if(pq.isEmpty()) {
              //시작시 job의 startTime을 현재시간으로 변경
              if(!writeSchedule.isEmpty()) {
                  Job writeJob = writeSchedule.poll();
                  writeJob.startTime = time;
                  pq.offer(writeJob);
              }else {
                  while(!readSchedule.isEmpty()) {
                    Job readJob = readSchedule.poll();
                    readJob.startTime = time;
                    pq.offer(readJob);
                  }
              }
            }

            time++; //현재시간
            if(!pq.isEmpty()) usingTime++; //실제 사용 시간 pq가 비어있지 않을 경우 작업중이므로 usingTime++
        }

        answer[answer.length - 1] = usingTime + "";

        //읽기 process만 리턴해야하므로 != null 필터링 후 리턴
        return Arrays.stream(answer)
                .filter(str -> str != null)
                .toArray(String[]::new);
    }
}

class Job{
    int idx;
    String command;
    int startTime;
    int duringTime;
    int startIdx;
    int endIdx;
    String changeValue;

    public Job(int idx, String command,  int startTime, int duringTime, int startIdx, int endIdx, String changeValue) {
        this.idx = idx;
        this.command = command;
        this.startTime = startTime;
        this.duringTime = duringTime;
        this.startIdx = startIdx;
        this.endIdx = endIdx;
        this.changeValue = changeValue;
    }

    public int getEndTime() {
        return this.startTime + this.duringTime;
    }

}
