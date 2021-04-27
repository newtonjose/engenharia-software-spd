package main.java.github.newtonjose.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDB {
    private static String user = System.getenv("DB_USER");
    private static String passwd = System.getenv("DB_PASSWD");
    private static String urlDb = System.getenv("DB_URL");;

    public static Connection newConn() throws SQLException {
        if (user == null || passwd == null || urlDb == null) {
            throw new SQLException("Data base varible not found: DB_USER, " +
                    "DB_PASSWD or DB_URL");
        };

        return DriverManager.getConnection(urlDb, user, passwd);
    }
}
