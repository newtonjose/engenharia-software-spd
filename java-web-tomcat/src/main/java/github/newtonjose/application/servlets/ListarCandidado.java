package main.java.github.newtonjose.application.servlets;

import main.java.github.newtonjose.domain.dao.CandidatoDao;
import main.java.github.newtonjose.domain.models.Candidato;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ListarCandidado", urlPatterns = {"/listar"})
public class ListarCandidado extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CandidatoDao cDao = new CandidatoDao();
        List<Candidato> candidatos = cDao.list();

        request.setAttribute("candidatos", candidatos);

        RequestDispatcher rd = request.getRequestDispatcher("listar.jsp");
        rd.forward(request, response);
    }
}
