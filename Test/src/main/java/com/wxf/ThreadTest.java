package com.wxf;

import java.util.concurrent.CountDownLatch;

/**
 * 线程测试
 *
 * @author Wxf
 * @since 2023-11-10 23:26:49
 **/
public class ThreadTest {


    public static void main(String[] args) throws InterruptedException {
        test02();

    }

    static void test02() throws InterruptedException {
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(new SubTask(i, countDownLatch)).start();
        }

        countDownLatch.await();

        long end = System.currentTimeMillis();


        try {
            Thread.currentThread().join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");


        System.out.println("duration is " + (end - start));
    }

    static class SubTask implements Runnable {
        private final int id;
        private final CountDownLatch countDownLatch;

        public SubTask(int id, CountDownLatch countDownLatch) {
            this.id = id;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("thread " + id + " start...");
            try {
                countDownLatch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("thread " + id + " end...");
        }
    }


    static void test01() {
        Thread thread = new Thread(() -> {
            pong();
        });

        thread.run();

        System.out.println("ping");
    }

    static void pong() {
        System.out.println("pong");
    }
}
