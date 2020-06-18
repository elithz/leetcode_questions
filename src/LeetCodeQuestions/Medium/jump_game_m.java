package LeetCodeQuestions.Medium;

public class jump_game_m {
    public static void main(String args[]) {

    }

    public static boolean canJump(int[] nums) {

        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;

    }
}
