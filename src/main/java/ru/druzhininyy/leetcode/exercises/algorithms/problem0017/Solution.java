package ru.druzhininyy.leetcode.exercises.algorithms.problem0017;

import java.util.*;

public class Solution {

    private static final int MAX_LETTERS_PER_DIGIT = 4;

    @SuppressWarnings("unchecked")
    private static final List<Character>[] digitToLetters = new List[] {
            List.of('a', 'b', 'c'),
            List.of('d', 'e', 'f'),
            List.of('g', 'h', 'i'),
            List.of('j', 'k', 'l'),
            List.of('m', 'n', 'o'),
            List.of('p', 'q', 'r', 's'),
            List.of('t', 'u', 'v'),
            List.of('w', 'x', 'y', 'z')};


    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>(digits.length() * MAX_LETTERS_PER_DIGIT);

        if (digits.isEmpty()) {
            return result;
        }

        Deque<Iterator<Character>> stack = new ArrayDeque<>(digits.length());
        stack.push(digitToLetters[digits.charAt(0) - '2'].iterator());
        char[] wordHolder = new char[digits.length()];

        while (!stack.isEmpty()) {
            var itr = stack.peek();
            if (itr.hasNext()) {
                wordHolder[stack.size() - 1] = itr.next();
                if (stack.size() == digits.length()) {
                    result.add(String.copyValueOf(wordHolder));
                    continue;
                }
                stack.push(digitToLetters[digits.charAt(stack.size()) - '2'].iterator());
            } else {
                stack.pop();
            }
        }

        return result;
    }

}
