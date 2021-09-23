package com.yang.other.leecode;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName RemoveElement
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/9/23 下午8:53.
 */
@Slf4j
public class RemoveElement {

    public static void main(String[] args) {
        log.debug("aaa");
        int [] nums ={1,2,3,4,3,4,5,7};
        removeElement(nums,3);
    }

    public static void removeElement(int[] nums, int val) {
        int j =0;
        for(int i =0;i< nums.length;i++){
            if(nums[i] != val){
                nums[j]= nums[i];
                j++;
            }
        }
        log.debug("数组计算结果,{}",nums);
    }
}
