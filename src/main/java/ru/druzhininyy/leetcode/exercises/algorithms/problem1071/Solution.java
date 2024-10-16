package ru.druzhininyy.leetcode.exercises.algorithms.problem1071;

public class Solution {

    public static String gcdOfStrings(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty()) {
            throw new IllegalArgumentException("Strings can't be empty.");
        }

        if (!haveCommonDivider(str1, str2)) {
            return "";
        }

        return str1.substring(0, getGcdEuclid(str1.length(), str2.length()));
    }

    public static boolean haveCommonDivider(String str1, String str2) {
        if (str1.length() < str2.length()) {
            var temp = str1;
            str1 = str2;
            str2 = temp;
        }

        int upperIdx = 0;
        int lowerIdx = 0;
        while (lowerIdx < str2.length()) {
            if (str1.charAt(upperIdx++) != str2.charAt(lowerIdx++)) {
                return false;
            }
        }

        lowerIdx = 0;
        while (upperIdx < str1.length()) {
            if (str1.charAt(upperIdx++) != str1.charAt(lowerIdx++)) {
                return false;
            }
        }

        upperIdx = 0;
        while (lowerIdx < str1.length()) {
            if (str2.charAt(upperIdx++) != str1.charAt(lowerIdx++)) {
                return false;
            }
        }

        return true;
    }

    public static int getGcdEuclid(int num1, int num2) {
        while (num2 != 0) {
            int remainder = num1 % num2;
            num1 = num2;
            num2 = remainder;
        }
        return num1;
    }

}
