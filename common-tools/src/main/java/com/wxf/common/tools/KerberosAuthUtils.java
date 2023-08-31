package com.wxf.common.tools;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.security.UserGroupInformation;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Kerberos认证工具类
 *
 * @author WangXiaofan777
 * @version 1.1.0
 * @since 2023/7/18 16:08:13
 */
@Slf4j
public class KerberosAuthUtils {

    private static final String HADOOP_SECURITY_AUTHENTICATION = "hadoop.security.authentication";
    private static final String JAVA_SECURITY_KRB5_CONF = "java.security.krb5.conf";

    /**
     * 刷新间隔
     */
    private static final Duration interval = Duration.ofMinutes(30);

    /**
     * 登录
     *
     * @param configuration 配置
     */
    public static synchronized void login(Configuration configuration, String principal, String keytab, String krb5Conf) {
        login0(configuration, principal, keytab, krb5Conf);
    }

    /**
     * 登录
     */
    public static synchronized void login(String principal, String keytab, String krb5Conf) {
        Configuration configuration = new Configuration();
        login0(configuration, principal, keytab, krb5Conf);
    }

    public static void login0(Configuration configuration, String principal, String keytab, String krb5Conf) {
        log.info("kerberos login config principal: {}, keytab: {}, krb5Conf: {}", principal, keytab, krb5Conf);

        System.setProperty("sun.security.krb5.debug", "true");
        System.setProperty("HADOOP_JAAS_DEBUG", "true");
//            System.setProperty("java.security.auth.login.config", "kerberos_login_config.ini");
        System.setProperty("javax.security.auth.useSubjectCredsOnly", "false");
        System.setProperty(JAVA_SECURITY_KRB5_CONF, krb5Conf);

        configuration.set(HADOOP_SECURITY_AUTHENTICATION, "kerberos");
        UserGroupInformation.setConfiguration(configuration);
        try {
            log.info("========================================== kerberos logining... ========================================== ");
            // 登录
            UserGroupInformation.loginUserFromKeytab(principal, keytab);

            // 刷新Kerberos认证
            refresh();
            log.info("========================================== kerberos login successful... ========================================== ");
        } catch (IOException e) {
            log.error("========================================== kerberos authentication failed... ========================================== ", e);
        }
    }

    /**
     * 重新登录
     */
    public static void refresh() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);

        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            try {
                log.info("============================== kerberos refresh start =======================================");
                Thread.currentThread().setDaemon(true);
                UserGroupInformation.getCurrentUser().reloginFromKeytab();
                log.info("============================== kerberos refresh end =======================================");
            } catch (IOException e) {
                log.error("kerberos refresh error", e);
            }
        }, 1, interval.getSeconds(), TimeUnit.SECONDS);
    }


    public static void main(String[] args) {
        KerberosAuthUtils.login("devops@HADOOP.COM", "D:/workspace/data-middle-platform/config/devops.keytab", "D:/workspace/data-middle-platform/config/krb5.conf");
    }
}
