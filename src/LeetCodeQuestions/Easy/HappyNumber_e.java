package LeetCodeQuestions.Easy;

import java.util.HashSet;

public class HappyNumber_e {
    class Solution {
        public boolean isHappy(int n) {
            HashSet<Integer> hashset = new HashSet<>();
            hashset.add(n);
            while(n != 1){
                String str = Integer.toString(n);
                int result = 0;
                for(int i = 0; i < str.length(); i ++){
                    result += Math.pow(Character.getNumericValue(str.charAt(i)), 2);
                }
                if (hashset.contains(result)) {
                    return false;
                }
                hashset.add(result);
                n = result;
            }
            return true;

        }
    }
}
