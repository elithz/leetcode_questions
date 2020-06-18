package LeetCodeQuestions.Medium;

import java.util.HashMap;
import java.util.Map;

public class CountiguousArray_m {
    class Solution {
        public int findMaxLength(int[] nums) {
            int maxLength = 0;
            int currsum = 0;
            Map<Integer, Integer> map = new HashMap<>();

            map.put(0, -1);

            for (int i = 0; i < nums.length; i++) {
                currsum += nums[i] == 0 ? -1 : nums[i];

                if (map.containsKey(currsum)) {
                    maxLength = Math.max(maxLength, i - map.get(currsum));
                } else {
                    map.put(currsum, i);
                }

            }

            return maxLength;
        }
    }
}
