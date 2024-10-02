package ru.druzhininyy.leetcode.exercises.algorithms.problem0009;

public class Solution {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        return x == getReversed(x);
    }

    private static int getReversed(int x) {
        int sign = x >= 0 ? 1 : -1;
        x *= sign;

        int reversed = 0;
        while (x != 0) {
            reversed = reversed * 10 + (x % 10);
            x /= 10;
        }

        return reversed * sign;
    }

}
