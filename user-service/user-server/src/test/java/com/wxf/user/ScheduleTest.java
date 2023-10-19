package com.wxf.user;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author Wxf
 * @since 2023-10-19 22:06:04
 **/
public class ScheduleTest {

    public static void main(String[] args) {


        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println(-1);
            }
        };

        System.out.println(3);
        timer.scheduleAtFixedRate(timerTask,1000,2000);

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(4);
        timerTask.cancel();
        timer.cancel();


        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);

        System.out.println(0);
        ScheduledFuture<?> scheduledFuture = scheduledThreadPool.scheduleAtFixedRate(() -> {
            System.out.println(1);
        }, 1, 2, TimeUnit.SECONDS);

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(2);

        scheduledThreadPool.shutdownNow();
    }
}
