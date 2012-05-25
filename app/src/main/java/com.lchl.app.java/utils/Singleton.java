package com.lchl.app.java.utils;

/**
 * Created by IntelliJ IDEA.
 * User: chaohua.luo
 * Date: 12-4-27
 * Time: 下午7:03
 * To change this template use File | Settings | File Templates.
 */
public class Singleton {
    private static Singleton instance = null;
    // 同步时加锁的静态对象
    private static final Object OL = new Object();

    private Singleton() {
        // Class initialize
    }

    /*
     * 在多线程环境下执行时的双重检查Double Check
     */
    public static Singleton getSynchronizedInstance() {
        if (instance == null) {
            synchronized (OL) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    /*
     * 在非多线程环境下使用
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    /*
     * 静态内部类的实例与外部类的实例没有绑定关系，只有其被调用到才会装载，从而实现延迟加载
     */
    public static class SingletonHolder {
        // 静态域对象初始化，由JVM来保证线程安全
        private static Singleton instance = new Singleton();
    }

    public static Singleton getStaticInstance() {
        return SingletonHolder.instance;
    }
}