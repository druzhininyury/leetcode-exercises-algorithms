package ru.druzhininyy.leetcode.exercises.algorithms.problem0016;

import java.util.Arrays;

public class Solution {

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            throw new IllegalArgumentException("Array length must have three elements at least.");
        }

        Arrays.sort(nums);
        int minSum = Integer.MAX_VALUE;
        int minError = Integer.MAX_VALUE;

        for (int idx = 0; idx < nums.length - 2; ++idx) {
            int leftIdx = idx + 1;
            int rightIdx = nums.length - 1;

            while (leftIdx < rightIdx) {
                int currentSum = nums[idx] + nums[leftIdx] + nums[rightIdx];
                if (currentSum == target) {
                    return currentSum;
                }

                int currentError = Math.abs(currentSum - target);
                if (currentError < minError) {
                    minError = currentError;
                    minSum = currentSum;
                }

                if (currentSum < target) {
                    ++leftIdx;
                } else {
                    --rightIdx;
                }
            }
        }

        return minSum;
    }

}
