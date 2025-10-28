package com.alura.conversor.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ApiClient {
    private static final String API_KEY = "742af4489792d11c45628c7f";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";


    public static String getExchangeRates(String baseCurrency) throws IOException {
        String urlStr = API_URL + baseCurrency;
        URL url = new URL(urlStr);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.connect();

        int responseCode = request.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Error en la solicitud: " + responseCode);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return response.toString();
    }
}
