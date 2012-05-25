package com.lchl.app.java.conccurrent;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueThread extends Thread {
    public static final int QUEUE_MAX_SIZE = 100;
    private static BlockingQueue<String> queue = new LinkedBlockingQueue<String>(QUEUE_MAX_SIZE);
    private static ReentrantLock lock = new ReentrantLock();
    private int index;

    public BlockingQueueThread(int index) {
        this.index = index;
    }

    public void run() {
        try {
            lock.lock();
            queue.put(String.valueOf(this.index));
            System.out.print(index + "->");
            print();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    
    public static void take() {
        try {
            lock.lock();
            String element = queue.take();
            System.out.print(element + "<-");
            print();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static BlockingQueue<String> getQueue() {
        return queue;
    }

    public static void print() {
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
