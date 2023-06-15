import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "IncorrectServlet", value = "/incorrect")
public class IncorrectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the current session
        HttpSession session = request.getSession();

        // Set the "message" attribute on the session
        session.setAttribute("message", "You Lost!");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/outcome.jsp");
        dispatcher.forward(request, response);
    }
}
