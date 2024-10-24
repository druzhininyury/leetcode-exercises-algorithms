package ru.druzhininyy.leetcode.exercises.algorithms.contest;

import java.util.*;

public class Q3 {

    private static class DynamicIntegerArray {
        private static final int DEFAULT_START_ARRAY_LENGTH = 100;
        private static final int PRE_MAX_ARRAY_LENGTH = Integer.MAX_VALUE / 3;

        private int[] array = new int[DEFAULT_START_ARRAY_LENGTH];

        public void set(int idx, int value) {
            if (idx >= array.length) {
                grow();
            }
            array[idx] = value;
        }

        public int get(int idx) {
            return array[idx];
        }

        private void grow() {
            int newArrayLength = array.length < PRE_MAX_ARRAY_LENGTH ? array.length + array.length / 2 : Integer.MAX_VALUE;
            array = Arrays.copyOf(array, newArrayLength);
        }
    }

    private static class GreatestProperDivisor {
        private final List<Integer> primes = new ArrayList<>();
        private final DynamicIntegerArray spf = new DynamicIntegerArray(); // Smallest Prime Factor (or 1)
        private final DynamicIntegerArray gpd = new DynamicIntegerArray(); // Greatest Proper Divisor

        private int calculatedIdx = 2;

        {
            spf.set(1, 1);
            spf.set(2, 2);

            gpd.set(0, -1);
            gpd.set(1, -1);
            gpd.set(2, -1);
        }

        public int getGPD(int idx) {
            if (idx > calculatedIdx) {
                calculateUpToIndex(idx);
            }

            return gpd.get(idx);
        }

        private void calculateUpToIndex(int idx) {
            for (int currentIdx = calculatedIdx + 1; currentIdx <= idx; currentIdx++) {
                if (currentIdx % 2 == 0) {
                    spf.set(currentIdx, 2);
                    gpd.set(currentIdx, currentIdx / 2);
                    continue;
                }

                if (spf.get(currentIdx) == 0) {
                    primes.add(currentIdx);
                    spf.set(currentIdx, currentIdx);
                    gpd.set(currentIdx, -1);
                }

                for (Integer prime : primes) {
                    int nextIdx = currentIdx * prime;
                    if (nextIdx > idx) {
                        break;
                    }
                    spf.set(nextIdx, prime);
                    gpd.set(nextIdx, currentIdx);
                }
            }

            calculatedIdx = idx;
        }
    }

    public static int minOperations(int[] nums) {
        int result = 0;
        GreatestProperDivisor divisors = new GreatestProperDivisor();

        for (int idx = nums.length - 2; idx >= 0; --idx) {
            while (nums[idx] > nums[idx + 1]) {
                int gpd = divisors.getGPD(nums[idx]);
                if (gpd == -1) {
                    return -1;
                }
                nums[idx] /= gpd;
                result += 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(minOperations(new int[] {25, 7}));
//        System.out.println(minOperations(new int[] {9, 2}));
//        System.out.println(minOperations(new int[] {9, 27, 81, 27, 3}));

        GreatestProperDivisor gpd = new GreatestProperDivisor();
        System.out.println(gpd.getGPD(81));
        System.out.println("End");
    }

}

