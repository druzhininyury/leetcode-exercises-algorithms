package ru.druzhininyy.leetcode.exercises.algorithms.problem0345;

public class Solution {

    public static String reverseVowels(String str) {
        StringBuilder stringBuilder = new StringBuilder(str.length());

        int nextVowelIdx = str.length() - 1;

        for (int idx = 0; idx < str.length(); ++idx) {
            char currentSymbol = str.charAt(idx);
            if (isVowelLetter(currentSymbol)) {
                char nextVowelLetter;
                while (!isVowelLetter(nextVowelLetter = str.charAt(nextVowelIdx--))) {}
                stringBuilder.append(nextVowelLetter);
            } else {
                stringBuilder.append(currentSymbol);
            }
        }

        return stringBuilder.toString();
    }

    private static boolean isVowelLetter(char symbol) {
        return switch (symbol) {
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true;
            default -> false;
        };
    }

}
