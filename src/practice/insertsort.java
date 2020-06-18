package practice;

import java.util.Arrays;

public class insertsort {
    public static void main(String args[]){
        int[] testdata = {2,1,5,4,6,3};
        insert(testdata);
        System.out.println(Arrays.toString(testdata));
    }
    private static void insert(int[] arr){
        int n = arr.length;
        for(int i = 1; i < n; i ++){
            int curr = arr[i];
            int j;
            for(j = i - 1; j >= 0; j --){
                if(curr >= arr[j]) break;
                else{
                    arr[j + 1] = arr[j];
                }
            }

            arr[j + 1] = curr;
        }
    }
}
