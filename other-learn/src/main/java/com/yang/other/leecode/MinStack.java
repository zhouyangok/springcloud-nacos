package com.yang.other.leecode;

import java.util.LinkedList;

/**
 * @ClassName MinStack
 * @Description: 包含 min 函数的栈
 * @Author zhouyang
 * @Date 2021/9/10 上午9:16.
 */

public class MinStack {

    LinkedList<Integer> A, B;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        //用来存所有数据
        A = new LinkedList();
        //用来存最小值
        B = new LinkedList();
    }

    public void push(int x) {
        A.push(x);
        if(B.isEmpty()||B.getLast()>x){
            B.push(x);
        }
    }

    public void pop() {
        if(A.removeLast() == B.getLast()){
            B.removeLast();
        }
    }

    public int top() {
        return A.getLast();
    }

    public int min() {
        return B.getLast();
    }
}
