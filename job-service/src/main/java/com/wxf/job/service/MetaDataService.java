package com.wxf.job.service;

import org.apache.hadoop.hive.metastore.api.Database;
import org.apache.hadoop.hive.metastore.api.FieldSchema;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.metastore.api.NoSuchObjectException;
import org.apache.hadoop.hive.metastore.api.UnknownDBException;
import org.apache.hadoop.hive.metastore.api.UnknownTableException;
import org.apache.thrift.TException;

import java.util.List;

/**
 * 元数据服务
 *
 * @author WangMaoSong
 * @version 1.1.0
 * @since 2023/6/15 13:45:27
 */
public interface MetaDataService {

    List<String> getDatabases(String databasePattern) throws MetaException, TException;

    List<String> getAllDatabases() throws MetaException, TException;

    List<String> getAllTables(String dbName) throws MetaException, TException, UnknownDBException;


    boolean tableExists(String databaseName, String tableName) throws MetaException, TException, UnknownDBException;

    Database getDatabase(String databaseName) throws NoSuchObjectException, MetaException, TException;

    List<FieldSchema> getFields(String db, String tableName) throws MetaException, TException, UnknownTableException, UnknownDBException;


    List<FieldSchema> getSchema(String db, String tableName) throws MetaException, TException, UnknownTableException, UnknownDBException;
}
