package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.Services.LoginService;
import com.Utils.Utils;

public class SignUp extends HttpServlet {
    LoginService loginService = new LoginService();
    Utils utils = new Utils();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("user_email");
        String name = request.getParameter("user_name");
        String password = request.getParameter("user_password");

        try {
            if(loginService.userExists(email)) {
                utils.PushNotification("Esse email já existe!", "signup", response);
                return;
            }
            if(loginService.createUser(email, name, password)) {
                utils.PushNotification("Usuário criado com sucesso!", "signup", response);
                response.sendRedirect("main.jsp");
                return;
            }
            utils.PushNotification("Falha ao criar o usuário :'(", "signup", response);
            response.sendRedirect("signup.jsp");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
