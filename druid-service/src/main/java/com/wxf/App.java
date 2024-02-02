package com.wxf;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String sql = "select * from cmk.tablea";
        MySqlStatementParser mySqlStatementParser = new MySqlStatementParser(sql);
        SQLStatement sqlStatement = mySqlStatementParser.parseSpStatement();
        System.out.println(SQLUtils.toMySqlString(sqlStatement));


    }
}
