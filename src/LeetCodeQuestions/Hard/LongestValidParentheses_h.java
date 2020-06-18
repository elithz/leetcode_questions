package LeetCodeQuestions.Hard;

import java.util.Stack;

public class LongestValidParentheses_h {
    class Solution {
        public int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            int index = -1;
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                char thisChar = s.charAt(i);
                if (thisChar == '(')
                    stack.push(i);
                else if (stack.empty())
                    index = i;
                else {
                    stack.pop();
                    if (stack.isEmpty()) max = Math.max(max, i - index);
                    else max = Math.max(max, i - stack.peek());
                }
            }

            return max;
        }
    }
}
