package LeetCodeQuestions.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class merge_intervals_m {
    public static void main(String args[]){

    }

    public static int[][] merge(int[][] intervals){
        if(intervals.length <= 1){
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        ArrayList<int[]> ans = new ArrayList<>();
        int[] t = intervals[0];
        ans.add(t);
        for(int i = 0; i < intervals.length; i ++){
            if (intervals[i][0] <= ans.get(ans.size()-1)[1]){
                ans.get(ans.size()-1)[1] = Math.max(intervals[i][1], ans.get(ans.size()-1)[1]);
            }else{
                ans.add(intervals[i]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
