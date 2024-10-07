package ru.druzhininyy.leetcode.exercises.algorithms.problem0008;

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

@DisplayName("Test: 8. String to Integer (atoi).")
public class SolutionTest {

    @Getter
    @Setter
    @ToString
    public static class TestCase {
        public String str;
        public int expected;
    }

    private static final String SOURCE_FILE = "problem0008.json";
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
    public void runTestCases_withConstantMemoryAlgorithm() {
        for (TestCase testCase : testCases) {
            System.out.println(testCase);
            int actual = Solution.myAtoi(testCase.str);
            assertEquals(testCase.expected, actual, "actual=" + actual);
        }
    }

}
