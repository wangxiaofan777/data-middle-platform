package com.wxf.job.flink;

import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.TableEnvironment;
import org.apache.flink.table.catalog.hive.HiveCatalog;

/**
 * Flink读取HIve
 */
public class FlinkReadHive {

    private static final String table = "table_a";
    private static final String database = "wxf";
    private static final String hiveConf = "D:/workspace/data-middle-platform/config";

    public static void main(String[] args) {
//        KerberosAuthUtils.login("devops@HADOOP.COM", "D:/workspace/data-middle-platform/config/devops.keytab", "D:/workspace/data-middle-platform/config/krb5.conf");

        EnvironmentSettings settings = EnvironmentSettings.inStreamingMode();
        TableEnvironment env = TableEnvironment.create(settings);
        HiveCatalog hiveCatalog = new HiveCatalog(table, database, hiveConf);
        env.registerCatalog(table, hiveCatalog);

        env.useCatalog(table);
        env.useDatabase(database);

        env.executeSql("show databases").print();

    }
}
