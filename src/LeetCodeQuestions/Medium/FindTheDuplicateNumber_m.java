package LeetCodeQuestions.Medium;

public class FindTheDuplicateNumber_m {
    class Solution {
        public int findDuplicate(int[] nums) {
            int slow = nums[0], fast = nums[0];
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);

            slow = nums[0];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }

            return fast;

            // Set<Integer> set = new HashSet<>();
            // for(int i = 0; i < nums.length; i ++){
            //     if(!set.contains(nums[i]))
            //         set.add(nums[i]);
            //     else return nums[i];
            // }
            // return -1;
        }
    }
}
