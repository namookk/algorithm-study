package com.algorithm.hackerrank.y2022.m1.d12;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'quartiles' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> quartiles(List<Integer> arr) {
        // Write your code here
        List<Integer> answer = new ArrayList<>();
        Collections.sort(arr);
        List<Integer> lowerList = new ArrayList<>();
        List<Integer> upperList = new ArrayList<>();
        for(int i = 0; i < arr.size() / 2; i++){
            lowerList.add(arr.get(i));
        }
        for(int i = (arr.size() % 2 == 0 ? arr.size() / 2 : arr.size() / 2 + 1); i < arr.size(); i++){
            upperList.add(arr.get(i));
        }
        answer.add(getMedian(lowerList));
        answer.add(getMedian(arr));
        answer.add(getMedian(upperList));

        return answer;
    }

    private static Integer getMedian(List<Integer> list){
        if(list.size() % 2 == 0){
            int sum = list.get(list.size() / 2) + list.get(list.size() / 2 - 1);
            return sum / 2;
        }else{
            return list.get(list.size() / 2);
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> data = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> res = Result.quartiles(data);
        for(int i : res) System.out.print(i + " ");
//        bufferedWriter.write(
//                res.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

