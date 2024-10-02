package ru.druzhininyy.leetcode.exercises.algorithms.problem0003;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test: 3. Longest Substring Without Repeating Characters.")
public class SolutionTest {

    @Getter
    @Setter
    public static class TestCase {
        public String string;
        public int expected;
    }

    private static final String SOURCE_FILE = "problem0003.json";
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
            int actual = Solution.lengthOfLongestSubstring(testCase.string);
            assertEquals(testCase.expected, actual);
        }
    }

}
