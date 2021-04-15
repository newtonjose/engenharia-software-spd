package main.java.github.newtonjose.domain.dao;

import main.java.github.newtonjose.domain.ConnDB;
import main.java.github.newtonjose.domain.models.Candidato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CandidatoDao {

    private Connection conn;

    public CandidatoDao() throws SQLException {
        conn = ConnDB.newConn();
    }

    public void insert(Candidato candidato) {
        String sql = "INSERT INTO candidato(" +
                "nome, sexo, data_nasc, cargo_pretendido, texto_curriculo" +
                ") VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statment = conn.prepareStatement(sql);
            statment.setString(1, candidato.getName());
            statment.setString(2, String.valueOf(candidato.getGender()));
            statment.setDate(4, java.sql.Date.valueOf(candidato.getBornDate()));
            statment.setString(5, candidato.getJobPosition());
            statment.setString(6, candidato.getCurriculumResume());

            statment.execute();
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }
}
