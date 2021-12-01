package com.algorithm.inflearn.chapter10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main10_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Brick> brickList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            brickList.add(new Brick(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        System.out.println(solution(brickList));
    }

    public static int solution(List<Brick> brickList) {
        int answer = 0;
        int[] dy = new int[brickList.size()];
        Collections.sort(brickList);

        for(int i = 0; i < brickList.size(); i++) {
            Brick curr = brickList.get(i);
            if(i == 0) dy[i] = curr.height;
            else{
                int maxHeight = curr.height;
                for(int j = i-1; j >= 0; j--) {
                    Brick prev = brickList.get(j);
                    if(prev.length > curr.length){
                        maxHeight = Math.max(maxHeight, dy[j] + curr.height);
                    }
                }
                dy[i] = maxHeight;
                answer = Math.max(answer, maxHeight);
            }
        }
        return answer;
    }
}

class Brick implements Comparable<Brick>{
    int length;
    int height;
    int weight;
    Brick(int _length, int _height, int _weight) {
        length = _length;
        height = _height;
        weight = _weight;
    }

    @Override
    public int compareTo(Brick b) {
        return b.weight - this.weight;
    }

    @Override
    public String toString(){
        return this.length +" / " + this.height + " / " + this.weight;
    }
}
