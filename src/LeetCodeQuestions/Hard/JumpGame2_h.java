package LeetCodeQuestions.Hard;

public class JumpGame2_h {
    public static void main(String[] args) {
        int[] testData = {2, 3, 1, 1, 4};
        System.out.println(jump(testData));
    }

    public static int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFurthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFurthest = Math.max(curFurthest, i + nums[i]);
            if (curEnd == i) {
                jumps++;
                curEnd = curFurthest;
            }
        }
        return jumps;
    }
}


