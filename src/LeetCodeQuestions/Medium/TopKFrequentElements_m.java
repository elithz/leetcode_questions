package LeetCodeQuestions.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements_m {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            // counter, entry map
            int[] ans = new int[k];
            Map<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                    (a, b) -> b.getValue() - a.getValue()
            );
            for (int i = 0; i < nums.length; i++) {
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], 1);
                } else {
                    map.replace(nums[i], map.get(nums[i]), map.get(nums[i]) + 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                pq.add(entry);
            }
            for (int i = 0; i < k; i++) {
                ans[i] = pq.poll().getKey();
            }
            return ans;
        }
    }
}
