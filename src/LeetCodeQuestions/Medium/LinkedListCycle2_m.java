package LeetCodeQuestions.Medium;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle2_m {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            Map<ListNode, Integer> map = new HashMap<>();
            int pos = -1;
            while (head != null) {
                if (!map.containsKey(head)) map.put(head, pos++);
                else return head;
                head = head.next;
            }
            return null;

//            if (head == null || head.next == null) {
//                return null;   // no circle
//            }
//            ListNode slow = head, fast = head;
//            while (fast != null && fast.next != null) {
//                fast = fast.next.next;
//                slow = slow.next;
//                if (fast == slow) {  // circle detected
//                    while (head != fast) {
//                        fast = fast.next;
//                        head = head.next;
//                    }
//                    return head;
//                }
//            }
//            return null; // no circle
        }
    }
}
