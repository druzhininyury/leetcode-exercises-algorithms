package ru.druzhininyy.leetcode.exercises.algorithms.problem0008;

public class Solution {

    public static final int PRE_MAX_INTEGER = Integer.MAX_VALUE / 10;

    public static int myAtoi(String str) {
        int result = 0;
        int sign = 1;
        int idx = 0;

        while (idx < str.length()) {
            if (str.charAt(idx) != ' ') {
                break;
            }
            ++idx;
        }

        if (idx < str.length()) {
            if (str.charAt(idx) == '-') {
                sign = -1;
                ++idx;
            } else if (str.charAt(idx) == '+') {
                ++idx;
            }
        }

        while (idx < str.length()) {
            if (!Character.isDigit(str.charAt(idx))) {
                break;
            }
            int nextDigit = str.charAt(idx) - '0';
            if (result > PRE_MAX_INTEGER && sign > 0 || result == PRE_MAX_INTEGER && sign > 0 && nextDigit >= 7) {
                return Integer.MAX_VALUE;
            }
            if (result > PRE_MAX_INTEGER && sign < 0 || result == PRE_MAX_INTEGER && sign < 0 && nextDigit >= 8) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 + nextDigit;
            ++idx;
        }

        return sign * result;
    }

}
