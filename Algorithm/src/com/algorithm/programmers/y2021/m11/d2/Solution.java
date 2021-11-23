package com.algorithm.programmers.y2021.m11.d2;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/43164
public class Solution {
    static List<List<String>> answerList = new ArrayList<>();
    public static void main(String[] args) {
       String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
       // String[][] tickets = {{"ICN", "SFO"}, {"SFO", "ATL"}};
       for(String s : solution(tickets)){
           System.out.print(s +" ");
       }
    }

    public static String[] solution(String[][] tickets) {
        Ticket start = new Ticket(null, "ICN", null);
        Queue<Ticket> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Ticket ticket = queue.poll();
                System.out.println(ticket.start + " = start   " + ticket.end +" = end");
                if(ticket.visited.size() == tickets.length){
                    List<String> ansList = new ArrayList<>();
                    ansList.add("ICN");
                    for(int j = 0; j < ticket.visited.size(); j++) {
                        ansList.add(tickets[ticket.visited.get(j)][1]);
                    }
                    answerList.add(ansList);
                }else {
                    for (int j = 0; j < tickets.length; j++) {
                        if (tickets[j][0].equals(ticket.end) && ticket.visited.indexOf(j) == -1) {
                            List<Integer> visited = new ArrayList<>();
                            visited.addAll(ticket.visited);
                            visited.add(j);
                            queue.offer(new Ticket(tickets[j][0], tickets[j][1], visited));
                        }
                    }
                }
            }
        }
        String[][] answerArr = new String[answerList.size()][tickets.length + 1];

        for(int i = 0; i < answerList.size(); i++) {
            for(int j = 0; j < answerList.get(i).size(); j++) {
                answerArr[i][j] = answerList.get(i).get(j);
            }
        }
        Arrays.sort(answerArr, new Comparator<String[]>() {
            @Override
            public int compare(String[] a1, String[] a2) {
                for(int i = 0 ; i < a1.length; i++) {
                    if(a1[i] != a2[i]) {
                        return a1[i].compareTo(a2[i]);
                    }
                }
                return 0;
            }
        });

        return answerArr[0];
    }
}

class Ticket{
    String start, end;
    List<Integer> visited;

    public Ticket(String _start, String _end, List<Integer> _visited) {
        start = _start;
        end = _end;
        if(_visited == null) visited = new ArrayList<>();
        else visited = _visited;
    }
}
