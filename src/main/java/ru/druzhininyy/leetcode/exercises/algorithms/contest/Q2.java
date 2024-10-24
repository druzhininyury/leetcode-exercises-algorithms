package ru.druzhininyy.leetcode.exercises.algorithms.contest;

import java.util.HashMap;
import java.util.Map;

public class Q2 {

    public static int numberOfSubstrings(String str, int times) {
        int result = 0;

        Map<Character, Integer> frequencies = new HashMap<>();
        int exceededSymbolNumber = 0;

        int leftIdx = 0;
        int rightIdx = -1;

        outer:
        while (leftIdx < str.length()) {
            while (exceededSymbolNumber == 0) {
                if (rightIdx >= str.length() - 1) {
                    break outer;
                }

                ++rightIdx;
                char nextChar = str.charAt(rightIdx);

                if (!frequencies.containsKey(nextChar)) {
                    frequencies.put(nextChar, 0);
                }
                frequencies.put(nextChar, frequencies.get(nextChar) + 1);
                if (frequencies.get(nextChar) == times) {
                    exceededSymbolNumber += 1;
                }

            }

            result += str.length() - rightIdx;

            char currentChar = str.charAt(leftIdx);
            frequencies.put(currentChar, frequencies.get(currentChar) - 1);
            if (frequencies.get(currentChar) == times - 1) {
                exceededSymbolNumber -= 1;
            }
            ++leftIdx;
        }

        return result;
    }

    private static boolean isValid(Map<Character, Integer> histogram, int times) {
        for (var entry : histogram.entrySet()) {
            if (entry.getValue() >= times) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abacb", 2));
        System.out.println(numberOfSubstrings("hxccgfp", 1));
    }

}
