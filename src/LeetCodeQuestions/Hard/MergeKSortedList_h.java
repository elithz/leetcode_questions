package LeetCodeQuestions.Hard;

import java.util.PriorityQueue;

public class MergeKSortedList_h {

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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            ListNode dummy = new ListNode(0);
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (ListNode node : lists) {
                if (node != null) {
                    pq.add(node.val);
                    while (node.next != null) {
                        pq.add(node.next.val);
                        node = node.next;
                    }
                }
            }
            ListNode lead = dummy;
            while (pq.size() > 0) {
                ListNode newNode = new ListNode(pq.poll());
                lead.next = newNode;
                lead = lead.next;
            }
            return dummy.next;
        }
    }
}
