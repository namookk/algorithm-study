package com.algorithm.sk.y2022.m3.d15;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

  public static void main(String[] args) {
    print(solution(5, true));
    print(solution(6, false));
    print(solution(9, false));

  }

  private static void print(int[][] array) {
    for(int[] a : array) {
      for(int b : a) {
        System.out.print(b + " ");
      }
      System.out.println();
    }
  }

  private static int[][] solution(int n, boolean clockwide) {
    int[][] result = new int[n][n];
    Queue<Point> queue = new LinkedList<>();
    queue.offer(new Point(0,0, 1, clockwide ? 'R' : 'D'));
    queue.offer(new Point(0, n - 1, 1, clockwide ? 'U' : 'R'));
    queue.offer(new Point(n - 1,n - 1, 1, clockwide ? 'L' : 'U'));
    queue.offer(new Point(n - 1,0, 1, clockwide ? 'D' : 'L'));

    result[0][0] = 1;
    result[0][n-1] = 1;
    result[n-1][n-1] = 1;
    result[n-1][0] = 1;

    while(!queue.isEmpty()) {
      int len = queue.size();
      for(int i = 0; i < len; i++) {
        Point point = queue.poll();
        point.next(n, result, clockwide);
        if(result[point.y][point.x] > 0) continue;
        else {
          point.num++;
          result[point.y][point.x] = point.num;
          queue.offer(point);
        }
      }
    }

    return result;
  }
}

class Point{
  int x,y,num;
  char direction;

  Point(int x, int y, int num, char direction) {
    this.x = x;
    this.y = y;
    this.num = num;
    this.direction = direction;
  }

  void next(int n, int[][] result, boolean clockwide){
    switch(this.direction) {
      case 'R':
        if(this.x + 1 < n && result[this.y][this.x + 1] == 0) {
          this.x++;
        }else{
          if(clockwide) {
            this.y++;
            this.direction = 'D';
          }else {
            this.y--;
            this.direction = 'U';
          }
        }
        break;
      case 'D':
        if(this.y + 1 < n && result[this.y + 1][this.x] == 0) {
          this.y++;
        }else {
          if (clockwide) {
            this.x--;
            this.direction = 'L';
          } else {
            this.x++;
            this.direction = 'R';
          }
        }
        break;
      case 'L':
        if(this.x > 0 && result[this.y][this.x - 1] == 0) {
          this.x--;
        }else{
          if (clockwide) {
            this.y--;
            this.direction = 'U';
          } else
            this.y++;
          this.direction = 'D';
        }
        break;
      case 'U':
        if(this.y > 0 && result[this.y - 1][this.x] == 0) {
          this.y--;
        }else {
          if (clockwide) {
            this.x++;
            this.direction = 'R';
          }else {
            this.x--;
            this.direction = 'L';
          }
        }
        break;
      default:
        break;
    }
  }
}