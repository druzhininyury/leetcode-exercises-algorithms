package ru.druzhininyy.leetcode.exercises.algorithms.problem0005;

public class Solution {

    public enum Algorithm {
        CONSTANT_MEMORY,
        LINEAR_SPEED
    }

    public static String longestPalindrome(String str, Algorithm algorithm) {
        return switch (algorithm) {
            case CONSTANT_MEMORY -> longestPalindromeConstantMemory(str);
            case LINEAR_SPEED -> longestPalindromeLinearSpeed(str);
        };
    }

    // Time complexity: O(n^2), n - str length.
    // Memory complexity: O(1).
    public static String longestPalindromeConstantMemory(String str) {
        if (str.isEmpty()) {
            return "";
        }

        int palindromesCentersMaxIndex = (str.length() - 1) * 2;

        int maxPalindromeBeginIdx = 0;
        int maxPalindromeLength = 1;

        for (int center = 1; center <= palindromesCentersMaxIndex; ++center) {
            int leftIdx = (center - 1) / 2;
            int rightIdx = center / 2 + 1;

            while (leftIdx >= 0 && rightIdx < str.length() && str.charAt(leftIdx) == str.charAt(rightIdx)) {
                leftIdx -= 1;
                rightIdx += 1;
            }

            int currentPalindromeLength = rightIdx - leftIdx - 1;
            if (currentPalindromeLength > maxPalindromeLength) {
                maxPalindromeLength = currentPalindromeLength;
                maxPalindromeBeginIdx = leftIdx + 1;
            }
        }

        return str.substring(maxPalindromeBeginIdx, maxPalindromeBeginIdx + maxPalindromeLength);
    }

    // Time complexity: O(n), n - str length.
    // Memory complexity: O(n), n - str length.
    public static String longestPalindromeLinearSpeed(String str) {
        if (str.isEmpty()) {
            return "";
        }

        int palindromesCentersMaxIndex = (str.length() - 1) * 2;
        int[] palindromesRadii = new int[palindromesCentersMaxIndex + 1];

        int rightestPalindromeCenterIdx = 0;
        int rightestPalindromeEndIdx = 0;

        int maxPalindromeBeginIdx = 0;
        int maxPalindromeLength = 0;

        for (int idx = 0; idx <= palindromesCentersMaxIndex; ++idx) {
            int leftIdx = (idx + 1) / 2 - 1;
            int rightIdx = idx / 2 + 1;

            if (idx < 2 * rightestPalindromeEndIdx) {
                int symmetricIdx = 2 * rightestPalindromeCenterIdx - idx;
                palindromesRadii[idx] = Math.min(palindromesRadii[symmetricIdx], rightestPalindromeEndIdx - rightIdx + 1);
            }

            while (leftIdx >= 0 && rightIdx < str.length() && str.charAt(leftIdx) == str.charAt(rightIdx)) {
                --leftIdx;
                ++rightIdx;
            }
            ++leftIdx;
            --rightIdx;

            int currentPalindromeLength = rightIdx - leftIdx + 1;
            palindromesRadii[idx] = currentPalindromeLength / 2;

            if (rightIdx > rightestPalindromeEndIdx) {
                rightestPalindromeCenterIdx = idx;
                rightestPalindromeEndIdx = rightIdx;
            }

            if (currentPalindromeLength > maxPalindromeLength) {
                maxPalindromeLength = currentPalindromeLength;
                maxPalindromeBeginIdx = leftIdx;
            }
        }

        return str.substring(maxPalindromeBeginIdx, maxPalindromeBeginIdx + maxPalindromeLength);
    }

}
