import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GuessServlet", value = "/guess")
public class GuessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the difficulty from the request
        String difficulty = request.getParameter("difficulty");
        int maxNumber;
        switch (difficulty) {
            case "easy":
                maxNumber = 2;
                break;
            case "normal":
                maxNumber = 3;
                break;
            case "hard":
                maxNumber = 10;
                break;
            case "impossible":
                maxNumber = 100;
                break;
            default:
                maxNumber = 3;  // default to normal difficulty
        }
        // Store the max number in the session so it can be accessed in other requests
        HttpSession session = request.getSession();
        session.setAttribute("maxNumber", maxNumber);

        // Forward the request to the JSP page where the user can enter their guess
        RequestDispatcher dispatcher = request.getRequestDispatcher("/enterGuess.jsp");
        dispatcher.forward(request, response);
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/guess.jsp");
        dispatcher.forward(request, response);
    }
}
