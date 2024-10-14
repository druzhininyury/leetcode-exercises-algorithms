package ru.druzhininyy.leetcode.exercises.algorithms.problem1768;

public class Solution {

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();

        int minLength = Math.min(word1.length(), word2.length());

        for (int idx = 0; idx < minLength; ++idx) {
            stringBuilder.append(word1.charAt(idx)).append(word2.charAt(idx));
        }

        stringBuilder.append(word1, minLength, word1.length());
        stringBuilder.append(word2, minLength, word2.length());

        return stringBuilder.toString();
    }

}
