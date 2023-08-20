package com.wxf.job.job;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 日志输入流消费
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/5/26 10-01:50
 */
@Slf4j
public class InputStreamReaderRunnable implements Runnable {

    private final BufferedReader reader;

    private final String name;

    public InputStreamReaderRunnable(BufferedReader reader, String name) {
        this.reader = reader;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
        try {
            String line = reader.readLine();
            while (line != null) {
                line = reader.readLine();
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
