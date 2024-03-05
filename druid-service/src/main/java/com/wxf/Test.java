package com.wxf;

import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.create.table.Index;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Wxf
 * @since 2024-03-05 09:34:18
 **/
public class Test {

    public static void main(String[] args) throws Exception {
        String sql = new String(Files.readAllBytes(Paths.get("druid-service/data/example.sql")));

        CreateTable createTable = (CreateTable) CCJSqlParserUtil.parse(sql);

        List<String> tableColumns = createTable.getColumns();
        List<Index> indexList = createTable.getIndexes();
        Table table = createTable.getTable();

        System.out.println(tableColumns);

    }
}
