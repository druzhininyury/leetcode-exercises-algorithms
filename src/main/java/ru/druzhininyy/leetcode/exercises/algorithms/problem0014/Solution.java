package ru.druzhininyy.leetcode.exercises.algorithms.problem0014;


public class Solution {
    public static String longestCommonPrefix(String[] strings) {
        char[] firstString = strings[0].toCharArray();
        int commonPrefixLastIndex = firstString.length - 1;

        for (int i = 1; i < strings.length; ++i) {
            char[] currentString = strings[i].toCharArray();
            int searchLastIndex = Math.min(commonPrefixLastIndex, currentString.length - 1);
            for (int j = 0; j <= searchLastIndex; ++j) {
                if (firstString[j] != currentString[j]) {
                    searchLastIndex = j - 1;
                    break;
                }
            }
            commonPrefixLastIndex = searchLastIndex;
        }

        return new String(firstString, 0, commonPrefixLastIndex + 1);
    }

}
