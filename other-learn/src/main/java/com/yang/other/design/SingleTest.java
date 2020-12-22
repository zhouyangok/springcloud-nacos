package com.yang.other.design;

/**
 * @ClassName SingleTest
 * @Description: 单例模式，懒汉式
 * @Author zhouyang
 * @Date 2020/12/22 下午8:46.
 */
public class SingleTest {
    public static void main(String[] args) {
//        Singleton instance = Singleton.getInstance();
//        Singleton instance1 = Singleton.getInstance();
//        System.out.println(instance == instance1);

        new Thread(()->{
            Singleton instance2 = Singleton.getInstance();
            System.out.println(instance2);
        }).start();

        new Thread(()->{
            Singleton instance2 = Singleton.getInstance();
            System.out.println(instance2);
        }).start();
    }

}

class Singleton {
    private static Singleton singleton = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class){
                if(singleton==null){ //双重检查
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
