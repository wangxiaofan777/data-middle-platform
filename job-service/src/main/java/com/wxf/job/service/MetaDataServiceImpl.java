package com.wxf.job.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.hive.metastore.IMetaStoreClient;
import org.apache.hadoop.hive.metastore.api.Database;
import org.apache.hadoop.hive.metastore.api.FieldSchema;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.metastore.api.NoSuchObjectException;
import org.apache.hadoop.hive.metastore.api.UnknownDBException;
import org.apache.hadoop.hive.metastore.api.UnknownTableException;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MetaData服务实现
 *
 * @author wxf
 * @version 1.1.0
 * @since 2023/6/15 13:45:51
 */
@Slf4j
@Service
public class MetaDataServiceImpl implements MetaDataService {

    private final IMetaStoreClient metaStoreClient;

    public MetaDataServiceImpl(IMetaStoreClient metaStoreClient) {
        this.metaStoreClient = metaStoreClient;
    }

    @Override
    public List<String> getDatabases(String databasePattern) throws MetaException, TException {
        return this.metaStoreClient.getDatabases(databasePattern);
    }

    @Override
    public List<String> getAllDatabases() throws TException {
        return this.metaStoreClient.getAllDatabases();
    }

    @Override
    public List<String> getAllTables(String dbName) throws MetaException, TException, UnknownDBException {
        return this.metaStoreClient.getAllTables(dbName);
    }

    @Override
    public boolean tableExists(String databaseName, String tableName) throws MetaException, TException, UnknownDBException {
        return this.metaStoreClient.tableExists(databaseName, tableName);
    }

    @Override
    public Database getDatabase(String databaseName) throws NoSuchObjectException, MetaException, TException {
        return this.metaStoreClient.getDatabase(databaseName);
    }

    @Override
    public List<FieldSchema> getFields(String db, String tableName) throws MetaException, TException, UnknownTableException, UnknownDBException {
        return this.metaStoreClient.getFields(db, tableName);
    }

    @Override
    public List<FieldSchema> getSchema(String db, String tableName) throws MetaException, TException, UnknownTableException, UnknownDBException {
        return this.metaStoreClient.getSchema(db, tableName);
    }
}
