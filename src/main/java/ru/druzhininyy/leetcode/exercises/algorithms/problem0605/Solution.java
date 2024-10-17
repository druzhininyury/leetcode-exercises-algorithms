package ru.druzhininyy.leetcode.exercises.algorithms.problem0605;

public class Solution {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int freePots = 0;
        int lastFreePotsSequenceLength = 0;

        if (flowerbed[0] == 0) {
            lastFreePotsSequenceLength += 1;
        }

        for (int pot : flowerbed) {
            if (pot == 0) {
                lastFreePotsSequenceLength += 1;
            } else {
                freePots += (lastFreePotsSequenceLength - 1) / 2;
                lastFreePotsSequenceLength = 0;
            }
        }

        freePots += lastFreePotsSequenceLength / 2;

        return freePots >= n;
    }

}
