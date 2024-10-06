package ru.druzhininyy.leetcode.exercises.algorithms.problem0007;

public class Solution {

    public static final int PRE_MAX_POSSIBLE_NUMBER = Integer.MAX_VALUE / 10;
    public static final int PRE_MIN_POSSIBLE_NUMBER = Integer.MIN_VALUE / 10;

    public static int reverse(int num) {
        int result = 0;

        while (num != 0) {
            if (result > PRE_MAX_POSSIBLE_NUMBER || result < PRE_MIN_POSSIBLE_NUMBER) {
                return 0;
            }
            result = 10 * result + num % 10;
            num /= 10;
        }

        return result;
    }

}
