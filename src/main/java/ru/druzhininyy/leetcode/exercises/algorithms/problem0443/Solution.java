package ru.druzhininyy.leetcode.exercises.algorithms.problem0443;

import java.util.Arrays;

public class Solution {

    private static int MAX_ROUND_INTEGER = 1_000_000_000;

    public static int compress(char[] chars) {
        int readIdx = 0;
        int writeIdx = 0;

        while (readIdx < chars.length) {
            int startIdx = readIdx;
            char currentChar = chars[startIdx];

            ++readIdx;
            while (readIdx < chars.length && currentChar == chars[readIdx]) {
                ++readIdx;
            }

            chars[writeIdx] = currentChar;
            ++writeIdx;

            int repeatsNumber = readIdx - startIdx;
            if (repeatsNumber > 1) {
                int repeatsNumberOrder = MAX_ROUND_INTEGER;
                while (repeatsNumberOrder > repeatsNumber) {
                    repeatsNumberOrder /= 10;
                }

                while (repeatsNumberOrder > 0) {
                    chars[writeIdx] = (char) ('0' + (repeatsNumber / repeatsNumberOrder));
                    ++writeIdx;

                    repeatsNumber %= repeatsNumberOrder;
                    repeatsNumberOrder /= 10;
                }
            }
        }

        return writeIdx;
    }

    public static void main(String[] args) {
        char[] chars = new char[] {'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'};

        System.out.println(compress(chars));
        System.out.println(Arrays.toString(chars));
    }

}
