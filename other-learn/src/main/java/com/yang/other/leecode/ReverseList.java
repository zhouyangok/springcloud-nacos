package com.yang.other.leecode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName ReverseList
 * @Description: 反转链表
 * @Author zhouyang
 * @Date 2021/9/9 下午8:43.
 */

public class ReverseList {

    public static void main(String[] args) {

    }

    public ListNode2 reverseList(ListNode2 head){
        ListNode2 p = null;
        ListNode2 h = null;
        while (head!=null){
            //尾插法
            h = head;
            head = head.next;
            h.next = p;
            p = h;

        }
        return p;

    }
}

class ListNode2 {
      int val;
      ListNode2 next;
      ListNode2(int x) { val = x; }
}
