package ru.druzhininyy.leetcode.exercises.algorithms.problem001;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numbersToIndexes = new HashMap<>();

        for (int i = 0; i < numbers.length; ++i) {
            int summand = target - numbers[i];
            if (numbersToIndexes.containsKey(summand)) {
                return new int[] {numbersToIndexes.get(summand), i};
            } else {
                numbersToIndexes.put(numbers[i], i);
            }
        }

        return new int[0];
    }
}
