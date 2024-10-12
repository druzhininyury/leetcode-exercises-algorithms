package ru.druzhininyy.leetcode.exercises.algorithms.problem0021;

public class Solution {

    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }

        if (head2 == null) {
            return head1;
        }

        if (head1 == null) {
            return head2;
        }

        ListNode currentNode1 = head1;
        ListNode currentNode2 = head2;
        ListNode resultHead;
        ListNode currentNode;

        if (currentNode1.val <= currentNode2.val) {
            resultHead = head1;
            currentNode1 = currentNode1.next;
        } else {
            resultHead = head2;
            currentNode2 = currentNode2.next;
        }
        currentNode = resultHead;

        while (currentNode1 != null & currentNode2 != null) {
            if (currentNode1.val <= currentNode2.val) {
                currentNode.next = currentNode1;
                currentNode1 = currentNode1.next;
            } else {
                currentNode.next = currentNode2;
                currentNode2 = currentNode2.next;
            }
            currentNode = currentNode.next;
        }

        if (currentNode1 != null) {
            currentNode.next = currentNode1;
        }
        if (currentNode2 != null) {
            currentNode.next = currentNode2;
        }

        return resultHead;
    }

}
