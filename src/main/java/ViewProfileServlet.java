import javax.servlet.RequestDispatcher;
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
        // Check if user is logged in
        if (request.getSession().getAttribute("user") != null) {
            // Forward request to profile.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/profile.jsp");
            dispatcher.forward(request, response);
        } else {
            // Redirect to login page if user is not logged in
            response.sendRedirect("/login");
        }
    }
}