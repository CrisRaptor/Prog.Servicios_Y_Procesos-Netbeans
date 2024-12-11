package sockettcp;

import java.io.IOException;

public class ServidorPerro {
    
    private static Perro[] listaPerros = {
                            new Perro("Balto",98),
                            new Perro("Chonino",40),
                            new Perro("Laika",66),
                            new Perro("Stubby",50),
                            new Perro("Smoky",51),
                            new Perro("Barry",223),
                            new Perro("Old Drum",154)
                        };
    
    
    public static void main(String[] args) {
        try {
            SocketTCPServer server = new SocketTCPServer(50001);
            server.start();
            server.abrirCanalesTexto();
//            server.abrirCanalesObjeto();
            String recibido = server.recibirMensajeTexto();
            while(!recibido.equals("Dame Perro")){
                recibido = server.recibirMensajeTexto();
            }
            server.enviarMensajeTexto(String.valueOf(listaPerros.length));
            server.enviarMensajeTexto("OK.POSICION");
            int posicion = Integer.parseInt(server.recibirMensajeTexto());
            if(posicion >= 0 && posicion < (listaPerros.length)){
                server.enviarMensajeTexto("ENVIO PERRO");
                Perro perro = listaPerros[posicion];
                server.enviarMensajeTexto(perro.toString());
//                server.enviarObjeto(listaPerros[posicion]);
            } else {
                server.enviarMensajeTexto("ERROR");
            }
//            server.cerrarCanalesObjeto();
            server.cerrarCanalesTexto();
            server.stop();
            
        } catch (IOException ex) {
            System.out.println("Error en el input/output");
            ex.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println("El mensaje recibido no es un numero");
            e.printStackTrace();
        }
    }
}
