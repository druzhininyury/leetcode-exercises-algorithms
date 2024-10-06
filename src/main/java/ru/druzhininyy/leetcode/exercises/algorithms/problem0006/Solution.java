package ru.druzhininyy.leetcode.exercises.algorithms.problem0006;

public class Solution {

    public static String convert(String str, int numRows) {
        if (numRows == 1) {
            return str;
        }

        StringBuilder stringBuilder = new StringBuilder();

        int fullSegmentLength = 2 * numRows - 2;
        int fullSegmentsNumber = str.length() / fullSegmentLength;
        int lastSegmentLength = str.length() % fullSegmentLength;

        for (int i = 0; i < str.length(); i += fullSegmentLength) {
            stringBuilder.append(str.charAt(i));
        }

        int fullSegmentsLastIdx = fullSegmentsNumber * fullSegmentLength - 1;
        for (int j = 1; j < numRows - 1; ++j) {
            for (int i = 0; i <= fullSegmentsLastIdx; i += fullSegmentLength) {
                stringBuilder.append(str.charAt(j + i));
                stringBuilder.append(str.charAt(fullSegmentLength - j + i));
            }
            if (j < lastSegmentLength) {
                stringBuilder.append(str.charAt(fullSegmentsLastIdx + 1 + j));
            }
            if (fullSegmentLength - j < lastSegmentLength) {
                stringBuilder.append(str.charAt(fullSegmentsLastIdx + 1 + fullSegmentLength - j));
            }
        }

        for (int i = numRows - 1; i < str.length(); i += fullSegmentLength) {
            stringBuilder.append(str.charAt(i));
        }

        return stringBuilder.toString();
    }

}
