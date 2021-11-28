package com.algorithm.etc.dijkstra;


import java.util.*;
import java.util.stream.Collectors;

enum SubwayStation {
    종로3가(1),
    종로5가(2),
    동대문(3),
    동대문역사문화공원(4),
    을지로4가(5),
    을지로3가(6),
    을지로입구(7),
    시청(8),
    종각(9),
    서울역(10),
    회현(11),
    명동(12),
    충무로(13);

    private final int code;

    SubwayStation( int code) {
        this.code = code;
    }
    public int getCode() { return this.code; }

    private static final Map<Integer, String> subwayStation = Arrays.stream(values())
            .collect(Collectors.toMap(
                    s1 -> s1.getCode(),
                    s2 -> s2.name()
                    )
            );
    public static Map<Integer, String> getSubwayStation() {
        return subwayStation;
    }
}

class SubwayEdge implements Comparable<SubwayEdge>{
    public SubwayStation station;
    public int distance;

    SubwayEdge(SubwayStation station, int distance) {
        this.station = station;
        this.distance = distance;
    }
    @Override
    public int compareTo(SubwayEdge eg) {
        return this.distance - eg.distance;
    }
}

public class Subway2 {
    static ArrayList<ArrayList<SubwayEdge>> graph;
    static int[] dis;

    public static void main(String[] args) {
        Map<Integer, String> stationMap = SubwayStation.getSubwayStation();
        graph = new ArrayList<ArrayList<SubwayEdge>>();
        dis = new int[(stationMap.keySet().size() + 1)];
        for(int i = 0; i <= stationMap.keySet().size(); i++) {
            graph.add(new ArrayList<SubwayEdge>());
        }
        Arrays.fill(dis, Integer.MAX_VALUE);

        graph.get(SubwayStation.종로3가.getCode()).add(new SubwayEdge(SubwayStation.종로5가, 9));
        graph.get(SubwayStation.종로5가.getCode()).add(new SubwayEdge(SubwayStation.종로3가, 9));

        graph.get(SubwayStation.종로3가.getCode()).add(new SubwayEdge(SubwayStation.을지로4가, 10));
        graph.get(SubwayStation.을지로4가.getCode()).add(new SubwayEdge(SubwayStation.종로3가, 10));

        graph.get(SubwayStation.종로3가.getCode()).add(new SubwayEdge(SubwayStation.을지로3가, 6));
        graph.get(SubwayStation.을지로3가.getCode()).add(new SubwayEdge(SubwayStation.종로3가, 6));

        graph.get(SubwayStation.종로3가.getCode()).add(new SubwayEdge(SubwayStation.종각, 8));
        graph.get(SubwayStation.종각.getCode()).add(new SubwayEdge(SubwayStation.종로3가, 8));

        graph.get(SubwayStation.종로5가.getCode()).add(new SubwayEdge(SubwayStation.동대문, 8));
        graph.get(SubwayStation.동대문.getCode()).add(new SubwayEdge(SubwayStation.종로5가, 8));

        graph.get(SubwayStation.동대문.getCode()).add(new SubwayEdge(SubwayStation.동대문역사문화공원, 7));
        graph.get(SubwayStation.동대문역사문화공원.getCode()).add(new SubwayEdge(SubwayStation.동대문, 7));

        graph.get(SubwayStation.동대문역사문화공원.getCode()).add(new SubwayEdge(SubwayStation.을지로4가, 10));
        graph.get(SubwayStation.을지로4가.getCode()).add(new SubwayEdge(SubwayStation.동대문역사문화공원, 10));

        graph.get(SubwayStation.동대문역사문화공원.getCode()).add(new SubwayEdge(SubwayStation.충무로, 13));
        graph.get(SubwayStation.충무로.getCode()).add(new SubwayEdge(SubwayStation.동대문역사문화공원, 13));

        graph.get(SubwayStation.을지로4가.getCode()).add(new SubwayEdge(SubwayStation.을지로3가, 6));
        graph.get(SubwayStation.을지로3가.getCode()).add(new SubwayEdge(SubwayStation.을지로4가, 6));

        graph.get(SubwayStation.을지로3가.getCode()).add(new SubwayEdge(SubwayStation.을지로입구, 8));
        graph.get(SubwayStation.을지로입구.getCode()).add(new SubwayEdge(SubwayStation.을지로3가, 8));

        graph.get(SubwayStation.을지로3가.getCode()).add(new SubwayEdge(SubwayStation.충무로, 7));
        graph.get(SubwayStation.충무로.getCode()).add(new SubwayEdge(SubwayStation.을지로3가, 7));

        graph.get(SubwayStation.을지로입구.getCode()).add(new SubwayEdge(SubwayStation.시청, 7));
        graph.get(SubwayStation.시청.getCode()).add(new SubwayEdge(SubwayStation.을지로입구, 7));

        graph.get(SubwayStation.종각.getCode()).add(new SubwayEdge(SubwayStation.시청, 10));
        graph.get(SubwayStation.시청.getCode()).add(new SubwayEdge(SubwayStation.종각, 10));

        graph.get(SubwayStation.시청.getCode()).add(new SubwayEdge(SubwayStation.서울역, 11));
        graph.get(SubwayStation.서울역.getCode()).add(new SubwayEdge(SubwayStation.시청, 11));

        graph.get(SubwayStation.서울역.getCode()).add(new SubwayEdge(SubwayStation.회현, 9));
        graph.get(SubwayStation.회현.getCode()).add(new SubwayEdge(SubwayStation.서울역, 9));

        graph.get(SubwayStation.회현.getCode()).add(new SubwayEdge(SubwayStation.명동, 7));
        graph.get(SubwayStation.명동.getCode()).add(new SubwayEdge(SubwayStation.회현, 7));

        graph.get(SubwayStation.명동.getCode()).add(new SubwayEdge(SubwayStation.충무로, 7));
        graph.get(SubwayStation.충무로.getCode()).add(new SubwayEdge(SubwayStation.명동, 7));

        solution(SubwayStation.종로3가);



        for(int i = 1; i < dis.length; i++) {
           System.out.println(stationMap.get(i) + "역 까지의 최소거리는 " + dis[i] +" 입니다.");
        }
    }


    public static void solution(SubwayStation station) {
        PriorityQueue<SubwayEdge> pq = new PriorityQueue<>();
        pq.offer(new SubwayEdge(station, 0));
        dis[station.getCode()] = 0;
        while(!pq.isEmpty()) {
            SubwayEdge edge = pq.poll();
            SubwayStation nowStation = edge.station;
            int nowDistance = edge.distance;
            if(nowDistance > dis[nowStation.getCode()]) continue;
            for(SubwayEdge ob : graph.get(nowStation.getCode())) {
                if(dis[ob.station.getCode()] > nowDistance + ob.distance) {
                    dis[ob.station.getCode()] = nowDistance + ob.distance;
                    pq.offer(new SubwayEdge(ob.station, nowDistance + ob.distance));
                }
            }
        }
    }
}
