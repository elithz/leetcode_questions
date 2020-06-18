package LeetCodeQuestions.Easy;

public class MiddleOfTheLinkedList_e {

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
        public ListNode middleNode(ListNode head) {
            int count = 1;
            ListNode coursor = head;
            while (coursor.next != null) {
                coursor = coursor.next;
                count++;
            }
            coursor = head;

            for (int i = 1; i <= count / 2; i++) {
                coursor = coursor.next;
            }
            return coursor;

        }
    }
}
