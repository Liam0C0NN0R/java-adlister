import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            // User is not logged in, redirect to login page
            response.sendRedirect("/login.jsp");
        } else {
            // User is logged in, forward to profile page
            String username = (String) session.getAttribute("user");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        }
    }
}