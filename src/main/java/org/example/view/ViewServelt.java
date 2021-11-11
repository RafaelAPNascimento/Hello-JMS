package org.example.view;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.producer.TimedProducer;

import java.io.IOException;

@WebServlet(urlPatterns = "/hello")
public class ViewServelt extends HttpServlet {

    @EJB
    private TimedProducer timedProducer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println(String.format("<h1>View Servlet: %s</h1>", timedProducer.toString()));
    }
}
