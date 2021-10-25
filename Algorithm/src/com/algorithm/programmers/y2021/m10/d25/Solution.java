package com.algorithm.programmers.y2021.m10.d25;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};

        System.out.println(solution(k, dungeons));
    }
    public static int solution(int k, int[][] dungeons) {
        int answer = 0;
        Queue<Node> queue = new LinkedList<>();
        List<Integer> availList = getAvailIdxList(k, new int[dungeons.length], dungeons);
        for (Integer i : availList) {
            Node node = new Node(k, dungeons[i], null, dungeons.length);
            node.doVisit(i);
            queue.offer(node);
        }

        while(!queue.isEmpty()) {
            answer++;
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Node node = queue.poll();
                for(Integer idx : getAvailIdxList(node.curr, node.visited, dungeons)) {
                    int[] copy_visited = Arrays.copyOf(node.visited, node.visited.length);
                    Node nd = new Node(node.curr, dungeons[idx], copy_visited, dungeons.length);
                    nd.doVisit(idx);

                    queue.offer(nd);
                }
            }
        }

        return answer;
    }
    public static List<Integer> getAvailIdxList(int curr, int[] visited, int[][] dungeons) {
        List<Integer> availList = new ArrayList<>();
        for(int i = 0 ; i < dungeons.length; i++) {
            if(visited[i] == 0 && curr - dungeons[i][0] >= 0) {
                availList.add(i);
            }
        }
        return availList;
    }
}

class Node{
    int curr;
    int[] dungeon;
    int[] visited;

    public Node(int _curr, int[] _dungeon, int[] _visited, int len) {
        curr = _curr - _dungeon[1];
        dungeon = _dungeon;
        if(_visited == null) {
            visited = new int[len];
        }else {
            visited = _visited;
        }
    }
    public void setVisited(int[] _visited) {
        visited = _visited;
    }
    public void doVisit(int idx) {
        visited[idx] = 1;
    }
}
