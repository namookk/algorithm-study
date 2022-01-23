package com.algorithm.baekjoon.silver5;

import java.util.*;

public class Solution_2246 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Condo> condoList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int dist = sc.nextInt();
            int price = sc.nextInt();
            condoList.add(new Condo(dist, price));
        }

        List<Condo> priceCondoList = new ArrayList<>(condoList);
        List<Condo> distCondoList = new ArrayList<>(condoList);


        Collections.sort(priceCondoList, (a,b) -> {
            if(a.price == b.price) return b.dist - a.dist;
            return b.price - a.price;
        });
        Collections.sort(distCondoList, (a,b) -> {
            if(a.dist == b.dist) return b.price - a.price;
            return b.dist - a.dist;
        });

        int answer = 0;
        int minPrice = Integer.MAX_VALUE;
        int size = condoList.size();
        for (int i = 0; i < size; i++) {
            Condo condo = condoList.get(i);
            boolean flag = true;
            int priceIdx = priceCondoList.indexOf(condo);
            for (int j = priceIdx + 1; j < size; j++) {
                Condo condo2 = priceCondoList.get(j);
                if(condo2.price < condo.price){
                    if(condo2.dist <= condo.dist){
                        flag = false;
                        break;
                    }
                }
            }
            if(!flag) continue;
            int distIdx = distCondoList.indexOf(condo);
            for (int j = distIdx + 1; j < size; j++) {
                Condo condo2 = priceCondoList.get(j);
                if(condo2.dist < condo.dist){
                    if(condo2.price <= condo.price){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) answer++;
        }

        System.out.println(answer);
    }
}

class Condo{
    int dist;
    int price;

    Condo(int dist, int price){
        this.dist = dist;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Condo condo = (Condo) o;
        return dist == condo.dist && price == condo.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dist, price);
    }
}
