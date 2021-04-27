package main.java.github.newtonjose.application.servlets;

import main.java.github.newtonjose.domain.models.Candidato;
import main.java.github.newtonjose.domain.dao.CandidatoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "CadastrarCandidato", urlPatterns = {"/candidatos/cadastro"})
public class CadastrarCandidato extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("inputName");
        char gender = request.getParameter("genderOptions").charAt(0);
        LocalDate date = LocalDate.parse(
                request.getParameter("datePicker"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy")
        );
        String cargo = request.getParameter("inputCargo");
        String resume = request.getParameter("inputResumo");

        Candidato candidato = new Candidato(name, gender, date, cargo, resume);

        CandidatoDao cDao = new CandidatoDao();
        cDao.insert(candidato);

        response.sendRedirect("/index.html");
    }
}
