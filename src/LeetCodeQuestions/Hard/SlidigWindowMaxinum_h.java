package LeetCodeQuestions.Hard;

import java.util.Deque;
import java.util.LinkedList;

public class SlidigWindowMaxinum_h {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] ans = new int[nums.length - (k - 1)];
            Deque<Integer> deque = new LinkedList<Integer>();
            int i;
            for (i = 0; i < k; i++) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
                    deque.removeLast();
                deque.addLast(i);
            }
            int j = 0;
            for (i = i; i < nums.length; i++) {
                ans[j] = nums[deque.peekFirst()];
                j++;
                while ((!deque.isEmpty()) && deque.peekFirst() <= i - k)
                    deque.removeFirst();
                while ((!deque.isEmpty()) && nums[i] >= nums[deque.peekLast()])
                    deque.removeLast();
                deque.addLast(i);
            }
            ans[ans.length - 1] = nums[deque.peekFirst()];
            return ans;
        }
    }
}
