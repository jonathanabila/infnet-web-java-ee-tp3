package com.Services;

import com.Middlewares.Http;
import com.Models.PokemonModel;
import com.google.gson.Gson;

import java.io.IOException;

public class PokemonService {
    final String API_URL = "https://pokeapi.co/api/v2/pokemon/";

    public PokemonModel getPokemon(String pokemon) throws IOException {
        String url = API_URL + pokemon;
        String rawCoin = Http.GET(url);

        return new Gson().fromJson(rawCoin, PokemonModel.class);
    }

}
