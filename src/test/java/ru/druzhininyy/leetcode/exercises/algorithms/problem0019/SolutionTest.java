package ru.druzhininyy.leetcode.exercises.algorithms.problem0019;

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

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test: 19. Remove Nth Node From End of List.")
public class SolutionTest {

    @Getter
    @Setter
    @ToString
    public static class TestCase {
        public int[] list;
        public int n;
        public int[] expected;

        public ListNode toList() {
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

        public static int[] toArray(ListNode head) {
            if (head == null) {
                return new int[0];
            }

            List<Integer> preResult = new ArrayList<>();
            do {
                preResult.add(head.val);
                head = head.next;
            } while (head != null);

            return preResult.stream().mapToInt(num -> num).toArray();

        }
    }

    private static final String SOURCE_FILE = "problem0019.json";
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

        var actual = TestCase.toArray(Solution.removeNthFromEnd(testCase.toList(), testCase.getN()));

        assertTrue(Arrays.equals(testCase.expected, actual));
    }

}





