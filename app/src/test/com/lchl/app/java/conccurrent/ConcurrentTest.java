package com.lchl.app.java.conccurrent;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 * File Descriptions.
 * User: chaohua.luo
 * Date: 12-5-25 上午11:10
 * Note:
 * </pre>
 */
public class ConcurrentTest {
    private ExecutorService executor;

    @Before
    public void setUp() throws Exception {
//        executor = Executors.newCachedThreadPool();
        executor = Executors.newFixedThreadPool(5);
    }

    @Test
    public void testReentrantLockThread() throws Exception {
        for (int i = 0; i < 100; i++) {
            ReentrantLockThread task = new ReentrantLockThread(i + 1);
            executor.submit(task);

        }

        executor.shutdown();
    }

    @Test
    public void testBlockingQueueThread() throws Exception {
        final int QUEUE_SIZE = 30;
        for (int i = 0; i < QUEUE_SIZE; i++) {
            executor.submit(new BlockingQueueThread(i + 1));
        }

        Thread task = new Thread() {
            public void run() {
                try {
                    int count = 0;
                    while (true) {
                        BlockingQueueThread.take();
                        if (++count > QUEUE_SIZE) break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        executor.submit(task);
        executor.shutdown();
    }
}
