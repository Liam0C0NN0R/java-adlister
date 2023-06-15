import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PizzaOrderServlet", value = "/pizza-order")
public class PizzaOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/PizzaOrderForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String crustType = request.getParameter("crustType");
        String sauceType = request.getParameter("sauceType");
        String size = request.getParameter("size");
        String[] toppings = request.getParameterValues("toppings");
        String address = request.getParameter("address");

        System.out.println("Crust Type: " + crustType);
        System.out.println("Sauce Type: " + sauceType);
        System.out.println("Size: " + size);
        System.out.println("Toppings: " + (toppings != null ? String.join(", ", toppings) : "None"));
        System.out.println("Delivery Address: " + address);

        // Forward the request back to the form
        RequestDispatcher dispatcher = request.getRequestDispatcher("/PizzaOrderForm.jsp");
        dispatcher.forward(request, response);
    }
}
