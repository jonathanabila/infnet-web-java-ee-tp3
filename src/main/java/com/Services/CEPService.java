package com.Services;
import com.Middlewares.Http;
import com.google.gson.Gson;

import com.Models.CepModel;
import java.io.IOException;


public class CEPService {
    final String API_URL = "https://viacep.com.br/ws/";
    Gson g = new Gson();

    private String buildUrl(String cep) {
        return API_URL + cep + "/json/";
    }

    private CepModel getCEPObject(String cepResponse) {
        return g.fromJson(cepResponse, CepModel.class);
    }

    public CepModel getCEP(String cep) throws IOException {
        String url = buildUrl(cep);
        String response = Http.GET(url);
        return getCEPObject(response);
    }
}
