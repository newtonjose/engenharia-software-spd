package main.java.github.newtonjose.application.servlets;

import main.java.github.newtonjose.domain.dao.CandidatoDao;
import main.java.github.newtonjose.domain.models.Candidato;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeletarCandidato", urlPatterns = {"/deletar"})
public class DeletarCandidato extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CandidatoDao cDao = new CandidatoDao();

        Candidato candidato = new Candidato();
        candidato.setCodigo(Integer.parseInt(request.getParameter("code")));

        cDao.delete(candidato);

        response.sendRedirect("/listar");
    }
}
