package com.wxf

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession


/**
 * WordCount
 *
 * @author wxf
 * @since 2023-11-15 22:22:00
 */
object WordCount {

  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("local")
      .appName("WordCount")
      .getOrCreate()

    val sc: SparkContext = spark.sparkContext

    val df: RDD[String] = sc.textFile("")
    val countRdd: RDD[(String, Int)] = df.flatMap(line => line.split("\\w+"))
      .map(word => (word, 1))
      .reduceByKey(_ + _)

    val result: Array[(String, Int)] = countRdd.sortBy(_._2)
      .top(5)


    spark.stop
  }

}
