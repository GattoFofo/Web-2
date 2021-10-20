package com.example.demo2;

import dao.DiretorDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Diretor;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiretorServlet", value = "/DiretorServlet")
public class DiretorServlet extends HttpServlet {
    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        PrintWriter writer;
        Diretor diretor = new Diretor();

        switch (action) {
            case "save":
                diretor.setNome(request.getParameter("nome"));

                new DiretorDAO().save(diretor);

                response.sendRedirect("Diretor.jsp");
                break;
            case "delete":
                boolean deleted;
                diretor.setId(Integer.parseInt(request.getParameter("id")));

                response.setContentType("text/html");

                deleted = new DiretorDAO().delete(diretor);

                writer = response.getWriter();
                writer.println(
                        "<html>" +
                                "<body>" +
                                "<a href=\"Diretor.jsp\">Diretor</a><br>" +
                                "id:" + request.getParameter("id") + ", deleted:" + deleted +
                                "</body>" +
                                "</html>");
                break;
            case "update":
                diretor.setId(Integer.parseInt(request.getParameter("id")));
                diretor.setNome(request.getParameter("nome"));

                response.setContentType("text/html");

                diretor = new DiretorDAO().update(diretor);

                writer = response.getWriter();
                writer.println(
                        "<html>" +
                                "<body>" +
                                "<a href=\"Diretor.jsp\">Diretor</a><br>" +
                                "id:" + request.getParameter("id") + ", updated" +
                                "</body>" +
                                "</html>");
                break;
            default:
                response.setContentType("text/html");

                writer = response.getWriter();
                writer.println(
                        "<html>" +
                                "<body>" +
                                "No action: " + action + " supported" +
                                "</body>" +
                                "</html>"
                );
                break;
        }
    }

    public void destroy() {
    }
}
