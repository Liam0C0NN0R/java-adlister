import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            // User is already logged in, redirect to profile page
            response.sendRedirect("/profile");
        } else {
            // User is not logged in, forward to login page
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = username.equals("admin") && password.equals("password");

        if (username.equals("admin") && password.equals("password")) {
            // User is valid, set a session attribute "user"
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            response.sendRedirect("/profile");
        } else {
            // Redirect back to login page if credentials are incorrect
            response.sendRedirect("/login.jsp");
        }
    }
}
