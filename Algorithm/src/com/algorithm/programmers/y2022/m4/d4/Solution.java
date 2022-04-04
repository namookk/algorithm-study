package com.algorithm.programmers.y2022.m4.d4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

  public static void main(String[] args) {
    int[][] dist = {{0,5,2,4,1},{5,0,3,9,6},{2,3,0,6,3},{4,9,6,0,3},{1,6,3,3,0}};

    int[][] result = solution(dist);
    for (int[] arr : result){
      for (int i : arr) {
        System.out.print(i + " ");
      }
      System.out.println();
    }

    int[][] dist2 = {{0,2,3,1},{2,0,1,1},{3,1,0,2},{1,1,2,0}};

    int[][] result2 = solution(dist2);
    for (int[] arr : result2){
      for (int i : arr) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }

  private static int[][] solution(int[][] dist) {
    int[][] result = new int[2][dist.length];
    int maxPoint = 0;
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < dist.length; i++) {
      for(int j = i + 1; j < dist.length; j++) {
        if(dist[j][i] > max) {
          maxPoint = i;
          max = dist[j][i];
        }
      }
    }
    List<Point> list = new ArrayList<>();
    for(int i = 0; i < dist.length; i++) {
      list.add(new Point(i, dist[maxPoint][i]));
    }
    list.sort(Comparator.comparing(Point::getVal));
    for(int i = 0; i < list.size(); i++) {
      Point p = list.get(i);
      result[0][i] = p.idx;
      result[1][dist.length - 1 - i] = p.idx;
    }
    return result;
  }

}

class Point{
  int idx, val;
  Point(int idx, int val){
    this.idx = idx;
    this.val = val;
  }

  public int getVal() {
    return val;
  }
}
