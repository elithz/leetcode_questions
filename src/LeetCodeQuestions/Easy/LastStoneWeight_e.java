package LeetCodeQuestions.Easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight_e {
    class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            for (int i = 0; i < stones.length; i++) {
                pq.add(stones[i]);
            }

            while (pq.size() > 1) {
                int weightY = pq.poll();
                int weightX = pq.poll();
                if (weightX != weightY)
                    pq.add(weightY - weightX);
            }

            if (pq.size() == 1)
                return pq.poll();
            else
                return 0;
        }
    }
}
