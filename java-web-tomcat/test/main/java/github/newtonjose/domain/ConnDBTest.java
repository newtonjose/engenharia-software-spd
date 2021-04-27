package main.java.github.newtonjose.domain;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

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