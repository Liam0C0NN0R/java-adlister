import adlister.dao.DaoFactory;
import adlister.models.Ad;
import adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.EditAdServlet", urlPatterns = "/ads/edit")
public class EditAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get the current user
        User currentUser = (User) request.getSession().getAttribute("user");

        // get the ad to edit
        String adIdString = request.getParameter("adId");
        Long adId = Long.parseLong(adIdString);  // convert string to Long
        Ad ad = DaoFactory.getAdsDao().findById(adId);

        // check if the ad belongs to the current user
        if (ad.getUserId() != currentUser.getId()) {
            // the ad doesn't belong to the current user
            // you could return an error here
        } else {
            // the ad belongs to the current user, so display it in an editable form
            request.setAttribute("ad", ad);
            request.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get the current user
        User currentUser = (User) request.getSession().getAttribute("user");

        // get the ad to edit
        String adIdString = request.getParameter("adId");
        Long adId = Long.parseLong(adIdString);  // convert string to Long
        Ad ad = DaoFactory.getAdsDao().findById(adId);

        // check if the ad belongs to the current user
        if (ad.getUserId() != currentUser.getId()) {
            // the ad doesn't belong to the current user
            // you could return an error here
        } else {
            // the ad belongs to the current user, so update it with the new details
            String newTitle = request.getParameter("title");
            String newDescription = request.getParameter("description");
            ad.setTitle(newTitle);
            ad.setDescription(newDescription);
            DaoFactory.getAdsDao().update(ad);

            // then redirect the user back to the list of their ads
            response.sendRedirect("/ads");
        }
    }

}
