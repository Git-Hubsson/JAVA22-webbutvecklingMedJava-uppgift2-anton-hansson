package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.User;

import java.io.IOException;

@WebServlet(name = "LoginControllerServlet", value = "/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet {
//    User user = new User();
    private static final User[] userAccounts = {
            new User("user1", "pass1"),
            new User("user2", "pass2")
    };
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("loggedIn") != null) {
            RequestDispatcher rd = request.getRequestDispatcher("/view/home.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String un = request.getParameter("username");
        String pw = request.getParameter("password");

        User loginAttempt = null;
        for (User account: userAccounts) {
            if (account.getUsername().equals(un) && account.getPassword().equals(pw)){
                loginAttempt = account;
                break;
            }
        }

        if (loginAttempt != null){
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60*5);
            session.setAttribute("loggedIn", loginAttempt);
            RequestDispatcher rd = request.getRequestDispatcher("/view/home.jsp");
            rd.forward(request, response);
        }
        else {
            request.setAttribute("error", "The username or password is incorrect");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }
}