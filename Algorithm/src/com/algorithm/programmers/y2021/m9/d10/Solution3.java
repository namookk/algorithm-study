package com.algorithm.programmers.y2021.m9.d10;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        solution(fees, records);
    }
    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<String, String> inMap = new HashMap<>();
        List<Car> carList = new ArrayList<>();

        for(String record : records) {
            String[] recordArr = record.split(" ");
            String carNum = recordArr[1];
            String time = recordArr[0];
            String command = recordArr[2];
            if(command.equals("IN")){ // 진입
                inMap.put(carNum, time);
            }else{ // 출차 계산
                setUseTime(carList, carNum, inMap.get(carNum), time);
                inMap.remove(carNum);
            }
        }

        if(inMap.size() > 0){
            for(String carNum : inMap.keySet()){
                String start = inMap.get(carNum);
                setUseTime(carList, carNum, start, "23:59");
            }
        }

        carList.sort(Comparator.comparing(Car::getCarNum));
        answer = new int[carList.size()];

        for(int i = 0; i < answer.length; i++){
            Car car = carList.get(i);
            car.calcFee(fees);
            answer[i] = car.getFee();
        }

        return answer;
    }

    public static void setUseTime(List<Car> carList, String carNum, String start, String end){
        String[] startArr = start.split(":");
        String[] endArr = end.split(":");


        int startM = Integer.parseInt(startArr[1]);
        int endM = Integer.parseInt(endArr[1]);

        Integer useTime = ((Integer.parseInt(endArr[0]) * 60 + endM) - (Integer.parseInt(startArr[0]) * 60 + startM));
        boolean isFirst = true;
        if(carList != null && carList.size() > 0){
            for(Car car : carList){
                if(car.getCarNum().equals(carNum)){
                    isFirst = false;
                    car.plusUseTime(useTime);
                }
            }
        }

        if(isFirst){
            Car car = new Car(carNum, 0, useTime);
            carList.add(car);
        }
    }
}

class Car{
    private String carNum;
    private Integer fee;
    private Integer useTime;

    public Car(String _carNum, Integer _fee, Integer _useTime) {
        carNum = _carNum;
        fee = _fee;
        useTime = _useTime;
    }
    public String getCarNum() {
        return carNum;
    }
    public Integer getFee() {
        return fee;
    }
    public void plusUseTime(Integer _useTime) {
        useTime += _useTime;
    }

   public void calcFee(int[] fees){
       fee = fees[1]; // 기본요금
       useTime -= fees[0]; //기본시간

       int unitFeeTime = fees[2];
       int unitFee = fees[3];

       while(useTime > 0) {
           useTime -= unitFeeTime;
           fee += unitFee;
       }
   }
}
