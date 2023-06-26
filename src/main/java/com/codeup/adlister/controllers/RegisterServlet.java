package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            // show the registration form
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // get user inputs from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // ensure the submitted information is valid
        User user = DaoFactory.getUsersDao().findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            // username is not found in the database or password does not match
            response.sendRedirect("/login");
            return;
        }

        // if a user was successfully logged in, store the user object in the session
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        // redirect the user to their profile page or some other page
        response.sendRedirect("/profile");
    }

}
