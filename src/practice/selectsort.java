package practice;

import java.util.Arrays;

public class selectsort {

    public static void main(String args[]){
        int[] testdata = {2,1,5,4,6,3};
        select(testdata);
        System.out.println(Arrays.toString(testdata));
    }
    public static void select(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i ++){
            int min = i;
            for(int j = i + 1; j < n; j ++)
                if(arr[j] < arr[min])
                    min = j;
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
        }
    }
}
