package main.java.com.servlet;

import main.java.com.DAO.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class AddUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddUser() {
        System.out.println("AddUser Constructor called!");
    }

    public void init(ServletConfig config) throws ServletException {
        System.out.println("AddUser \"Init\" method called");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FirstServlet \"DoPost\" method called");
        doPostAndRespond(request, response);
    }

    private void doPostAndRespond(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("user_name");
        String email = request.getParameter("user_email");
        String password = request.getParameter("user_password");

        new UserDAO().SignUp(name, email, password);

        PrintWriter out = response.getWriter();
        out.write("<html><body><h2>Username and email id is stored in the session, go back and click on \"TestSession\" to test the session</h2></body></html>");

    }
}
