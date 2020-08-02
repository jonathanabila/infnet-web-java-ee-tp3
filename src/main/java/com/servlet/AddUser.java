package main.java.com.servlet;

import main.java.com.DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPostAndRespond(request, response);
    }

    private void doPostAndRespond(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("user_name");
        String email = request.getParameter("user_email");
        String password = request.getParameter("user_password");

        new UserDAO().SignUp(name, email, password);

        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.getRequestDispatcher("/success.jsp").forward(request, response);
    }
}
