package ru.druzhininyy.leetcode.exercises.algorithms.problem0011;

public class Solution {

    public static int maxArea(int[] heights) {
        if (heights.length == 0) {
            throw new IllegalArgumentException("Must be provided non-empty array.");
        }

        int leftIdx = 0;
        int rightIdx = heights.length - 1;

        int maxArea = 0;

        while (leftIdx < rightIdx) {
            maxArea = Math.max((rightIdx - leftIdx) * Math.min(heights[leftIdx], heights[rightIdx]), maxArea);
            if (heights[leftIdx] <= heights[rightIdx]) {
                ++leftIdx;
            } else {
                --rightIdx;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

}
