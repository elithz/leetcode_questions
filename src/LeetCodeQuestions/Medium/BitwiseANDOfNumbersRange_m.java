package LeetCodeQuestions.Medium;

public class BitwiseANDOfNumbersRange_m {
    class Solution {
        // public int rangeBitwiseAnd(int m, int n) {
        //     int ans = 0;
        //     for(int i = m; i <= n; i ++)
        //         if(i == m) ans = m;
        //         else ans = ans & i;
        //     return ans;
        // }
        public int rangeBitwiseAnd(int m, int n) {
            if(m == 0){
                return 0;
            }
            int moveFactor = 1;
            while(m != n){
                m >>= 1;
                n >>= 1;
                moveFactor <<= 1;
            }
            return m * moveFactor;
        }
    }
}
