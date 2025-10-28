package com.alura.conversor.service;

import com.alura.conversor.model.CurrencyResponse;
import com.alura.conversor.util.ApiClient;
import com.google.gson.Gson;
import java.io.IOException;

public class CurrencyService {
    private final Gson gson = new Gson();

    public double convert(String from, String to, double amount) throws IOException {
        String jsonResponse = ApiClient.getExchangeRates(from);
        CurrencyResponse response = gson.fromJson(jsonResponse, CurrencyResponse.class);

        if (response.getConversion_rates() == null || !response.getConversion_rates().containsKey(to)) {
            throw new RuntimeException("No se encontró la tasa de conversión para " + to);
        }

        double rate = response.getConversion_rates().get(to);
        return amount * rate;
    }
}
