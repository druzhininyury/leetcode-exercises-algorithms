package ru.druzhininyy.leetcode.exercises.algorithms.problem0021;

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

@DisplayName("Test: 21. Merge Two Sorted Lists.")
public class SolutionTest {

    @Getter
    @Setter
    @ToString
    public static class TestCase {
        public int[] list1;
        public int[] list2;
        public List<List<Integer>> expected;

        public static ListNode toList(int[] list) {
            if (list.length == 0) {
                return null;
            }

            ListNode head = new ListNode(list[0]);
            ListNode currentNode = head;

            for (int i = 1; i < list.length; ++i) {
                currentNode.next = new ListNode(list[i]);
                currentNode = currentNode.next;
            }

            return head;
        }

        public static List<Integer> toArray(ListNode head) {
            if (head == null) {
                return List.of();
            }

            List<Integer> result = new ArrayList<>();
            do {
                result.add(head.val);
                head = head.next;
            } while (head != null);

            return result;

        }
    }

    private static final String SOURCE_FILE = "problem0021.json";
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

        List<Integer> actual = TestCase.toArray(Solution.mergeTwoLists(TestCase.toList(testCase.getList1()),
                                                                           TestCase.toList(testCase.getList2())));

        assertThat(actual, in(testCase.getExpected()));
    }

}







