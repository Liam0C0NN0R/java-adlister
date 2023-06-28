package adlister.controllers;

import adlister.dao.DaoFactory;
import adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = "/ads/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userSearch = request.getParameter("user-search");

        // Get all ads from the database using your AdsDao implementation
        List<Ad> ads = DaoFactory.getAdsDao().all();

        // Perform the search using the AdSearch class
        AdSearch adSearch = new AdSearch();
        List<Ad> matchingAds = adSearch.searchByDescription(ads, userSearch);

        // Set the search results as an attribute in the request
        request.setAttribute("matchingAds", matchingAds);

        // Forward the request to the JSP for displaying the search results
        request.getRequestDispatcher("/WEB-INF/ads/search.jsp").forward(request, response);
    }
}

