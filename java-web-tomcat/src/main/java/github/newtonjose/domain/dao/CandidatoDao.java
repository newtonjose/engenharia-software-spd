package main.java.github.newtonjose.domain.dao;

import main.java.github.newtonjose.domain.db.ConnDB;
import main.java.github.newtonjose.domain.models.Candidato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class CandidatoDao {

    private Connection conn;

    public CandidatoDao() {
        try {
            conn = ConnDB.newConn();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
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
            statment.close();
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }

    public List<Candidato> list() {
        List<Candidato> candidatoList = new ArrayList<>();
        String sql = "SELECT * FROM candidato";

        try {
            PreparedStatement statment = conn.prepareStatement(sql);
            ResultSet result = statment.executeQuery();

            while (result.next()) {
                Candidato candidato = new Candidato(
                        result.getString("nome"),
                        result.getString("sexo").charAt(0),
                        result.getDate("data_nasc").toInstant()
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate(),
                        result.getString("cargo_pretendido"),
                        result.getString("texto_curriculo")
                );

                candidato.setCodigo(result.getInt("codigo"));

                candidatoList.add(candidato);
            }

            statment.close();
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }

        return candidatoList;
    }

    public void delete(Candidato candidato) {
        String sql = "DELETE FROM candidato WHERE codigo = ?";

        try {
            PreparedStatement statment = conn.prepareStatement(sql);
            statment.setInt(1, candidato.getCodigo());

            statment.execute();
            statment.close();
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }
}
