package LeetCodeQuestions.Medium;

import java.util.Arrays;

public class sort_colors_m {
    public static void main(String args[]){
        int[] test = {2,0,2,1,1,0};
        sortColors(test);
        System.out.println(Arrays.toString(test));
    }
    public static void sortColors(int[] nums){
        int low = 0;
        int high = nums.length - 1;
        sort(low, high, nums);
    }

    private void sortColors_p(int[] nums){
        int index = 0;
        int index2 = nums.length - 1;
        int i = 0;
        while(i <= index2){
            if(nums[i] == 0){
                nums[index] = nums[i];
                nums[i] = 0;
                index ++;
            }
            if(nums[i] == 2){
                nums[index2] = nums[i];
                nums[i] = 2;
                index2 --;
                i --;
            }
            i ++;
        }
    }

    public static void sort(int low, int high, int[] nums){
        if(low < high){
            int pi = partition(low, high, nums);
            sort(low, pi - 1, nums);
            sort(pi + 1, high, nums);
        }
    }

    public static int partition(int low, int high, int[] nums){
        int re = 0;
        int pivot = nums[high];
        int i = (low - 1);
        for(int j = low; j < high; j ++){
            if(nums[j] < pivot){
                i ++;
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }
        }
        int t = nums[i + 1];
        nums[i + 1] = nums[high];
        nums[high] = t;
        return i + 1;
    }
}
