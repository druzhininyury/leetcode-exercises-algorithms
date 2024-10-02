package ru.druzhininyy.leetcode.exercises.algorithms.problem0014;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Getter
    @Setter
    public static class TestCase {
        public String[] strings;
        public String expected;
    }

    private static final String SOURCE_FILE = "problem0014.json";
    public static List<TestCase> testCases;

    @BeforeAll
    public static void loadTestCases() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            testCases = objectMapper.readValue(
                    SolutionTest.class.getClassLoader().getResourceAsStream(SOURCE_FILE),
                    new TypeReference<List<TestCase>>() {});
        } catch (IOException e) {
            System.out.println("Error while loading data from " + SOURCE_FILE);
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void runTestCases() {
        for (TestCase testCase : testCases) {
            String actual = Solution.longestCommonPrefix(testCase.strings);
            assertEquals(testCase.expected, actual);
        }
    }

}


