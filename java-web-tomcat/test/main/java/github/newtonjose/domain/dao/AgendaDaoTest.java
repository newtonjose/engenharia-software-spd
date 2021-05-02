package main.java.github.newtonjose.domain.dao;

import main.java.github.newtonjose.domain.models.Agenda;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


class AgendaDaoTest {
    private static AgendaDao dao;

    @BeforeAll
    static void setup() {
        dao = new AgendaDao();
    }

    @Test
    void insert() {
        Agenda a1 = new Agenda(
                'M', "Anita A. Lemaster", "00201366509",
                LocalDate.of(2020, Month.APRIL, 27),
                1, "Posto de Saude 1",
                1, null
        );

        Agenda a2 = new Agenda(
                'V', "John J. Parker", "00201366509",
                LocalDate.of(2020, Month.APRIL, 27),
                1, "Posto de Saude 1",
                2, LocalDate.of(2020, Month.APRIL, 25)
        );

        Agenda a3 = new Agenda(
                'N', "Jerry M. Hatley", "00090322150",
                LocalDate.of(2020, Month.APRIL, 28),
                1, "Posto de Saude Rua da Cana",
                1, null
        );

        dao.inserir(a1);
        dao.inserir(a2);
        dao.inserir(a3);
    }

    @Test
    void atualizar() {
        Agenda a3 = new Agenda(
                'N', "Jerry M. Hatley", "00090322150",
                LocalDate.of(2020, Month.APRIL, 28),
                1, "Posto de Saude Rua da Cana",
                3, LocalDate.of(2020, Month.APRIL, 27)
        );

        a3.setCodigo(1);
        dao.atualizar(a3);
    }

    @Test
    void listarTodas() {
        List<Agenda> list = dao.listarTodas();

        list.forEach(agenda -> System.out.println("Nome: " + agenda.getNomepaciente() + " Situa" +
                "ção " + agenda.getSituacao()));
    }

    @Test
    void listarCanceladas() {
        List<Agenda> list = dao.listarCanceladas();

        list.forEach(agenda -> System.out.println("Nome: " + agenda.getNomepaciente() + " Situa" +
                "ção " + agenda.getSituacao()));
    }

    @Test
    void listarAtivas() {
        List<Agenda> list = dao.listarAtivas();

        list.forEach(agenda -> System.out.println("Nome: " + agenda.getNomepaciente() + " Situa" +
                "ção " + agenda.getSituacao()));
    }
}
