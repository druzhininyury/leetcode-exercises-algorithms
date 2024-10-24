package ru.druzhininyy.leetcode.exercises.algorithms.problem1679;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int maxOperations(int[] numbers, int target) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        int pairCounter = 0;

        for (int number : numbers) {
            int difference = target - number;
            int searchResult;

            if ((searchResult = frequencies.getOrDefault(difference, 0)) > 0) {
                pairCounter += 1;
                frequencies.put(difference, --searchResult);
            } else {
                frequencies.put(number, frequencies.getOrDefault(number, 0) + 1);
            }
        }

        return pairCounter;
    }

}
