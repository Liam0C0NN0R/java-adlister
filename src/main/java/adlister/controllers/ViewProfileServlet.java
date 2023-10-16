package adlister.controllers;

import adlister.dao.DaoFactory;
import adlister.models.Ad;
import adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        User user = (User) request.getSession().getAttribute("user");

        // Retrieve the ads associated with the user from the DAO
        List<Ad> userAds = DaoFactory.getAdsDao().getAdsByUser(user.getId());

        // Set the list of user ads as an attribute in the request
        request.setAttribute("userAds", userAds);

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
