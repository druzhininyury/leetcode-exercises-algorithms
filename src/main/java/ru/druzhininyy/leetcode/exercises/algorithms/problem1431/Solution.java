package ru.druzhininyy.leetcode.exercises.algorithms.problem1431;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = max(candies);

        List<Boolean> result = new ArrayList<>(candies.length);

        for (int candyNumber : candies) {
            result.add(candyNumber + extraCandies >= maxCandies);
        }

        return result;
    }

    private static int max(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array shouldn't be empty.");
        }

        int max  = array[0];
        for (int num : array) {
            max = Math.max(num, max);
        }

        return max;
    }

}
