package LeetCodeQuestions.Easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class best_time_to_by_and_sell_stcok_ii_e {
    public static void main(String args[]){
        int[] testdata = {6,1,3,2,4,7};
        System.out.println(maxProfit(testdata));
    }
    public static int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        pq.add(prices[0]);

        for(int i = 1; i < prices.length; i ++){
            if(prices[i] - pq.peek() > ans){
                ans = prices[i] - pq.peek();
                //pq.poll();
                //continue;
            }
            pq.add(prices[i]);
        }
        return ans;
    }
}
