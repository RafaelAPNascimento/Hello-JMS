package org.example.view;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.CreditCard;
import org.example.producer.TopicProducerService;

import java.io.IOException;

@WebServlet(urlPatterns = "/hello")
public class ViewServelt extends HttpServlet {

    @EJB
    private TopicProducerService topicProducer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String cvv = req.getParameter("cvv");
        String number = req.getParameter("number");

        topicProducer.sendMessage(new CreditCard(cvv, number));

        resp.getWriter().println("<h1>Credit Card sent to the card operator topic...</h2>");
    }
}
