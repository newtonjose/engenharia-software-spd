package main.java.github.newtonjose.domain.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDB {
    public static Connection newConn() throws SQLException {
        final String user = "root";
        final String passwd = "abc1234";
        final String urlDb = "jdbc:mysql://localhost:3306/vacinacao";

        return DriverManager.getConnection(urlDb, user, passwd);
    }
}
