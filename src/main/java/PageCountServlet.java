import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "PageViewCounterServlet", urlPatterns = "/count")
public class PageCountServlet extends HttpServlet {

    private int count = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String resetParam = request.getParameter("reset");
        if (resetParam != null) {
            count = 0;
        } else {
            count++;
        }

        out.println("<h1>Page views: " + count + "</h1>");
    }
}
