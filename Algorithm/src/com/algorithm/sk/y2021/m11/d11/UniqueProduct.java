package com.algorithm.sk.y2021.m11.d11;

import java.util.*;

public class UniqueProduct {
    public static String firstUniqueProduct(String[] products) {
        List<String> list = Arrays.asList(products);
        Set<String> set = new LinkedHashSet<String>(list);
        if(set.size() == 0) return null;
        else{
            Iterator<String> iterSet = set.iterator();
            while(iterSet.hasNext()) {
                String s = iterSet.next();
                if(list.indexOf(s) == list.lastIndexOf(s)){
                    return s;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueProduct(new String[] { "Apple", "Computer", "Apple", "Bag"  }));
    }
}