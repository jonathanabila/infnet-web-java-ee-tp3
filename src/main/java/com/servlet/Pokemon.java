package com.servlet;

import com.Models.PokemonModel;
import com.Services.PokemonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Pokemon extends HttpServlet {
    PokemonService pokemonService = new PokemonService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pokemon = request.getParameter("pokemon");

        PokemonModel pokemonModel = pokemonService.getPokemon(pokemon);
        request.setAttribute("pokemon", pokemonModel);
        RequestDispatcher rd = request.getRequestDispatcher("pokemon.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
