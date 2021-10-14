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
    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        String id;
        PrintWriter out;
        model.Ator ator = new model.Ator();

        switch (action) {
            case "save":
                ator.setName(request.getParameter("nome"));

                new Ator().save(ator);

                response.sendRedirect("Ator.jsp");
                break;
            case "delete":
                Boolean deleted;
                ator.setId(Integer.parseInt(request.getParameter("id")));

                response.setContentType("text/html");

                deleted = new Ator().delete(ator);

                out = response.getWriter();
                out.println(
                        "<html>" +
                                "<body>" +
                                "<a href=\"Ator.jsp\">Ator</a><br>" +
                                "id:" + request.getParameter("id") + ", deleted:" + deleted +
                                "</body>" +
                                "</html>");
                break;
            case "update":
                ator.setId(Integer.parseInt(request.getParameter("id")));
                ator.setName(request.getParameter("nome"));

                response.setContentType("text/html");

                ator = new Ator().update(ator);

                out = response.getWriter();
                out.println(
                        "<html>" +
                                "<body>" +
                                "<a href=\"Ator.jsp\">Ator</a><br>" +
                                "id:" + request.getParameter("id") + ", updated" +
                                "</body>" +
                                "</html>");
                break;
            default:
                response.setContentType("text/html");

                PrintWriter writer = response.getWriter();
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
