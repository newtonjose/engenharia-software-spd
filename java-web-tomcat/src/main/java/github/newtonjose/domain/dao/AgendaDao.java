package main.java.github.newtonjose.domain.dao;

import main.java.github.newtonjose.domain.db.ConnDB;
import main.java.github.newtonjose.domain.models.Agenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


class AgendaDao {

    private Connection conn;

    AgendaDao() {
        try {
            conn = ConnDB.newConn();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    void insert(Agenda agenda) {
        String sql = "INSERT INTO vacinacao.agenda(" +
                "periodo, nomepaciente, cpf, data, dose, local, situacao, databaixa" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statment = conn.prepareStatement(sql);

            statment.setString(1, String.valueOf(agenda.getPeriodo()));
            statment.setString(2, agenda.getNomepaciente());
            statment.setString(3, agenda.getCpf());
            statment.setDate(4, java.sql.Date.valueOf(agenda.getData()));
            statment.setInt(5, agenda.getDose());
            statment.setString(6, agenda.getLocal());
            statment.setInt(7, agenda.getSituacao());
            statment.setDate(8, agenda.getDatabaixa() != null ?
                    java.sql.Date.valueOf(agenda.getDatabaixa()) : null);

            statment.execute();
            statment.close();
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }
}
