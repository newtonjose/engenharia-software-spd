package main.java.github.newtonjose.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDB {
    private static String user = "";
    private static String passwd = "";
    private static String urlDb = "";

    public static Connection newConn() throws SQLException {
        return DriverManager.getConnection(urlDb, user, passwd);
    }
}
