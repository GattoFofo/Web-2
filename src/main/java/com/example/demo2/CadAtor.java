package com.example.demo2;

import dao.Ator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CadAtor", value = "/cadAtor")
public class CadAtor extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        new Ator().save(new model.Ator(request.getParameter("nome")));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("new Ator().save(new model.Ator(request.getParameter(" + request.getParameter("nome") + ")));");
        out.println("</body></html>");
        //response.sendRedirect("listAtor");
    }
}
