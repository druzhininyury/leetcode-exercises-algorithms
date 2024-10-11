package ru.druzhininyy.leetcode.exercises.algorithms.problem0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        for (int firstIdx = 0; firstIdx < nums.length - 3; ++firstIdx) {
            if (firstIdx > 0 && nums[firstIdx] == nums[firstIdx - 1]) {
                continue;
            }

            for (int secondIdx = firstIdx + 1; secondIdx < nums.length - 2; ++secondIdx) {
                if (secondIdx > firstIdx + 1 && nums[secondIdx] == nums[secondIdx - 1]) {
                    continue;
                }

                int leftIdx = secondIdx + 1;
                int rightIdx = nums.length - 1;

                while (leftIdx < rightIdx) {
                    long sum = (long) nums[firstIdx] + nums[secondIdx] + nums[leftIdx] + nums[rightIdx];

                    if (sum == target) {
                        result.add(List.of(nums[firstIdx], nums[secondIdx], nums[leftIdx], nums[rightIdx]));
                        ++leftIdx;
                        --rightIdx;

                        while (leftIdx < rightIdx && nums[leftIdx] == nums[leftIdx - 1]) {
                            ++leftIdx;
                        }

                        while (leftIdx < rightIdx && nums[rightIdx] == nums[rightIdx + 1]) {
                            --rightIdx;
                        }
                    } else if (sum < target) {
                        ++leftIdx;
                    } else {
                        --rightIdx;
                    }
                }
            }
        }

        return result;
    }

}
