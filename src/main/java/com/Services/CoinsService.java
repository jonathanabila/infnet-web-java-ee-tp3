package com.Services;

import com.Models.CoinModel;
import com.Models.CoinsModel;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.Middlewares.Http;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class CoinsService {
    final String API_URL = "https://api.coingecko.com/api/v3/";

    public ArrayList<CoinsModel> getCoins() throws IOException {
        String url = API_URL + "/coins/list";
        String rawCoins = Http.GET(url);

        Type listType = new TypeToken<ArrayList<CoinsModel>>() {}.getType();
        ArrayList<CoinsModel> allCoins = new Gson().fromJson(rawCoins, listType);

        ArrayList<CoinsModel> coins = new ArrayList<>();

        for(CoinsModel coin: allCoins) {
            if (coin.name.toLowerCase().contains("bitcoin")) {
                coins.add(coin);
            }
        }
        return coins;
    }

    public CoinModel getCoin(String id) throws IOException {
        String url = API_URL + "/coins/" + id;
        String rawCoin = Http.GET(url);

        return new Gson().fromJson(rawCoin, CoinModel.class);
    }
}
