package com.yang.other.datastructure;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName Test
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/31 下午9:33.
 */

public class Test {
    public static void main(String[] args) {
        int c = 3;
        int a = c;
        int b = c;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
//        System.out.println("a = "+a);
//        System.out.println("b = "+b);
//        test();
        testSort();
    }

    public static void test(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<3;i++){
            stringBuilder.append("ss"+i).append(",");
        }
        List list = new ArrayList<String>();
        list.add("sr dd");
        list.add("sr2 dd");
        list.add("sr3 dd");
        System.out.println(stringBuilder.deleteCharAt(stringBuilder.length()-1).toString());
    }

    public static void testSort(){
        List<TestUser> list = new ArrayList();
        for(int i=5;i<100;i++){
            TestUser user = new TestUser(i,21,"22");
            list.add(user);
        }
        TestUser user2 = new TestUser(2,19,"tt");
        TestUser user3 = new TestUser(1,19,"tt");
        TestUser user4 = new TestUser(4,20,"tt");
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.sort(Comparator.comparing(TestUser::getAge));
        list.forEach(p-> System.out.println(p));
    }
}
@Data
@AllArgsConstructor
class TestUser{
    int id;
    int age;
    String name;
}
