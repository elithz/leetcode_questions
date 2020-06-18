package practice;

import java.util.Arrays;
import java.util.Scanner;

public class mihayo_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        String arrayStr = "";
        while(i == 0){
            arrayStr = scanner.nextLine();
            i ++;
        }
        String[] strs = arrayStr.split(" ");
        int[] data = new int[strs.length];
        for(int j = 0; j < strs.length; j ++){
            data[j] = Integer.parseInt(strs[j]);
        }
        System.out.println(Arrays.toString(arrayArrange(data)));
    }
    static int[] arrayArrange(int[] arr){
        int[] ans = new int[2];
        int n = arr.length;
        int[] temp = new int[n];
        for(int i = 0; i < n; i ++){
            if(arr[Math.abs(arr[i]) - 1] > 0){
                arr[Math.abs(arr[i]) - 1] = - arr[Math.abs(arr[i]) - 1];
                temp[Math.abs(arr[i]) - 1] = 1;
            }else{
                ans[1] = Math.abs(arr[i]);
            }
        }
        for(int i = 0; i < n; i ++)
            if(temp[i] == 0) ans[0] = i + 1;
        return ans;
    }
}
