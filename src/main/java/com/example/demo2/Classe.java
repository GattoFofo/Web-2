package com.example.demo2;

import dao.ClasseDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "Classe", value = "/Classe")
public class Classe extends HttpServlet {
    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        PrintWriter out = response.getWriter();
        model.Classe classe = new model.Classe();

        switch (action) {
            case "save":
                classe.setNome(request.getParameter("nome"));
                classe.setValor(Double.valueOf(request.getParameter("valor")));
                try {
                    classe.setDevolucao(format.parse(request.getParameter("devolucao")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                new ClasseDAO().save(classe);

                response.sendRedirect("Classe.jsp");
                break;
            case "delete":
                Boolean deleted;
                classe.setId(Integer.parseInt(request.getParameter("id")));

                response.setContentType("text/html");

                deleted = new ClasseDAO().delete(classe);

                out.println(
                        "<html>" +
                                "<body>" +
                                "<a href=\"Classe.jsp\">Classe</a><br>" +
                                "id:" + request.getParameter("id") + ", deleted:" + deleted +
                                "</body>" +
                                "</html>");
                break;
            case "update":
                classe.setId(Integer.parseInt(request.getParameter("id")));
                classe.setNome(request.getParameter("nome"));
                classe.setValor(Double.valueOf(request.getParameter("valor")));
                try {
                    classe.setDevolucao(format.parse(request.getParameter("devolucao")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                response.setContentType("text/html");

                classe = new ClasseDAO().update(classe);

                out.println(
                        "<html>" +
                                "<body>" +
                                "<a href=\"Classe.jsp\">Classe</a><br>" +
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
