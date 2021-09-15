package com.algorithm.day15;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public static void main(String[] args) {
       String dirs =  "ULURRDLLU";
       System.out.println(solution(dirs));
    }
    public static int solution(String dirs) {
        int answer = 0;
        int[] curr = {0,0};
        List<Move> moveList = new ArrayList<>();
        String[] dirArr = dirs.split("");
        for(int i = 0 ; i < dirArr.length; i++) {
            String dir = dirArr[i];
            Move move = new Move();
            move.setStart(curr);
            boolean flag = false;
            switch(dir) {
                case "U" :
                    if(curr[1] < 5) {
                        move.goUp();
                        flag = true;
                    }
                    break;
                case "D" :
                    if(curr[1] > -5) {
                        move.goDown();
                        flag = true;
                    }
                    break;
                case "R" :
                    if(curr[0] < 5) {
                        move.goRight();
                        flag = true;
                    }
                    break;
                case "L" :
                    if(curr[0] > -5) {
                        move.goLeft();
                        flag = true;
                    }
                    break;
            }
            if(flag){
                if(moveIndexOf(moveList, move) == -1){
                    answer++;
                }
                moveList.add(move);
                curr = move.getEnd();
            }
        }

        return answer;
    }
    public static int moveIndexOf(List<Move> moveList, Move move) {
        int idx = 0;
        boolean flag = false;

        if(moveList != null && moveList.size() > 0) {
            for(Move mv : moveList){
                if(mv.isEquals(move)) {
                    flag = true;
                    break;
                }
                idx++;
            }
        }

        return flag ? idx : -1;
    }
}

class Move {
    private int[] start = new int[2];
    private int[] end = new int[2];

    public int[] getStart() {
        return start;
    }
    public int[] getEnd() {
        return end;
    }
    public void setStart(int[] _start) {
        start = _start;
    }
    public void setEnd(int[] _end) {
        end = _end;
    }
    public void goDown(){
        end[0] = start[0];
        end[1] = start[1] - 1;
    }
    public void goUp() {
        end[0] = start[0];
        end[1] = start[1] + 1;
    }
    public void goLeft() {
        end[0] = start[0] - 1;
        end[1] = start[1];
    }
    public void goRight(){
        end[0] = start[0] + 1;
        end[1] = start[1];
    }
    public boolean isEquals(Move move) {
        if(move.getStart()[0] == start[0] && move.getStart()[1] == start[1]
            && move.getEnd()[0] == end[0] && move.getEnd()[1] == end[1]) {
            return true;
        }
        if(move.getStart()[0] == end[0] && move.getStart()[1] == end[1]
            && move.getEnd()[0] == start[0] && move.getEnd()[1] == start[1]) {
            return true;
        }
        return false;
    }
    public void printString () {
        System.out.println("start x 좌표 : " + start[0] + ", y좌표 : " + start[1]);
        System.out.println("end x 좌표 : " + end[0] + ", y좌표 : " + end[1]);
    }
}
