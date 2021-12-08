package com.algorithm.inflearn2.chapter2;

import java.util.Arrays;

public class Main2_7 {
    public static void main(String[] args) {
        String[] logs = {"dig1 8 2 3 1", "let1 abc cat",
                "dig1 2 5",
                "let2 good dog book", "let3 abc zoo" };

        for(String s : solve(logs)) {
            System.out.println(s);
        }
    }

    public static String[] solve(String[] logs) {
        Arrays.sort(logs, (a,b) -> {
          String[] split1 = a.split(" ", 2);
          String[] split2 = b.split(" ", 2);

          boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
          boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

          if(!isDigit1 && !isDigit2) { //모두 문자
            int comp = split1[1].compareTo(split2[1]);
            if(comp == 0) return split1[0].compareTo(split2[0]);
            else return comp;
          }else if(isDigit1 && isDigit2) { // 모두 숫자
              return 0;
          }else if(isDigit1 && !isDigit2) { // 첫번째는 숫자 두번째는 문자
              return 1;
          }else { //첫번째는 문자 두번째는 숫자
              return -1;
          }
        });

        return logs;

    }
}
