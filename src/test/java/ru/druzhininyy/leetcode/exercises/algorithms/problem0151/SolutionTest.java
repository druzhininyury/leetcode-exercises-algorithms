package ru.druzhininyy.leetcode.exercises.algorithms.problem0151;

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
import java.util.*;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("Test: 151. Reverse Words in a String.")
public class SolutionTest {

    @Getter
    @Setter
    @ToString
    public static class TestCase {
        public String str;
        public List<String> expected;
    }

    private static final String SOURCE_FILE = "problem0151.json";
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

        var actual = Solution.reverseWords(testCase.getStr());

        assertThat(actual, is(testCase.getExpected().get(0)));
    }

}










