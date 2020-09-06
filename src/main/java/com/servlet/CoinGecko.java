package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.Models.CoinModel;
import com.Services.CoinsService;

public class CoinGecko extends HttpServlet {
    CoinsService coinsService = new CoinsService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            CoinModel coin = coinsService.getCoin(id);
            request.setAttribute("coin", coin);

            RequestDispatcher rd = request.getRequestDispatcher("coingecko.jsp");
            rd.forward(request, response);
        }
    }
}
