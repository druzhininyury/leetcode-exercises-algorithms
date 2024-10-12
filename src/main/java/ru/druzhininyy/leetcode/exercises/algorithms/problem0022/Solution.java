package ru.druzhininyy.leetcode.exercises.algorithms.problem0022;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        char[] word = new char[2 * n];
        word[0] = '(';

        int openParenthesesLeft = n - 1;
        int parenthesesBalance = 1;
        int idx = 0;

        while (true) {
            if (openParenthesesLeft > 0) {
                ++idx;
                word[idx] = '(';
                openParenthesesLeft -= 1;
                ++parenthesesBalance;
            } else {
                while (parenthesesBalance != 0) {
                    ++idx;
                    word[idx] = ')';
                    --parenthesesBalance;
                }
                result.add(String.copyValueOf(word));
                while (idx >= 0 && (word[idx] != '(' || parenthesesBalance < 2)) {
                    if (word[idx] == '(') {
                        openParenthesesLeft += 1;
                        parenthesesBalance -= 1;
                    } else {
                        parenthesesBalance += 1;
                    }
                    --idx;
                }
                if (idx == -1) {
                    break;
                }
                word[idx] = ')';
                openParenthesesLeft += 1;
                parenthesesBalance -= 2;
            }

        }

        return result;
    }

}
