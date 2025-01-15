/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.crisgc.apicat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CrisGC
 */
public class APICat {

    public static void main(String[] args) {
        CatApi();
    }

    public static void CatApi() {
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
        
        System.out.println(response.body());

//        HttpURLConnection con = null;
//        try {
//            URL url = new URL("https://api.thecatapi.com/v1/images/search");
//            con = (HttpURLConnection) url.openConnection();
//
//            con.setRequestMethod("GET");
//
//            ////Request headers
//            //con.setRequestProperty("x-api-key", "live_RmaYgkgOBovkDzRYUHklMIL5bqh38JV2FcQBvVqSKvca4rFwy0flDdUJMLMvl3Uy");
//            ////Request Parameters
//            HashMap<String, String> parameters = new HashMap<>();
//            //POSIBLES PARAMETROS
//            parameters.put("api-key", "live_RmaYgkgOBovkDzRYUHklMIL5bqh38JV2FcQBvVqSKvca4rFwy0flDdUJMLMvl3Uy");
            parameters.put("limit", "1");
            parameters.put("has_breeds", "0");
            String[] breeds = new String[0];
            parameters.put("breed_ids", breedFilter(breeds));
            parameters.put("category_ids", "1"); //Numero identifica una categoria, por ejemplo "Fun"
//
//            con.setDoOutput(true);
//            DataOutputStream out = new DataOutputStream(con.getOutputStream());
//            StringBuilder request = new StringBuilder("");
//            if (!parameters.isEmpty()) {
//                request.append("?");
//                boolean primerParametro = true;
//                for (Map.Entry<String, String> entry : parameters.entrySet()) {
//                    if (!primerParametro) {
//                        request.append("&");
//                    } else {
//                        primerParametro = false;
//                    }
//                    request.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
//                    request.append("=");
//                    request.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
//                }
//            }
//            System.out.println(request.toString());
//            out.writeBytes(request.toString());
//            out.flush();
//            out.close();
//
//            int status = con.getResponseCode();
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuffer content = new StringBuffer();
//            while ((inputLine = in.readLine()) != null) {
//                content.append(inputLine);
//            }
//            in.close();
//
//            System.out.println("Code: " + status + "\nResult:\n" + content);
//
//            Reader streamReader = null;
//
//            if (status > 299) {
//                streamReader = new InputStreamReader(con.getErrorStream());
//            } else {
//                streamReader = new InputStreamReader(con.getInputStream());
//            }
//
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(APICat.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(APICat.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (con != null) {
//                con.disconnect();
//            }
//        }
    }

    //Convierte un array string de breeds a un string con el formato del parametro
    private String breedFilter(String[] breeds) {
        String filter = "";
        for (String breed : breeds) {
            filter += breed + ",";
        }
        return filter.length() > 0
                ? filter.substring(0, filter.length() - 1)
                : filter;
    }
}
