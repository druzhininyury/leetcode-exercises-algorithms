package ru.druzhininyy.leetcode.exercises.algorithms.problem0019;

public class Solution {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prevNode = null;
        ListNode nodeToDelete = head;
        ListNode endNode = head;

        for (int i = 1; i < n; ++i) {
            if (endNode.next == null) {
                throw new IllegalArgumentException("Argument n must be less or equal to list size.");
            }
            endNode = endNode.next;
        }

        while (endNode.next != null) {
            prevNode = nodeToDelete;
            nodeToDelete = nodeToDelete.next;
            endNode = endNode.next;
        }

        if (head == nodeToDelete) {
            head = nodeToDelete.next;
        }

        if (prevNode != null) {
            prevNode.next = nodeToDelete.next;
        }

        return head;
    }

}
