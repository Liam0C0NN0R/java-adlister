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

@WebServlet(name = "AdServlet", urlPatterns = "/ads/show")
public class AdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the ad ID from the request parameter
        long adId = Long.parseLong(request.getParameter("id"));

        // Retrieve the ad's information from the database
        Ad ad = DaoFactory.getAdsDao().findById(adId);

        if (ad != null) {
            // Retrieve the user's information who posted the ad
            User user = DaoFactory.getUsersDao().findById(ad.getUserId());

            // Set the ad and user objects as attributes in the request
            request.setAttribute("ad", ad);
            request.setAttribute("user", user);

            // Forward the request to a JSP page that displays the ad and user information
            request.getRequestDispatcher("/WEB-INF/ads/show.jsp").forward(request, response);
        } else {
            // Handle the case when the ad is not found
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
