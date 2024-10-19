package ru.druzhininyy.leetcode.exercises.algorithms.problem0283;

public class Solution {

    public static void moveZeroes(int[] nums) {
        int readIdx = 0;
        int writeIdx = 0;

        while (readIdx < nums.length) {
            if (nums[readIdx] != 0) {
                nums[writeIdx] = nums[readIdx];
                ++writeIdx;
            }
            ++readIdx;
        }

        while (writeIdx < nums.length) {
            nums[writeIdx] = 0;
            ++writeIdx;
        }
    }

}