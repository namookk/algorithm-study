package com.algorithm.programmers.y2021.m10.d22;

import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/12978
public class Solution {
    public static void main(String[] args) {
        int N = 6;
        int[][] road = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
        int K = 4;

        System.out.println(solution(N, road, K));
    }
    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<Integer> answerList = new ArrayList<>();
        Queue<Road> queue = new LinkedList<>();
        queue.offer(new Road(1 , 0, new ArrayList<Integer>(Arrays.asList(new Integer[]{1})))); //1번 마을은 배달가능
        answerList.add(1);

        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Road startRoad = queue.poll();
                List<int[]> availRoad = availRoad(road, startRoad.roadNum);
                for (int[] arr : availRoad) {
                    int sum = startRoad.dist + arr[2];
                    if (sum <= K) {
                        ArrayList<Integer> visited = (ArrayList<Integer>) startRoad.visited.clone();
                        if (startRoad.roadNum == arr[0] && visited.indexOf(arr[1]) == -1) {
                            if (answerList.indexOf(arr[1]) == -1) {
                                answerList.add(arr[1]);
                            }
                            visited.add(arr[1]);
                            queue.offer(new Road(arr[1], sum, visited));
                        }
                        if (startRoad.roadNum == arr[1] && visited.indexOf(arr[0]) == -1) {
                            if (answerList.indexOf(arr[0]) == -1) {
                                answerList.add(arr[0]);
                            }
                            visited.add(arr[0]);
                            queue.offer(new Road(arr[0], sum, visited));
                        }
                    }
                }
            }
        }

        return answerList.size();
    }

    public static List<int[]> availRoad(int[][] road, int start) {
        List<int[]> availRoadList = new ArrayList<>();
        for(int[] arr : road) {
            if(arr[0] == start || arr[1] == start) {
                availRoadList.add(arr);
            }
        }
        return availRoadList;
    }
}

class Road{
    int roadNum;
    int dist;
    ArrayList<Integer> visited;

    public Road(int _roadNum, int _dist, ArrayList<Integer> _visited) {
        roadNum = _roadNum;
        dist = _dist;
        visited = _visited;
    }

}
