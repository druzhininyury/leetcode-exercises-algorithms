package ru.druzhininyy.leetcode.exercises.algorithms.contest;

import java.util.ArrayList;
import java.util.List;

public class Q1 {

    public static List<String> stringSequence(String target) {
        List<String> result = new ArrayList<>();

        char[] word = new char[target.length()];

        for (int idx = 0; idx < target.length(); idx++) {
            char charToType = target.charAt(idx);

            for (char currentChar = 'a'; currentChar <= charToType; currentChar++) {
                word[idx] = currentChar;
                result.add(new String(word, 0, idx + 1));
            }
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(stringSequence("a"));
    }

}
