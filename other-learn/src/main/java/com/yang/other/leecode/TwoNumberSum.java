package com.yang.other.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TwoNumberSum
 * @Description: 两数之和
 * @Author zhouyang
 * @Date 2021/9/1 下午8:14.
 */

public class TwoNumberSum {

    public static void main(String[] args) {
        int arr[] = {1,2, 4, 6};
       int [] result = twoSum(arr,6);
        System.out.println(result.toString());

    }

    public static int[] twoSum(int[] arr, int target) {
        for (int n = arr.length-1; n >= 0; n--) {
            for (int m = 0; m < n; m++) {
                if (target == arr[n] + arr[m]) {
                    return new int[]{m, n};
                }
            }
        }
        return null;
    }

    public static  int[] twoSumMap(int[] arr, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(target-arr[i])){
                return new int[]{map.get(target-arr[i]),i};
            }
            map.put(arr[i],i);
        }
        return null;
    }
}
