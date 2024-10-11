package ru.druzhininyy.leetcode.exercises.algorithms.problem0018;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test: 18. 4Sum.")
public class SolutionTest {

    @Getter
    @Setter
    @ToString
    public static class TestCase {
        public int[] nums;
        public int target;
        public List<List<Integer>> expected;
    }

    public static final Comparator<List<Integer>> lexigraphicComparator = (leftOperand, rightOperand) -> {
        Iterator<Integer> leftIterator = leftOperand.iterator();
        Iterator<Integer> rightIterator = rightOperand.iterator();

        while (leftIterator.hasNext() && rightIterator.hasNext()) {
            int diff = leftIterator.next() - rightIterator.next();
            if (diff != 0) {
                return diff;
            }
        }

        if (leftIterator.hasNext()) {
            return -1;
        }
        if (rightIterator.hasNext()) {
            return 1;
        }
        return 0;
    };

    private static final String SOURCE_FILE = "problem0018.json";
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

    private static Stream<Arguments> provideTestsArguments() {
        return testCases.stream().map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestsArguments")
    public void runTestCases(TestCase testCase) {
        System.out.println(testCase);
        testCase.getExpected().forEach(list -> list.sort(Comparator.naturalOrder()));
        testCase.getExpected().sort(lexigraphicComparator);

        var actual = Solution.fourSum(testCase.getNums(), testCase.getTarget());
        actual.forEach(list -> new ArrayList<>(list).sort(Comparator.naturalOrder()));
        actual.sort(lexigraphicComparator);

        assertEquals(testCase.expected, actual);
    }

}




