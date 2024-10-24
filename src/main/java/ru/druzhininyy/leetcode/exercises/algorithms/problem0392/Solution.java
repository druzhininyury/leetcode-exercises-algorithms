package ru.druzhininyy.leetcode.exercises.algorithms.problem0392;

public class Solution {

    public static boolean isSubsequence(String sub, String str) {
        int strIdx = 0;
        int subIdx = 0;

        while (subIdx < sub.length() && strIdx < str.length()) {
            if (sub.charAt(subIdx) == str.charAt(strIdx)) {
                ++subIdx;
            }
            ++strIdx;
        }

        return subIdx >= sub.length();
    }

}
