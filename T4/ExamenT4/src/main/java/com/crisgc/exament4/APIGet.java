package com.crisgc.exament4;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;


/**
 *
 * @author CrisGC
 */
public class APIGet {
    
    
    public static String getResponse(String url){
        String response = "";
        try {
            URL conUrl = new URL(url);
            HttpURLConnection conexion = (HttpURLConnection) conUrl.openConnection();
            conexion.setRequestMethod("GET");
            conexion.setRequestProperty("Content-Type", "text-plain");
            conexion.setRequestProperty("User-Agent", "Mozilla/5.0");
            conexion.setRequestProperty("charset", "utf-8");
            conexion.connect();
            response = conexion.getResponseMessage();
            conexion.disconnect();
        } catch (ProtocolException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
        return response;
    }
    
}
