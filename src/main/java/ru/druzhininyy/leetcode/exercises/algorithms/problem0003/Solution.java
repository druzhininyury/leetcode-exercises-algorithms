package ru.druzhininyy.leetcode.exercises.algorithms.problem0003;

public class Solution {

    public static int lengthOfLongestSubstring(String string) {
        int[] lastCharacterOccurrence = new int[128];
        int maxSubstringLength = 0;
        int substringStartIndex = 1;

        for (int i = 0; i < string.length(); ++i) {
            char currentCharacter = string.charAt(i);
            if (lastCharacterOccurrence[currentCharacter] >= substringStartIndex) {
                substringStartIndex = lastCharacterOccurrence[currentCharacter] + 1;
            }
            lastCharacterOccurrence[currentCharacter] = i + 1;
            maxSubstringLength = Math.max(maxSubstringLength, i - substringStartIndex + 2);
        }

        return maxSubstringLength;
    }

}
