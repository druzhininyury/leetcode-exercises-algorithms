package ru.druzhininyy.leetcode.exercises.algorithms.problem0020;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static class BracketsSet {

        private static Map<Integer, Integer> closingToOpening = new HashMap<>();
        static {
            closingToOpening.put((int) ')', (int) '(');
            closingToOpening.put((int) ']', (int) '[');
            closingToOpening.put((int) '}', (int) '{');

        }

        public static boolean isClosing(int bracket) {
            return closingToOpening.containsKey(bracket);
        }

        public static Integer getOpening(int bracket) {
            return closingToOpening.get(bracket);
        }
    }

    public static boolean isValid(String str) {
        Deque<Integer> openingBracketsStack = new ArrayDeque<>();

        var itr = str.chars().iterator();
        while (itr.hasNext()) {
            int bracket = itr.next();
            if (!BracketsSet.isClosing(bracket)) {
                openingBracketsStack.push(bracket);
            } else if (BracketsSet.getOpening(bracket).equals(openingBracketsStack.peek())) {
                openingBracketsStack.pop();
            } else {
                return false;
            }
        }

        return openingBracketsStack.isEmpty();
    }

}
