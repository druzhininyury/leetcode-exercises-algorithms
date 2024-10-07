package ru.druzhininyy.leetcode.exercises.algorithms.problem0012;

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

@DisplayName("Test: 12. Integer to Roman.")
public class SolutionTest {

    @Getter
    @Setter
    @ToString
    public static class TestCase {
        public int num;
        public String expected;
    }

    private static final String SOURCE_FILE = "problem0012.json";
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
            String actual = Solution.intToRoman(testCase.num);
            assertEquals(testCase.expected, actual, "actual=" + actual);
        }
    }

}

