package com.dt.spark

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wangchong on 2017/2/14.
  */
object sparksql {
  def main(args: Array[String]): Unit = {
    /*
    *第1步：创建spark的配置对象SparkConf，设置spark程序运行的配置信息
    */
    val conf = new SparkConf()   //创建SparkConf对象
    conf.setAppName("Wow,My first Spark sql App !") // 设置应用对象的名称，在程序运行的监控界面可以
    //conf.setMaster("local")  //此设置为本地运行，不需要spark集群
    /*
    *第2步：创建SparkContext对象
    *SparkContext是Spark程序所有功能的唯一入口，无论是采用scala,Java,python,R
    * SparkContext核心作用：初始化Spark应用程序运行所需要的核心组件，
    * 同时还会负责Spark程序往Master注册程序等
    * SparkContext是整个Spark应用程序中最为至关重要的一个对象
     */
    val sc = new SparkContext(conf) //创建SparkContext对象，通过传入Sparkconf实例来定制Spark的具体运行情况
    /*
    *第3步：根据具体数据来源通过SparkContext来创建RDD
     */
    val hiveContext = new HiveContext(sc)
    hiveContext.sql("use default")
    hiveContext.sql("select count(*) from mds_log_pageview where dt = '2016-12-11' ").collect.foreach(println)
    sc.stop()
  }
}
