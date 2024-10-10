package ru.druzhininyy.leetcode.exercises.algorithms.problem0015;

import java.util.*;

class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int idx = 0; idx < nums.length - 2; ++idx) {
            if (idx > 0 && nums[idx] == nums[idx - 1]) {
                continue;
            }

            int firstAddend = nums[idx];

            int leftIdx = idx + 1;
            int rightIdx = nums.length - 1;
            while (leftIdx < rightIdx) {
                int sum = firstAddend + nums[leftIdx] + nums[rightIdx];

                if (sum == 0) {
                    result.add(List.of(firstAddend, nums[leftIdx], nums[rightIdx]));

                    while (leftIdx < rightIdx && nums[leftIdx] == nums[leftIdx + 1]) {
                        ++leftIdx;
                    }
                    while (leftIdx < rightIdx && nums[rightIdx] == nums[rightIdx - 1]) {
                        --rightIdx;
                    }

                    ++leftIdx;
                    --rightIdx;
                } else if (sum < 0) {
                    ++leftIdx;
                } else {
                    --rightIdx;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }
}
