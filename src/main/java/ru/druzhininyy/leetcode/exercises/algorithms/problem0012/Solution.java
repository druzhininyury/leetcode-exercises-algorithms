package ru.druzhininyy.leetcode.exercises.algorithms.problem0012;

class Solution {

    public static final char[] VALUES = new char[] {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

    public static String intToRoman(int num) {
        if (num <= 0 || num >= 4000) {
            throw new IllegalArgumentException(String.format("Argument num=%d is out of bound [1,3999]", num));
        }

        StringBuilder stringBuilder = new StringBuilder();

        int full = 1000;

        int order = 0;
        while (num != 0) {
            int digit = num / full;

            if (digit == 9) {
                stringBuilder.append(VALUES[order]).append(VALUES[order - 2]);
            } else if (digit >= 5) {
                stringBuilder.append(VALUES[order - 1]).append(String.valueOf(VALUES[order]).repeat(digit - 5));
            } else if (digit == 4) {
                stringBuilder.append(VALUES[order]).append(VALUES[order - 1]);
            } else if (digit >= 1) {
                stringBuilder.append(String.valueOf(VALUES[order]).repeat(digit));
            }

            num %= full;

            order += 2;
            full /= 10;
        }

        return stringBuilder.toString();
    }
}
