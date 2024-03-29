package com.yang.other.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName KuoHaoGenerator
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/9/16 上午8:59.
 */

public class KuoHaoGenerator {
    public static void main(String[] args) {
        KuoHaoGenerator s = new KuoHaoGenerator();
        List<String> result = s.generateParenthesis(2);
        System.out.println(result.toString());
    }

        List<String> res = new ArrayList<>();
        private  List<String> generateParenthesis(int n) {
            if(n <= 0){
                return res;
            }
            getParenthesis("",n,n);
            return res;
        }

        private  void getParenthesis(String str,int left, int right) {
            if(left == 0 && right == 0 ){
                res.add(str);
                return;
            }
            if(left == right){
                //剩余左右括号数相等，下一个只能用左括号
                getParenthesis(str+"(",left-1,right);
            }else if(left < right){
                //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
                if(left > 0){
                    getParenthesis(str+"(",left-1,right);
                }
                getParenthesis(str+")",left,right-1);
            }
        }
}
