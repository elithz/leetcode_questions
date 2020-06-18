package LeetCodeQuestions.Hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses_h {
    class Solution {
        Set<String> validExpressions = new HashSet<String>();
        int minimumRemoved;

        void reset() {
            this.validExpressions.clear();
            this.minimumRemoved = Integer.MAX_VALUE;
        }

        void recurse(String s,
                     int index,
                     int leftCount,
                     int rightCount,
                     StringBuilder expression,
                     int removedCount) {
            if (index == s.length()) {
                if (leftCount == rightCount && removedCount <= this.minimumRemoved) {
                    String ans = expression.toString();
                    if (removedCount < this.minimumRemoved) {
                        this.validExpressions.clear();
                        this.minimumRemoved = removedCount;
                    }
                    this.validExpressions.add(ans);
                }
            } else {
                char curChar = s.charAt(index);
                int len = expression.length();
                if (curChar != '(' && curChar != ')') {
                    expression.append(curChar);
                    recurse(s, index + 1, leftCount, rightCount, expression, removedCount);
                    expression.deleteCharAt(len);
                } else {
                    recurse(s, index + 1, leftCount, rightCount, expression, removedCount + 1);
                    expression.append(curChar);
                    if (curChar == '(')
                        recurse(s, index + 1, leftCount + 1, rightCount, expression, removedCount);
                    else if (rightCount < leftCount)
                        recurse(s, index + 1, leftCount, rightCount + 1, expression, removedCount);
                    expression.deleteCharAt(len);
                }
            }
        }

        public List<String> removeInvalidParentheses(String s) {
            reset();
            recurse(s, 0, 0, 0, new StringBuilder(), 0);
            return new ArrayList(validExpressions);
        }
    }
}
