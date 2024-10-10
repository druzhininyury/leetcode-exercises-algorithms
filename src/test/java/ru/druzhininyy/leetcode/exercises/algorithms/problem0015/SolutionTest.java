package ru.druzhininyy.leetcode.exercises.algorithms.problem0015;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test: 15. 3Sum.")
public class SolutionTest {

    @Getter
    @Setter
    @ToString
    public static class TestCase {
        public int[] nums;
        public List<List<Integer>> expected;
    }

    private static final Comparator<List<Integer>> lexigraphicComparator = (leftOperand, rightOperand) -> {
        Iterator<Integer> leftIterator = leftOperand.iterator();
        Iterator<Integer> rightIterator = rightOperand.iterator();

        while (leftIterator.hasNext() && rightIterator.hasNext()) {
            int leftValue = leftIterator.next();
            int rightValue = rightIterator.next();

            if (leftValue < rightValue) {
                return -1;
            }
            if (leftValue > rightValue) {
                return 1;
            }
        }

        if (leftIterator.hasNext()) {
            return 1;
        }
        if (rightIterator.hasNext()) {
            return -1;
        }
        return 0;
    };

    private static final String SOURCE_FILE = "problem0015.json";
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
    public void runTestCases() {
        for (TestCase testCase : testCases) {
            System.out.println(testCase);
            var actual = Solution.threeSum(testCase.getNums());

            testCase.getExpected().sort(lexigraphicComparator);
            actual.sort(lexigraphicComparator);
            assertEquals(testCase.expected, actual, "actual=" + actual);
        }
    }

}


