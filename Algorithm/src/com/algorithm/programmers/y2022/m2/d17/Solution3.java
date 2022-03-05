package com.algorithm.programmers.y2022.m2.d17;

import java.util.*;

public class Solution3 {
    public int[] solution(int[] waiting) {
        return Arrays.stream(waiting).distinct().toArray();
    }
}
