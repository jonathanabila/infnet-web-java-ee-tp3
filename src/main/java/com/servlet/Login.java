package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.Models.UserModel;
import com.Services.LoginService;

public class Login extends HttpServlet {
    LoginService loginService = new LoginService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("button-signup") != null) {
            response.sendRedirect("signup.jsp");
            return;
        }

        String email = request.getParameter("user_email");
        String password = request.getParameter("user_password");

        try {
            if (loginService.userExists(email)) {
                if(loginService.isEmailAndPasswordCorrect(email, password)) {
                    UserModel userModel  = loginService.getUser(email);

                    request.setAttribute("userModel", userModel);
                    RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
                    rd.forward(request, response);
                } else {
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Senha incorreta!');");
                    out.println("location='login.jsp';");
                    out.println("</script>");
                }
            } else {
                response.sendRedirect("signup.jsp");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
