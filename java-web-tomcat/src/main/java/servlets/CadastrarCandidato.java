package main.java.servlets;

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
        String gender = request.getParameter("radioOptions");
        LocalDate date = LocalDate.parse(
                request.getParameter("datePicker"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy")
        );
        String cargo = request.getParameter("inputCargo");
        String resume = request.getParameter("inputResumo");

        System.out.println(date);
//        response.sendRedirect("/index.html");
    }
}
