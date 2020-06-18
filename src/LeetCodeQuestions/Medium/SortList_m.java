package LeetCodeQuestions.Medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SortList_m {

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
        public ListNode sortList(ListNode head) {
            // if(head == null || head.next == null) return head;
            // PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            //     public int compare(ListNode o1, ListNode o2){
            //         return o1.val - o2.val;
            //     }
            // });
            // while(head != null){
            //     pq.add(head);
            //     head = head.next;
            // }
            // ListNode ans = pq.poll();
            // ListNode res = ans;
            // while(pq.size() > 0){
            //     ans.next = pq.poll();
            //     ans = ans.next;
            // }
            // ans.next = null;
            // return res;


            // mergesort method with dual pointer
            if (head == null || head.next == null) return head;
            ListNode slow = head, fast = head, pre = null;
            while (fast != null && fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            pre.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(slow);

            return merge2Lists(left, right);
        }

        ListNode merge2Lists(ListNode l, ListNode r) {
            ListNode node = new ListNode(0), coursor = node;
            while (l != null && r != null) {
                if (l.val < r.val) {
                    coursor.next = l;
                    l = l.next;
                } else {
                    coursor.next = r;
                    r = r.next;
                }
                coursor = coursor.next;
            }
            if (l != null)
                coursor.next = l;
            else if (r != null)
                coursor.next = r;

            return node.next;
        }
    }
}
