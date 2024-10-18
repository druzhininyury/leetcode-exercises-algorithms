package ru.druzhininyy.leetcode.exercises.algorithms.problem0238;

public class Solution {

    public static int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length];
        int lastIdx = nums.length - 1;

        result[0] = 1;
        for (int idx = 1; idx <= lastIdx; ++idx) {
            result[idx] = result[idx - 1] * nums[idx - 1];
        }

        int lastSuffix = 1;
        for (int idx = lastIdx; idx >= 0; --idx) {
            result[idx] *= lastSuffix;
            lastSuffix *= nums[idx];
        }

        return result;
    }

}
