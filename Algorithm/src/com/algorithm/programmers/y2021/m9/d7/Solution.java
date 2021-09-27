package com.algorithm.programmers.y2021.m9.d7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] weights = {50,82,75,120};
        String[] head2head = {"NLWL","WNLL","LWNW","WWLN"};
        int[] answer = solution(weights, head2head);
        for(int ans : answer){
            System.out.println(ans);
        }
    }

    public static int[] solution(int[] weights, String[] head2head) {
        int[] answer = {};
        final char WIN = 'W';
        final char LOSE = 'L';
        final char NONE = 'N';
        List<BoxerDto> boxerList = new ArrayList<>();

        for(int i = 0; i < head2head.length; i++){
            String record = head2head[i];
            int myWeight = weights[i];
            int winCnt = 0;
            int higherWin = 0;
            int fightCnt = 0;
            for(int j = 0; j < record.length(); j++){
                if(record.charAt(j) != NONE){
                    fightCnt++;
                    if(record.charAt(j) == WIN){
                        winCnt++;
                        if(myWeight < weights[j]) higherWin++;
                    }
                }
            }
            double winRatio = 0.0;
            if(fightCnt > 0){
                winRatio = (double) winCnt / (double) fightCnt * 100;
            }
            BoxerDto boxer = new BoxerDto(i+1, higherWin, winRatio, myWeight);
            boxerList.add(boxer);
        }

        Comparator<BoxerDto> winRatioCompare = Comparator.comparing(BoxerDto::getWinRatio).reversed();
        Comparator<BoxerDto> higherWinCompare = Comparator.comparing(BoxerDto::getHigherWin).reversed();
        Comparator<BoxerDto> weightCompare = Comparator.comparing(BoxerDto::getWeight).reversed();
        Comparator<BoxerDto> numCompare = Comparator.comparing(BoxerDto::getNum);

        boxerList.sort(winRatioCompare
                .thenComparing(higherWinCompare)
                .thenComparing(weightCompare)
                .thenComparing(numCompare)
        );

        answer = boxerList.stream().map(boxer -> {
            return boxer.getNum();
        }).mapToInt(Integer::intValue).toArray();

        return answer;
    }
}


class BoxerDto{
    private Integer num; // 번호
    private Integer higherWin; //자기보다 무게가 많이 나가는 사람을 이긴 회수
    private Double winRatio; // 승률
    private Integer weight; //자기 몸무게

    public BoxerDto(Integer _num, Integer _higherWin, Double _winRatio, Integer _weight){
        this.num = _num;
        this.higherWin = _higherWin;
        this.winRatio = _winRatio;
        this.weight = _weight;
    }

    public Integer getNum (){
        return num;
    }
    public Integer getHigherWin () {
        return higherWin;
    }
    public Double getWinRatio () {
        return winRatio;
    }
    public Integer getWeight () {
        return weight;
    }
}
