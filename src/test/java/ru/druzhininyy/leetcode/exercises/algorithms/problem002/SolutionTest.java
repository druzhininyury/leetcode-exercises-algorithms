package ru.druzhininyy.leetcode.exercises.algorithms.problem002;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {

    @Getter
    @Setter
    public static class TestCase {
        public int[] l1;
        public int[] l2;
        public int[] expected;

        public ListNode getL1() {
            return getListNode(l1);
        }

        public ListNode getL2() {
            return getListNode(l2);
        }

        public static int[] toArray(ListNode head) {
            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            return list.stream().mapToInt(number -> number).toArray();
        }

        private static ListNode getListNode(int[] array) {
            ListNode headNode = new ListNode(array[0]);
            ListNode currentNode = headNode;
            for (int i = 1; i < array.length; ++i) {
                ListNode nextNode = new ListNode(array[i]);
                currentNode.next = nextNode;
                currentNode = nextNode;
            }
            return headNode;
        }
    }

    private static final String SOURCE_FILE = "problem002.json";
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
            int[] actual = TestCase.toArray(Solution.addTwoNumbers(testCase.getL1(), testCase.getL2()));
            assertArrayEquals(testCase.expected, actual);
        }
    }

}


