package main.java.github.newtonjose.domain.dao;

import main.java.github.newtonjose.domain.db.ConnDB;
import main.java.github.newtonjose.domain.models.Agenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


class AgendaDao {

    private Connection conn;

    AgendaDao() {
        try {
            conn = ConnDB.newConn();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    void inserir(Agenda agenda) {
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

    void atualizar(Agenda ag) {
        try {
            PreparedStatement statment = conn.prepareStatement(
                    "UPDATE vacinacao.agenda SET situacao = ? WHERE codigo = ?"
            );

            statment.setInt(1, ag.getSituacao());
            statment.setInt(2, ag.getCodigo());

            updateDatabaixa(ag);

            statment.execute();
            statment.close();
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }

    List<Agenda> listarTodas() {
        String sql = "SELECT * FROM vacinacao.agenda " +
                "ORDER BY situacao, data, nomepaciente";

        return listar(sql);
    }

    List<Agenda> listarAtivas() {
        String sql = "SELECT * FROM vacinacao.agenda WHERE situacao < 3 " +
                "ORDER BY situacao";
        return listar(sql);
    }

    List<Agenda>  listarCanceladas() {
        String sql = "SELECT * FROM vacinacao.agenda WHERE situacao = 3";
        return listar(sql);
    }

    private List<Agenda> listar(String sql) {
        List<Agenda> agendaList = new ArrayList<>();

        try {
            PreparedStatement statment = conn.prepareStatement(sql);
            ResultSet result = statment.executeQuery();

            while (result.next()) {
                Agenda agenda = new Agenda(
                        result.getString("periodo").charAt(0),
                        result.getString("nomepaciente"),
                        result.getString("cpf"),
                        result.getDate("data").toLocalDate(),
                        result.getInt("dose"),
                        result.getString("local"),
                        result.getInt("situacao"),
                        result.getDate("databaixa") != null ? result.getDate(
                                "databaixa").toLocalDate() : null
                );

                agenda.setCodigo(result.getInt("codigo"));

                agendaList.add(agenda);
            }

            statment.close();
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }

        return agendaList;
    }

    private void updateDatabaixa(Agenda ag) throws SQLException {
        PreparedStatement statment = conn.prepareStatement(
                "UPDATE vacinacao.agenda SET databaixa = ? WHERE codigo = ?"
        );

        statment.setDate(1, java.sql.Date.valueOf(ag.getDatabaixa()));
        statment.setInt(2, ag.getCodigo());

        statment.execute();
        statment.close();
    }

}
