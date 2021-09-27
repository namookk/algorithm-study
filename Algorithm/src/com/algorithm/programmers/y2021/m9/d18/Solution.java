package com.algorithm.programmers.y2021.m9.d18;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String[] files = {"img00-00111.png", "img10.png", "img02.png", "im-g1.png", "IMG 01.GIF", "img2.JPG"};
        System.out.println(String.join(",",solution(files)));
    }

    public static String[] solution(String[] files) {
        String[] answer = {};
        List<FileDto> fileList = new ArrayList<>();
        for(int i = 0; i < files.length; i++) {
            FileDto fileDto = getFileDto(files[i]);
            fileDto.setIdx(i);
            fileList.add(fileDto);
        }

        Comparator<FileDto> headCompare = Comparator.comparing(FileDto::getHead);
        Comparator<FileDto> numberCompare = Comparator.comparing(FileDto::getNumber);
        Comparator<FileDto> idxCompare = Comparator.comparing(FileDto::getIdx);

        fileList.sort(headCompare
                .thenComparing(numberCompare)
                .thenComparing(idxCompare));

        answer = fileList.stream().map(file -> file.getOrgin()).toArray(String[]::new);

        return answer;
    }

    public static FileDto getFileDto(String file) {
        String head = "";
        String number = "";
        String tail = "";
        for(int i = 0 ; i < file.length() ; i++) {
            char c = file.charAt(i);
            if(number.length() == 0 && !Character.isDigit(file.charAt(i))){ // head 채우기
               head += Character.toString(c);
            }else if(head.length() > 0 && number.length() < 5  && tail.length() == 0 && Character.isDigit(file.charAt(i))){ //number 채우기
                number += Character.toString(c);
            }else{ // tail 채우기
                tail += Character.toString(c);
            }

        }



        return new FileDto(head.toLowerCase(), Integer.parseInt(number), tail, file);
    }
}

class FileDto {
    private String head;
    private Integer number;
    private String tail;
    private Integer idx;
    private String orgin;

    public FileDto(String _head, Integer _number, String _tail, String _orgin) {
        head = _head;
        number = _number;
        tail = _tail;
        orgin = _orgin;
    }
    public String getOrgin() {
        return orgin;
    }
    public void setIdx(Integer _idx) {
        idx = _idx;
    }
    public Integer getIdx() {
        return idx;
    }
    public String getHead() {
        return head;
    }
    public Integer getNumber() {
        return number;
    }
    public String getTail() {
        return tail;
    }
}
