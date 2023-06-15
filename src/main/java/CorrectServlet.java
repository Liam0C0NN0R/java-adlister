import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CorrectServlet", value = "/correct")
public class CorrectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the current session
        HttpSession session = request.getSession();

        // Set the "message" attribute on the session
        session.setAttribute("message", "You Won!");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/outcome.jsp");
        dispatcher.forward(request, response);
    }
}

