package com.yang.other.leecode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName ReveseNode
 * @Description: 从尾到头打印链表
 * @Author zhouyang
 * @Date 2021/9/8 下午8:54.
 */

public class ReverseNode {

    public static void main(String[] args) {

    }

    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int [] arr =new int[stack.size()];
        for(int i=0;i<stack.size();i++){
            arr[i]=stack.pop();
        }
        return arr;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }
}
