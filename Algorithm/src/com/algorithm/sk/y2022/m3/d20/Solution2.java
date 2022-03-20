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

        PriorityQueue<Job> pq = new PriorityQueue<>((a,b) -> {
            return a.getEndTime() - b.getEndTime();
        });
        Queue<Job> writeSchedule = new LinkedList<>();
        Queue<Job> readSchedule = new LinkedList<>();
        int usingTime = 0;
        int time = 1;
        int idx = 0;

        while(idx < processes.length || !pq.isEmpty()) {
            //작업중인 Job 끝내기
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

                //새로운 Job 스케쥴링 등록
                if (startTime == time) {
                    Job newJob = new Job(idx, command, startTime, duringTime, startIdx, endIdx, changeValue);
                    if (newJob.command.equals("read")) {
                        if(!pq.isEmpty()
                                && pq.peek().command.equals("read")
                                && writeSchedule.isEmpty()) {
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

            //대기중인 Job 시작
            if(pq.isEmpty()) {
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
            if(!pq.isEmpty()) usingTime++; //실제 사용 시간
        }

        answer[answer.length - 1] = usingTime + "";

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
