package ru.druzhininyy.leetcode.exercises.algorithms.problem0001;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Test: 1. Add sum.")
public class SolutionTest {

    @Getter
    @Setter
    public static class TestCase {
        public int[] numbers;
        public int target;
        public int[] expected;
    }

    private static final String SOURCE_FILE = "problem0001.json";
    public static List<TestCase> testCases;

    @BeforeAll
    public static void loadTestCases() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            testCases = objectMapper.readValue(
                    SolutionTest.class.getClassLoader().getResourceAsStream(SOURCE_FILE),
                    new TypeReference<>() {});
        } catch (IOException e) {
            System.out.println("Error while loading data from " + SOURCE_FILE);
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void runTestCases() {
        for (TestCase testCase : testCases) {
            int[] actual = Solution.twoSum(testCase.numbers, testCase.target);
            Arrays.sort(testCase.expected);
            Arrays.sort(actual);
            assertArrayEquals(testCase.expected, actual);
        }
    }

}

