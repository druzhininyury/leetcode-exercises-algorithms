package ru.druzhininyy.leetcode.exercises.algorithms.problem0005;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test: 5. Longest Palindromic Substring.")
public class SolutionTest {

    @Getter
    @Setter
    @ToString
    public static class TestCase {
        public String str;
        public List<String> expected;
    }

    private static final String SOURCE_FILE = "problem0005.json";
    public static List<TestCase> testCases;

    @BeforeAll
    public static void loadTestCases() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            testCases = objectMapper.readValue(
                    SolutionTest.class.getClassLoader().getResourceAsStream(SOURCE_FILE),
                    new TypeReference<>() {
                    });
        } catch (IOException e) {
            System.out.println("Error while loading data from " + SOURCE_FILE);
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Constant memory algorithm.")
    public void runTestCases_withConstantMemoryAlgorithm() {
        for (TestCase testCase : testCases) {
            System.out.println(testCase);
            String actual = Solution.longestPalindrome(testCase.str, Solution.Algorithm.CONSTANT_MEMORY);
            assertTrue(testCase.expected.contains(actual), "actual=" + actual);
        }
    }
    @Test
    @DisplayName("Linear speed algorithm.")
    public void runTestCases_withLinearSpeedAlgorithm() {
        for (TestCase testCase : testCases) {
            System.out.println(testCase);
            String actual = Solution.longestPalindrome(testCase.str, Solution.Algorithm.LINEAR_SPEED);
            assertTrue(testCase.expected.contains(actual), "actual=" + actual);
        }
    }

}
