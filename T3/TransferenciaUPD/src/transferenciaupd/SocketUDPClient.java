
package transferenciaupd;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class SocketUDPClient {

    
      
    public static void main(String[] args) {
        
        String strMensaje;
        DatagramSocket socketUDP;
        
        try {
            System.out.println("(Cliente): Estableciendo parametros de conexion...");
            InetAddress hostServidor = InetAddress.getByName("localhost");
            int puertoServidor = 49171;
            
            socketUDP = new DatagramSocket();
            DatagramPacket peticion;
            for (int i = 0; i<10000; i++) {
                strMensaje = "Mensaje: "+i;
                byte[] mensaje = strMensaje.getBytes();
                peticion = new DatagramPacket(mensaje, mensaje.length,hostServidor, puertoServidor);
                socketUDP.send(peticion);
            }
            byte[] mensaje = "FIN".getBytes();
            peticion = new DatagramPacket(mensaje, mensaje.length,hostServidor, puertoServidor);
            socketUDP.send(peticion);
            
            System.out.println("(Cliente): Cerrando socket...");
            socketUDP.close();
            System.out.println("(Cliente) Socket cerrado.");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
