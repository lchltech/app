package com.lchl.app.java.conccurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 * File Descriptions.
 * User: chaohua.luo
 * Date: 12-5-25 上午10:59
 * Note:
 * </pre>
 */
public class ReentrantLockThread implements Runnable {
    private static ReentrantLock thread = new ReentrantLock();
    private int id;

    public ReentrantLockThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try{
            thread.lock();
            System.out.println("线程" + id + "获得锁" + thread.toString());
        } finally {
            System.out.println("线程" + id + "释放锁" + thread.toString());
            thread.unlock();
        }
    }
}
