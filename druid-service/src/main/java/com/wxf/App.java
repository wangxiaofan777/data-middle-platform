package com.wxf;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLName;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLColumnDefinition;
import com.alibaba.druid.sql.ast.statement.SQLTableElement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlTableIndex;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlASTVisitor;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlShowColumnOutpuVisitor;
import com.alibaba.druid.sql.parser.SQLStatementParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        String sql = new String(Files.readAllBytes(Paths.get("druid-service/data/example.sql")));
        SQLStatement sqlStatement = SQLUtils.parseSingleMysqlStatement(sql);


        System.out.println(sqlStatement.getDbType());

        List<SQLTableElement> sqlTableElementList = ((MySqlCreateTableStatement) sqlStatement).getTableElementList();

        sqlTableElementList.forEach(x-> {
            SQLName sqlName = ((SQLColumnDefinition) x).getName();
            System.out.println(sqlName.getSimpleName());
        });


//        String sql = "select * from cmk.tablea";
//        SQLStatementParser statementParser = new MySqlStatementParser(sql);
//        SQLStatement sqlStatement = statementParser.parseStatement();
//        System.out.println(SQLUtils.toMySqlString(sqlStatement));
//
//        System.out.println(sqlStatement.getDbType());
//
//        System.out.println(sqlStatement.getHeadHintsDirect());


    }
}
