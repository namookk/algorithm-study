package com.algorithm.day17;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String m ="ABC";
        String[] musicinfos = {"00:00,00:05,HI,ABC#ABC"};

        System.out.println(solution(m, musicinfos));
    }
    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        m = replaceMusic(m);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for(String musicInfo : musicinfos) {
            String[] infoArr = musicInfo.split(",");
            int diff = getDiff(infoArr[0], infoArr[1]);
            String str = replaceMusic(infoArr[3]);
            String[] mList = str.split("");
            String music = new String(new char[diff/mList.length]).replace("\0", String.join("", str));
            if(diff % mList.length > 0) {
                music += str.substring(0, diff % mList.length);
            }
            int idx = 0;
            while(idx != -1) {
                idx = music.indexOf(m);
                if(idx > -1) {
                    map.put(infoArr[2], diff);
                    idx = -1;
                }
            }
        }
        if(map.keySet().size() == 0) map.put("(None)",0);
        Integer diff = null;
        for(String key : map.keySet()){
            if(diff == null || map.get(key) > diff) {
                answer = key;
                diff = map.get(key);
            }
        }
        return answer;
    }

    public static int getDiff(String start, String end){
        String[] startArr = start.split(":");
        String[] endArr = end.split(":");
        return (Integer.parseInt(endArr[0]) * 60 + Integer.parseInt(endArr[1])) - (Integer.parseInt(startArr[0]) * 60 + Integer.parseInt(startArr[1]));
    }

    public static String replaceMusic(String musicStr) {
        return musicStr.replace("A#","a")
                .replace("C#","c")
                .replace("D#","d")
                .replace("F#","f")
                .replace("G#","g");
    }
}
