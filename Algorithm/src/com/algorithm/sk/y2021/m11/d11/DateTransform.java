package com.algorithm.sk.y2021.m11.d11;
import java.util.*;

public class DateTransform {

    public static List<String> transformDateFormat(List<String> dates) {
        List<String> result = new ArrayList<>();
        //YYYY/MM/DD , DD/MM/YYYY, MM-DD-YYYY
        for(String dt : dates) {
            StringBuffer sb = new StringBuffer();
           if(dt.contains("/")){
               String[] arr = dt.split("/");
                if(arr[0].length() == 4 && arr[1].length() == 2 && arr[2].length() == 2 && Integer.parseInt(arr[1]) < 13) {
                    sb.append(arr[0]);
                    sb.append(arr[1]);
                    sb.append(arr[2]);

                    result.add(sb.toString());
                }else if(arr[0].length() == 2 && arr[1].length() == 2 && arr[2].length() == 4 && Integer.parseInt(arr[1]) < 13){
                    sb.append(arr[2]);
                    sb.append(arr[1]);
                    sb.append(arr[0]);

                    result.add(sb.toString());
                }
           }else if(dt.contains("-")){
               String[] arr = dt.split("-");
               if(arr[0].length() == 2 && arr[1].length() == 2 && arr[2].length() == 4 && Integer.parseInt(arr[0]) < 12) {
                   sb.append(arr[2]);
                   sb.append(arr[0]);
                   sb.append(arr[1]);

                   result.add(sb.toString());
               }
           }
        }
        return result;

    }

    public static void main(String[] args) {
        List<String> dates = transformDateFormat(Arrays.asList("2010/02/20", "19/12/2016", "11-18-2012", "20130720"));
        for(String date : dates) {
            System.out.println(date);
        }
    }
}