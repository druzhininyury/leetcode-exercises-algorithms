package ru.druzhininyy.leetcode.exercises.algorithms.problem0334;

public class Solution {

    public static boolean increasingTriplet(int[] nums) {
        int left = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= left) {
                left = num;
            } else if (num <= middle) {
                middle = num;
            } else {
                return true;
            }
        }

        return false;
    }

}
