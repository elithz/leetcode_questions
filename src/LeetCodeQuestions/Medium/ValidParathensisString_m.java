package LeetCodeQuestions.Medium;

public class ValidParathensisString_m {
    class Solution {
        public boolean checkValidString(String s) {
//         Stack<Integer> p = new Stack<>();
//         Stack<Integer> st = new Stack<>();

//         for(int i = 0; i < s.length(); i ++){
//             char thisChar = s.charAt(i);
//             if(thisChar == '(')
//                 p.push(i);
//             else if(thisChar == '*')
//                 st.push(i);
//             else{
//                 if(!p.empty())
//                     p.pop();
//                 else if(!st.empty())
//                     st.pop();
//                 else
//                     return false;
//             }
//         }

//         while(!p.empty() && !st.empty()){
//             if(p.peek() > st.peek()) return false;
//             p.pop();
//             st.pop();
//         }
//         return p.empty();


            int lo = 0, hi = 0;
            for (char c : s.toCharArray()) {
                lo += c == '(' ? 1 : -1;
                hi += c != ')' ? 1 : -1;
                if (hi < 0) break;
                lo = Math.max(lo, 0);
            }
            return lo == 0;

        }
    }
}
