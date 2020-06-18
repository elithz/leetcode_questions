package LeetCodeQuestions.Easy;

public class IntersectionOfTwoLinkedLists_e {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // Set<ListNode> set = new HashSet<>();
            // while(headA != null){
            //     set.add(headA);
            //     headA = headA.next;
            // }
            // while(headB != null){
            //     if(!set.add(headB))
            //         return headB;
            //     else
            //         headB = headB.next;
            // }
            // return null;
            if (headA == null || headB == null) return null;


            ListNode a = headA;
            ListNode b = headB;


            while (a != b) {
                a = a == null ? headB : a.next;
                b = b == null ? headA : b.next;
            }

            return a;
        }
    }
}
