package main.java.github.newtonjose.domain;

import main.java.github.newtonjose.domain.db.ConnDB;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class ConnDBTest {

    @Test
    void newConn() throws SQLException {
        try {
            ConnDB.newConn();
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            throw sqle;
        }
    }
}