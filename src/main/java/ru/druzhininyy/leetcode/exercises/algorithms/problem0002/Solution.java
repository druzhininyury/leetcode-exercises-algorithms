package ru.druzhininyy.leetcode.exercises.algorithms.problem0002;

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();

        int memory = 0;
        ListNode currentNode = head;
        while (l1 != null && l2 != null) {
            int sum = l1.val  + l2.val + memory;
            memory = sum / 10;
            ListNode nextNode = new ListNode(sum % 10);
            currentNode.next = nextNode;

            l1 = l1.next;
            l2 = l2.next;
            currentNode = nextNode;
        }

        while (l1 != null) {
            int sum = l1.val + memory;
            memory = sum / 10;
            ListNode nextNode = new ListNode(sum % 10);
            currentNode.next = nextNode;

            l1 = l1.next;
            currentNode = nextNode;
        }

        while (l2 != null) {
            int sum = l2.val + memory;
            memory = sum / 10;
            ListNode nextNode = new ListNode(sum % 10);
            currentNode.next = nextNode;

            l2 = l2.next;
            currentNode = nextNode;
        }

        if (memory != 0) {
            currentNode.next = new ListNode(memory);
        }

        return head.next;
    }
}
