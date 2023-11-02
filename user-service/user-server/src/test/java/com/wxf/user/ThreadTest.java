package com.wxf.user;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 父子线程测试
 *
 * @author Wxf
 * @since 2023-10-31 10:39:33
 **/
@Slf4j
public class ThreadTest {


    @org.junit.Test
    public void test01() {
        for (int i = 0; i < 10; i++) {
            new SubThread("线程---" + i).start();
        }

        this.notifyAll();

        System.out.println("start...");
    }


    @Slf4j
    static class SubThread extends Thread {


        public SubThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (this) {
                try {
                    log.info("{} starting", super.getName());
                    wait(1000);
                    log.info("{} ending", super.getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }


}
