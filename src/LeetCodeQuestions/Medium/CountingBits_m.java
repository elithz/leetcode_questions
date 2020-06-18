package LeetCodeQuestions.Medium;

public class CountingBits_m {
    class Solution {
        public int[] countBits(int num) {
            int[] ans = new int[num + 1];
            for (int i = 0; i <= num; i++) {
                int k = i;
                int count = 0;
                while (k != 0) {
                    if (k % 2 != 0) count++;
                    k = k / 2;
                }
                ans[i] = count;
            }
            return ans;
//            int result[] = new int[num + 1];
//            int offset = 1;
//            for (int index = 1; index < num + 1; ++index) {
//                if (offset * 2 == index) {
//                    offset *= 2;
//                }
//                result[index] = result[index - offset] + 1;
//            }
//            return result;
        }
    }
}
