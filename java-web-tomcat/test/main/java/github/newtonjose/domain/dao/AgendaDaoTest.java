package main.java.github.newtonjose.domain.dao;

import main.java.github.newtonjose.domain.models.Agenda;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;


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

        dao.insert(a1);
        dao.insert(a2);
        dao.insert(a3);
    }
}