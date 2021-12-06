package com.algorithm.inflearn2.chapter1;

import java.util.HashSet;
import java.util.Set;

public class Main1_1 {
    public static void main(String[] args) {
        String[] emails = {
        "test.email+james@coding.com",
                "test.e.mail+toto.jane@coding.com",
                "testemail+tom@cod.ing.com"};

        System.out.println(solve(emails));

    }

    public static int solve(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email : emails) {
            String[] emailArr = email.split("@");
            String local = emailArr[0];
            String domain = emailArr[1];

            String real_local = local.replaceAll("\\.", "").split("\\+")[0];
            set.add(real_local+"@"+domain);
        }

        return set.size();
    }
}
