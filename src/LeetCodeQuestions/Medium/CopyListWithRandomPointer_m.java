package LeetCodeQuestions.Medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer_m {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Node coursor = new Node(head.val);
            coursor.next = null;
            coursor.random = null;
            Map<Node, Node> map = new HashMap<Node, Node>();
            map.put(head, coursor);
            Node ans = coursor;
            while (head != null) {
                if (head.next != null) {
                    if (map.containsKey(head.next)) {
                        coursor.next = map.get(head.next);
                    } else {
                        coursor.next = new Node(head.next.val);
                        map.put(head.next, coursor.next);
                    }
                }


                if (head.random != null) {
                    if (map.containsKey(head.random)) {
                        coursor.random = map.get(head.random);
                    } else {
                        coursor.random = new Node(head.random.val);
                        map.put(head.random, coursor.random);
                    }
                }
                head = head.next;
                coursor = coursor.next;
            }
            return ans;
        }
    }
}
