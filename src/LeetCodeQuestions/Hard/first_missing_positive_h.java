package LeetCodeQuestions.Hard;

import java.util.Arrays;

public class first_missing_positive_h {
    public static void main(String args[]){
        int[] t = {1, 1};
        System.out.println(firstMissingPositive(t));
    }
    public static int firstMissingPositive(int[] nums){
        int ans = 1;
        Arrays.sort(nums);
        int min = 0;
        int index = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] > 0){
                min = nums[i];
                index = i;
                break;
            }
        }

        if(min > 1 || min == 0) return 1;
        if(nums.length - index == 1) return 2;
        else{
            for(int i = index; i < nums.length; i ++) {
                if(i != nums.length - 1){
                    if (nums[i] == nums[i + 1]) continue;
                    if (nums[i] + 1 != nums[i + 1]) {
                        ans = nums[i] + 1;
                        break;
                    }
                }else ans = nums[i] + 1;

            }
        }

        return ans;
    }
}
