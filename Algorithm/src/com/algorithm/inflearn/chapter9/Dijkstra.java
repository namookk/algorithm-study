package com.algorithm.inflearn.chapter9;

import java.util.*;

public class Dijkstra {
    static int[] dist;
    static int[] ch;

    public static void main(String[] args) {
        int n = 6;
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        ch = new int[n+1];
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(new Node(1, 2, 12));
        nodeList.add(new Node(1, 3, 4));
        nodeList.add(new Node(2, 1, 2));
        nodeList.add(new Node(2, 3, 5));
        nodeList.add(new Node(2, 5, 5));
        nodeList.add(new Node(3, 4, 5));
        nodeList.add(new Node(4, 2, 2));
        nodeList.add(new Node(4, 5, 5));
        nodeList.add(new Node(6, 4, 5));

        solution(n, nodeList);
    }

    public static void solution(int n, List<Node> nodeList) {
        dist[1] = 0;
        int selected = 1;
        while(true) {
            ch[selected] = 1;
            boolean flag = false;
            for(Node node : nodeList) {
                if(node.start == selected && ch[node.end] == 0) {
                    flag = true;
                    if (dist[node.end] == Integer.MAX_VALUE) {
                        dist[node.end] = dist[node.start] + node.distance;
                    } else if (dist[node.end] > dist[node.start] + node.distance) {
                        dist[node.end] = dist[node.start] + node.distance;
                    }
                }
            }
            if(!flag) break;
            int min = Integer.MAX_VALUE;
            for(int i = 1; i < dist.length; i++) {
                if(min > dist[i] && ch[i] == 0) {
                    min = dist[i];
                    selected = i;
                }
            }

        }

        for(int i = 1; i < dist.length; i++) {
            System.out.println(i +"번 노드로 가기위한 최소비용은 " +(dist[i] != Integer.MAX_VALUE ? dist[i] : "impossible")  +"입니다.");
        }


    }
}

class Node{
    int start, end, distance;

    public Node(int _start, int _end, int _distance) {
        start = _start;
        end = _end;
        distance = _distance;
    }
}
