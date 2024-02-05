package com.wxf;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.parser.SQLStatementParser;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String sql = "select * from cmk.tablea";
        SQLStatementParser statementParser = new MySqlStatementParser(sql);
        SQLStatement sqlStatement = statementParser.parseStatement();
        System.out.println(SQLUtils.toMySqlString(sqlStatement));

        System.out.println(sqlStatement.getDbType());

        System.out.println(sqlStatement.getHeadHintsDirect());



    }
}
