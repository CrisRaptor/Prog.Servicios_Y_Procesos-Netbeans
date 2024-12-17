package sockettcp;

import java.io.IOException;


public class ClientePerro {

    public static void main(String[] artgs) {
        try {
            SocketTCPClient client = new SocketTCPClient("localhost", 50001);
            client.start();
            client.abrirCanalesTexto();
//            client.abrirCanalesObjeto();
            client.enviarMensajeTexto("Dame Gato");
            client.enviarMensajeTexto("Dame Perro");
            int cantidadPerros = Integer.parseInt(client.recibirMensajeTexto());
            String recibido = client.recibirMensajeTexto();
            while(!recibido.equals("OK.POSICION")){
                recibido = client.recibirMensajeTexto();
            }
            int ramdom = (int)(Math.random() * (cantidadPerros+2));
            client.enviarMensajeTexto(String.valueOf(ramdom));
            recibido = client.recibirMensajeTexto();     
            if (recibido.equals("ERROR")){
                System.out.println("ERROR. Posicion incorrecta indicada");
            } else if(recibido.equals("ENVIO PERRO")){
                System.out.println("Se va a recibir un perro...");
                String perro = client.recibirMensajeTexto();
                System.out.println(perro);
//                Perro perro = (Perro) client.recibirObjeto();
//                System.out.println(perro.toString());
            }
            client.cerrarCanalesTexto();
            client.stop();
        } catch (IOException ex) {
            System.out.println("Error en el input/output");
            ex.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println("El mensaje recibido no es un numero");
            e.printStackTrace();
        } 
//        catch (ClassNotFoundException c) {
//            System.out.println("No se encontro la clase");
//            c.printStackTrace();
//        }
     
        
    }
                      
}