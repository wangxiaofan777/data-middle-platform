package com.wxf.filesystemservice;

import com.wxf.common.tools.KerberosAuthUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.yarn.api.records.ApplicationReport;
import org.apache.hadoop.yarn.api.records.QueueInfo;
import org.apache.hadoop.yarn.client.api.YarnClient;
import org.apache.hadoop.yarn.conf.YarnConfiguration;
import org.apache.hadoop.yarn.exceptions.YarnException;
import org.apache.hadoop.yarn.util.ConverterUtils;

import java.io.IOException;
import java.util.List;

/**
 * Yarn Client
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/6/6 10:01:25
 */
public class YarnClientUtils {

    private static YarnClient yarnClient;

    static {
        init();
    }

    public static void init() {
        Configuration configuration = new YarnConfiguration();
        yarnClient = YarnClient.createYarnClient();
        yarnClient.init(configuration);
        yarnClient.start();
    }

    public static ApplicationReport getApplicationReportById(String applicationId) throws IOException, YarnException {
        return yarnClient.getApplicationReport(ConverterUtils.toApplicationId(applicationId));
    }


    public static List<ApplicationReport> getApplications() throws IOException, YarnException {
        return yarnClient.getApplications();
    }


    public static void kill(String applicationId) throws IOException, YarnException {
        yarnClient.killApplication(ConverterUtils.toApplicationId(applicationId));
    }

    public static List<QueueInfo> getAllQueues() throws YarnException, IOException {
        return yarnClient.getAllQueues();
    }

    public static List<QueueInfo> getRootQueueInfos() throws YarnException, IOException {
        return yarnClient.getRootQueueInfos();

    }

    public static List<QueueInfo> getChildQueueInfos(String queue) throws YarnException, IOException {
        return yarnClient.getChildQueueInfos(queue);
    }

    public static void main(String[] args) throws IOException, YarnException {
        System.out.println(YarnClientUtils.class.getClassLoader().getResource(""));

        KerberosAuthUtils.login("C:/Users/wxf/Desktop/kerberos/139/krb5.conf", "devops@HADOOP.COM", "C:/Users/wxf/Desktop/kerberos/139/devops.keytab");
        YarnClientUtils.init();
        List<ApplicationReport> applications = YarnClientUtils.getApplications();
    }
}
