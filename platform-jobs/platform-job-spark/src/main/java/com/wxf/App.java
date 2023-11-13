package com.wxf;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("App")
                .master("local")
                .getOrCreate();



        spark.stop();
    }
}
