package com.wxf.job.flink;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class FlinkTest {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> ds = env.readTextFile("D:\\develop\\dataset\\公交车辆统计信息.csv");

        ds.print();

        env.execute("测试任务");

    }
}
