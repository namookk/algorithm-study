package com.algorithm.programmers.y2021.m12.d4;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2 {
    public static void main(String[] args) {
        int n = 3;
        String[] recipes = {"SPAGHETTI 3", "FRIEDRICE 2", "PIZZA 8"};
        String[] orders = {"PIZZA 1", "FRIEDRICE 2", "SPAGHETTI 4", "SPAGHETTI 6", "PIZZA 7", "SPAGHETTI 8"};

        System.out.println(solution(n, recipes, orders));
    }
    public static int solution(int n, String[] recipes, String[] orders) {
        int time = 0;
        Map<String, Integer> menu = Arrays.asList(recipes)
                .stream()
                .map(elem -> elem.split(" "))
                .collect(Collectors.toMap(e -> e[0], e -> Integer.parseInt(e[1])));

        List<Order> fires = new ArrayList<>();
        Queue<Order> oq = new LinkedList<>();

        for(int i = 0; i < orders.length; i++) {
            String[] arr = orders[i].split(" ");
            oq.offer(new Order(arr[0], Integer.parseInt(arr[1]), i == orders.length - 1 ? true : false));
        }

        for(int i = 0; i < n; i++) {
            fires.add(null);
        }
        int cnt = 0;
        while(cnt < orders.length) {
            time++;
            for(int i = 0; i < fires.size(); i++) {
                Order cooked = fires.get(i);
                if(cooked != null && cooked.time == time) {
                    if(cooked.last) return time;
                    cooked = null;
                    cnt++;
                }
                Order order = oq.peek();
                if(order != null && order.time <= time && cooked == null ) {
                    oq.poll();
                    fires.set(i, new Order(order.menu, time + menu.get(order.menu), oq.isEmpty() ? true : false));
                }
            }
        }

        return time;
    }
}

class Order{
    String menu;
    int time;
    boolean last;
    Order(String _menu, int _time, boolean _last) {
        menu = _menu;
        time = _time;
        last = _last;
    }

    public void setTime(int _time){
        time = _time;
    }
}
