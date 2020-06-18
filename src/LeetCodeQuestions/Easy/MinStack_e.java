package LeetCodeQuestions.Easy;

import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack_e {
    class MinStack {

        Stack<Integer> stack;
        PriorityQueue<Integer> pq;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<Integer>();
            pq = new PriorityQueue<>();
        }

        public void push(int x) {
            stack.push(x);
            pq.add(x);
        }

        public void pop() {
            int temp = stack.pop();
            pq.remove(temp);
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return pq.peek();
        }
    }
}
