package LeetCodeQuestions.Easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class best_time_to_buy_and_sell_stock_e {
    public static void main(String args[]) {
        int[] testdata = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(testdata));
    }

    public static int maxProfit(int[] prices) {

        for (int i = 1; i < prices.length; i++)
            prices[i - 1] = Math.max(0, prices[i] - prices[i - 1]) + (i == 1 ? 0 : prices[i - 2]);
        return prices.length < 2 ? 0 : prices[prices.length - 2];

    }
}
