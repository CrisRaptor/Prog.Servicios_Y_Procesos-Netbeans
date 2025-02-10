package com.crisgc.exament4;

import com.google.gson.Gson;
import jakarta.mail.Message;

/**
 *
 * @author CrisGC
 */
public class ExamenT4 {

    public static void main(String[] args) {
        //Parte 1, recibir la información de una api
        final int id = 8;
        String url = "https://fakestoreapi.com/products/"+id;
        String response = APIGet.getResponse(url);
        
        //Almacenar respuesta
        Gson gson = new Gson();
        Product product = gson.fromJson(response, Product.class);
        
        //Parte 2, enviar un correo
        String reciever = "rvilbri995@g.educaand.es";
        Mail correo = new Mail();
        String text = "Producto "+product.getId()+
                "\nDescripcion: "+product.getDescription()+
                "\nCategoria: "+product.getCategory()+
                "\nPrecio: "+product.getPrice();
        correo.sendMessage("cristian.garcia@gmx.com",reciever,"Examen T4 "+product.getTitle(),text,"cristian.garcia@gmx.com","PSPIESBelen",product.getImage());
    }
}
