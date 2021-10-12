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

        switch (action) {
            case "save":
                String name = request.getParameter("nome");

                new Ator().save(new model.Ator(name));

                response.sendRedirect("Ator.jsp");
                break;
            case "delete":
                String id = request.getParameter("id");
                Boolean deleted;

                response.setContentType("text/html");

                deleted = new Ator().delete(new model.Ator(Integer.valueOf(id)));

                PrintWriter out = response.getWriter();
                out.println(
                    "<html>" +
                        "<body>" +
                            "<a href=\"Ator.jsp\">Ator</a><br>" +
                            "id:" + id + ", deleted:" + deleted +
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
