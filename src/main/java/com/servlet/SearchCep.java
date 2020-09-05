package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.Models.CepModel;
import com.Services.CEPService;

public class SearchCep extends HttpServlet {
    CEPService cepService = new CEPService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cep = request.getParameter("cep");
        CepModel cepModel = cepService.getCEP(cep);

        request.setAttribute("cepModel", cepModel);
        RequestDispatcher rd = request.getRequestDispatcher("viacep.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
