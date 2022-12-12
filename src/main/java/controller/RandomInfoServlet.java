package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.User;
import java.io.IOException;
@WebServlet(name = "RandomInfoServlet", value = "/RandomInfoServlet")
public class RandomInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("loggedIn") != null) {
            doPost(request, response);
        }else {
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String randomInfo = request.getParameter("randomInfo");

    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("loggedIn");
    user.setRandomInfo(randomInfo);
    RequestDispatcher rd = request.getRequestDispatcher("/view/home.jsp");
    rd.forward(request, response);
    }
}
