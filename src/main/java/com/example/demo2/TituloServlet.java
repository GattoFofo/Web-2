package com.example.demo2;

import dao.TituloDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Ator;
import model.Classe;
import model.Diretor;
import model.Titulo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "TituloServlet", value = "/TituloServlet")
public class TituloServlet extends HttpServlet {
    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        PrintWriter writer = response.getWriter();
        Titulo titulo = new Titulo();
        List<String> strings;
        List<Ator> ators = new ArrayList<>();

        response.setContentType("text/html");

        switch (action) {
            case "save":
                titulo.setNome(request.getParameter("nome"));
                strings = Arrays.asList(request.getParameterValues("ators"));
                for (String s : strings) ators.add(new Ator(Integer.parseInt(s)));
                titulo.setAtors(ators);
                titulo.setDiretor(new Diretor(Integer.parseInt(request.getParameter("diretor"))));
                titulo.setAno(Integer.parseInt(request.getParameter("ano")));
                titulo.setSinopse(request.getParameter("sinopse"));
                titulo.setCategoria(request.getParameter("categoria"));
                titulo.setClasse(new Classe(Integer.parseInt(request.getParameter("classe"))));

                new TituloDAO().save(titulo);

                response.sendRedirect("Titulo.jsp");
                /*
                writer.println(
                        "<html><body>" +
                                "nome: " + request.getParameter("nome") + "<br>");
                List<String> list = Arrays.asList(request.getParameterValues("ators"));
                for (String s : list) writer.println("ators: " + s + "<br>");
                writer.println("diretor: " + request.getParameter("diretor") + "<br>" +
                        "ano: " + request.getParameter("ano") + "<br>" +
                        "sinopse: " + request.getParameter("sinopse") + "<br>" +
                        "categoria: " + request.getParameter("categoria") + "<br>" +
                        "classe: " + request.getParameter("classe") + "<br>" +
                        "</html></body>"
                );
                */
                break;
            case "delete":
                boolean deleted;
                titulo.setId(Long.valueOf(request.getParameter("id")));

                response.setContentType("text/html");

                deleted = new TituloDAO().delete(titulo);

                response.sendRedirect("Titulo.jsp");
                /*
                writer = response.getWriter();
                writer.println(
                        "<html>" +
                                "<body>" +
                                "<a href=\"Titulo.jsp\">Titulo</a><br>" +
                                "id:" + request.getParameter("id") + ", deleted:" + deleted +
                                "</body>" +
                                "</html>");
                */
                break;
            case "update":
                titulo.setId(Long.valueOf(request.getParameter("id")));
                titulo.setNome(request.getParameter("nome"));
                strings = Arrays.asList(request.getParameterValues("ators"));
                for (String s : strings) ators.add(new Ator(Integer.parseInt(s)));
                titulo.setAtors(ators);
                titulo.setDiretor(new Diretor(Integer.parseInt(request.getParameter("diretor"))));
                titulo.setAno(Integer.parseInt(request.getParameter("ano")));
                titulo.setSinopse(request.getParameter("sinopse"));
                titulo.setCategoria(request.getParameter("categoria"));
                titulo.setClasse(new Classe(Integer.parseInt(request.getParameter("classe"))));

                titulo = new TituloDAO().update(titulo);

                response.sendRedirect("Titulo.jsp");
                /*
                writer.println(
                        "<html>" +
                                "<body>" +
                                "<a href=\"Titulo.jsp\">Titulo</a><br>" +
                                "id:" + request.getParameter("id") + ", updated" +
                                "</body>" +
                                "</html>");
                 */
                break;
            default:
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
