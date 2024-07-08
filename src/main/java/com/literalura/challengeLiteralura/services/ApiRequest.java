package com.literalura.challengeLiteralura.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {

    // I made this method to catch the Api's url to make a request
    public String getData(String url){

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        }catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        String json = response.body();
        return json;

    }


}
