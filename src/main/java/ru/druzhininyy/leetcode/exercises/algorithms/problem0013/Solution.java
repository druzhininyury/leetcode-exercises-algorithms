package ru.druzhininyy.leetcode.exercises.algorithms.problem0013;

public class Solution {

    public static int romanToInt(String roman) {
        int result = 0;

        int currentValueLevel = 0;
        for (int i = roman.length() - 1; i >= 0; --i) {
            int currentValue = getValue(roman.charAt(i));
            if (currentValue < currentValueLevel) {
                result -= currentValue;
            } else {
                result += currentValue;
                currentValueLevel = currentValue;
            }
        }

        return result;
    }

    private static int getValue(char symbol) {
        return switch (symbol) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> -1;
        };
    }

}
