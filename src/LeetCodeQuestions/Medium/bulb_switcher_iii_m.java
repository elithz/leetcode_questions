package LeetCodeQuestions.Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class bulb_switcher_iii_m {
    public static void main(String args[]){
//        int[] test = {4,1,2,3};
//        System.out.println(numTimesAllBlue(test));

    }
    public static int numTimesAllBlue(int[] light){
        int ans = 0;
        int n = light.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i = 0; i < n; i ++){
            pq.add(light[i]);
            if(pq.peek() == pq.size()) ans ++;
        }
        return ans;
    }
}
