package LeetCodeQuestions.Easy;

import java.util.Stack;

public class PalindromeLinkedList_e {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            ListNode coursor = head;
            while (coursor != null) {
                stack.push(coursor.val);
                coursor = coursor.next;
            }
            coursor = head;
            while (coursor != null) {
                if (coursor.val != stack.pop()) return false;
                coursor = coursor.next;
            }
            return true;
        }
    }
}
