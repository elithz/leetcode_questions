package LeetCodeQuestions.Easy;

public class generate_a_string_with_characters_that_have_odd_counts_e {
    public static void main(String args[]){
        System.out.println(generateTheString(5));
    }

    public static String generateTheString(int n){
        String ans = "";
        if(n % 2 == 1){
            for(int i = 0; i < n; i ++){
                ans += "a";
            }
        }else{
            for(int i = 0; i < n - 1; i ++){
                ans += "a";
            }
            ans += "b";
        }
        return ans;
    }
}
