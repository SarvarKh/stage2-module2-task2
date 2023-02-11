package com.example.servlet;

import com.example.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get the HTTPSession object
        HttpSession session = req.getSession();

        // Call user instances (admin & user) from Users class
        Users users = Users.getInstance();
        List<String> allUsers = users.getUsers();

        // Check the request parameters
        try {
            if (allUsers.contains(req.getParameter("login")) && !req.getParameter("password").isEmpty()) {
                session.setAttribute("user", req.getParameter("login"));
                resp.sendRedirect("/user/hello.jsp");
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
