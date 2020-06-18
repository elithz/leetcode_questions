package LeetCodeQuestions.Medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_m {
    class Solution {
        // public int subarraySum(int[] nums, int k) {
        //     Map<Integer, Integer> sumToPosition = new HashMap<>();
        //     int count = 0;
        //     int currSum = 0;
        //     if(nums.length == 0) return count;
        //     sumToPosition.put(0, 0);
        //     for(int i = 1; i <= nums.length; i ++){
        //         currSum += nums[i - 1];
        //         sumToPosition.put(i, currSum);
        //     }
        //     for(int i = 0; i < nums.length; i ++){
        //         for(int j = i + 1; j <= nums.length; j ++){
        //             if(sumToPosition.get(j) - sumToPosition.get(i) == k)
        //                 count ++;
        //         }
        //     }
        //     return count;
        // }

        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> sumToOccur = new HashMap<>();
            int count = 0;
            int currSum = 0;
            sumToOccur.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                currSum += nums[i];
                if (sumToOccur.containsKey(currSum - k))
                    count += sumToOccur.get(currSum - k);
                sumToOccur.put(currSum, sumToOccur.getOrDefault(currSum, 0) + 1);
            }
            return count;
        }

    }
}
