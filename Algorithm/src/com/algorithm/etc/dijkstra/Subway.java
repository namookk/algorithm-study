package com.algorithm.etc.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subway {

    static Map<String, Integer> distance = new HashMap<>();
    static List<String> visited = new ArrayList<>();

    public static void main(String[] args) {
        List<SubwayNode> nodeList = new ArrayList<>();

        //Test 데이터
        nodeList.add(new SubwayNode("종로3가", "종로5가", 9));
        nodeList.add(new SubwayNode("종로3가", "을지로4가", 10));
        nodeList.add(new SubwayNode("종로3가", "을지로3가", 6));
        nodeList.add(new SubwayNode("종로3가", "종각", 8));
        nodeList.add(new SubwayNode("종로5가", "동대문", 8));
        nodeList.add(new SubwayNode("동대문", "동대문문화역사공원", 7));
        nodeList.add(new SubwayNode("동대문역사문화공원", "을지로4가", 10));
        nodeList.add(new SubwayNode("동대문역사문화공원", "충무로", 13));
        nodeList.add(new SubwayNode("을지로4가", "을지로3가", 6));
        nodeList.add(new SubwayNode("을지로3가", "을지로입구", 8));
        nodeList.add(new SubwayNode("을지로3가", "충무로", 7));
        nodeList.add(new SubwayNode("을지로입구", "시청", 7));
        nodeList.add(new SubwayNode("종각", "시청", 10));
        nodeList.add(new SubwayNode("시청", "서울역", 11));
        nodeList.add(new SubwayNode("서울역", "회현", 9));
        nodeList.add(new SubwayNode("회현", "명동", 7));
        nodeList.add(new SubwayNode("명동", "충무로", 7));

        System.out.println(solution(nodeList, "종로3가", "명동"));
    }

    public static int solution(List<SubwayNode> nodeList, String start, String end) {
        int answer = 0;
        String selected = start;
        distance.put(start, 0);
        visited.add(start);
        while(!selected.equals(end)) {
            int minDistance = Integer.MAX_VALUE;
            String minStation = "";
            for(SubwayNode node : nodeList) {
                if(node.station1.equals(selected) && visited.indexOf(node.station2) == -1) {
                    setDistance(node.station1, node.station2, node.distance);
                }
                if(node.station2.equals(selected) && visited.indexOf(node.station1) == -1) {
                    setDistance(node.station2, node.station1, node.distance);
                }
            }
            for(String station : distance.keySet()) {
                if(visited.indexOf(station) == -1 && minDistance > distance.get(station)) {
                    minStation = station;
                    minDistance = distance.get(station);
                }
            }

            visited.add(minStation);
            selected = minStation;
            System.out.println(selected+"역이 선택되었습니다.");
        }

        for(String station : distance.keySet()) {
            System.out.println(station +"역 까지 가는 최소비용은 "+distance.get(station) +" 입니다.");
        }

        return distance.get(end);
    }

    public static void setDistance(String start, String end, int dist) {
        if(distance.get(end) == null) {
            distance.put(end, distance.get(start) + dist);
        }else{
            if(distance.get(end) > distance.get(start) + dist) {
                distance.put(end, distance.get(start) + dist);
            }
        }
    }
}

class SubwayNode {
    String station1;
    String station2;
    int distance;

    public SubwayNode(String station1, String station2, int _distance){
        this.station1 = station1;
        this.station2 = station2;
        distance = _distance;
    }
}
