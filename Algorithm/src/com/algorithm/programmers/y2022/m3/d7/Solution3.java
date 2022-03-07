package com.algorithm.programmers.y2022.m3.d7;

import java.util.HashMap;
import java.util.Map;

//https://programmers.co.kr/learn/courses/30/lessons/92341
//정확성  테스트
//    테스트 1 〉	통과 (3.06ms, 73.2MB)
//    테스트 2 〉	통과 (3.61ms, 81.1MB)
//    테스트 3 〉	통과 (4.23ms, 78MB)
//    테스트 4 〉	통과 (5.15ms, 75.4MB)
//    테스트 5 〉	통과 (5.52ms, 77MB)
//    테스트 6 〉	통과 (5.85ms, 79.1MB)
//    테스트 7 〉	통과 (8.90ms, 87.4MB)
//    테스트 8 〉	통과 (9.20ms, 87.5MB)
//    테스트 9 〉	통과 (8.02ms, 78.6MB)
//    테스트 10 〉	통과 (9.77ms, 78.8MB)
//    테스트 11 〉	통과 (12.30ms, 75.4MB)
//    테스트 12 〉	통과 (9.88ms, 80.2MB)
//    테스트 13 〉	통과 (4.00ms, 78.2MB)
//    테스트 14 〉	통과 (3.22ms, 80.3MB)
//    테스트 15 〉	통과 (2.97ms, 76MB)
//    테스트 16 〉	통과 (3.19ms, 75.3MB)
public class Solution3 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] result = solution(fees, records);

        int[] fees2 = {120, 0, 60, 591};
        String[] records2 = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        int[] result2 = solution(fees2, records2);

        int[] fees3 = {1, 461, 1, 10};
        String[] records3 = {"00:00 1234 IN"};
        int[] result3 = solution(fees3, records3);

        for(Integer i : result) System.out.print(i + " ");
        System.out.println();
        for(Integer i : result2) System.out.print(i + " ");
        System.out.println();
        for(Integer i : result3) System.out.print(i + " ");
        System.out.println();
    }

    private static int[] solution(int[] fees, String[] records){
        Map<String, Car> carMap = new HashMap<>();
        for(String record : records) {
            String[] recordSplit = record.split(" ");
            int time = convertTime(recordSplit[0]);
            String number = recordSplit[1];
            String command = recordSplit[2];

            Car car = carMap.getOrDefault(number, new Car(number));
            if(command.equals("IN")) {
                car.in(time);
            }else {
                car.out(time);
            }
            carMap.put(number, car);
        }

        return carMap.values().stream().sorted((a,b) -> a.number.compareTo(b.number))
                .mapToInt(c -> calc(fees, c))
                .toArray()
                ;
    }

    private static int convertTime(String time) {
        String[] timeSplit = time.split(":");
        return Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
    }

    private static int calc(int[] fees, Car car){
        if(car.inTime != null) {
            car.out(23 * 60 + 59);
        }

        if(car.totTime <= fees[0]) return fees[1];
        else{
            int div = (car.totTime - fees[0]) / fees[2];
            int mod = (car.totTime - fees[0]) % fees[2];

            return fees[1] + (mod > 0 ? div + 1 : div) * fees[3];
        }
    }
}

class Car{
    String number;
    Integer inTime;
    int totTime;

    public Car(String number) {
        this.number = number;
    }

    public void out(Integer time){
        this.totTime += (time - inTime);
        this.inTime = null;
    }

    public void in(Integer time){
        this.inTime = time;
    }
}

