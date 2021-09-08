package com.yang.other.leecode;

import java.util.Stack;

/**
 * @ClassName ValidKuoHao
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/9/2 上午8:38.
 */

public class ValidKuoHao {

    public static void main(String[] args) {
        String s ="))";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            }
            else if (c == '{') {
                stack.push('}');
            }
            else if (c == '[') {
                stack.push(']');
            }else if(stack.isEmpty()){
                return false;
            }
            else if(!stack.isEmpty() && stack.pop()!=c){
                return false;
            }

        }
        return stack.isEmpty();
    }
}
