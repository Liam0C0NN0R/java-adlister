import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "CheckGuessServlet", value = "/checkGuess")
public class CheckGuessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the max number from the session
        HttpSession session = request.getSession();
        int maxNumber = (Integer) session.getAttribute("maxNumber");

        // Generate a random number between 1 and maxNumber
        int correctNumber = new Random().nextInt(maxNumber) + 1;

        // Get the guess from the request
        int guess = Integer.parseInt(request.getParameter("guess"));

        // Check the guess and redirect to the correct page
        String outcomePage = guess == correctNumber ? "/correct" : "/incorrect";
        response.sendRedirect(request.getContextPath() + outcomePage);
    }
}
