package ru.druzhininyy.leetcode.exercises.algorithms.problem0151;

public class Solution {

    public static String reverseWords(String str) {
        StringBuilder stringBuilder = new StringBuilder(str.length());

        int wordLength = 0;
        for (int idx = str.length() - 1; idx >= 0; --idx) {
            if (str.charAt(idx) == ' ') {
                wordLength = 0;
                continue;
            } else if (idx > 0 && str.charAt(idx - 1) != ' ') {
                wordLength += 1;
                continue;
            }

            stringBuilder.append(str, idx, idx + wordLength + 1).append(' ');
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }

}
