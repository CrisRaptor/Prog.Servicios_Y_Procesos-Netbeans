/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.crisgc.apicat;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

/**
 *
 * @author CrisGC
 */
public class APICat {

    public static Cat[] CatRequest() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.thecatapi.com/v1/images/search"))
                .header("x-api-key", "live_RmaYgkgOBovkDzRYUHklMIL5bqh38JV2FcQBvVqSKvca4rFwy0flDdUJMLMvl3Uy")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Gson gson = new Gson();
        Cat[] cats = gson.fromJson(response.body(), Cat[].class);
        
        return cats;
    }
}
