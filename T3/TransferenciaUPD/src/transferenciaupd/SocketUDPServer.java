package transferenciaupd;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class SocketUDPServer {
        
    public static void main(String[] args) {
        
        DatagramSocket socket;
        try {
            System.out.println("(Servidor) Creando socket...");
            socket = new DatagramSocket(49171);
            
            DatagramPacket peticion;
            DatagramPacket datagramaEntrada;
            
            for (int i = 0; i < 10001; i++) {
                byte[] bufferLectura = new byte[64];
                datagramaEntrada = new DatagramPacket(bufferLectura, bufferLectura.length);
                socket.receive(datagramaEntrada);
                System.out.println(new String(bufferLectura));
            }
            System.out.println("(Servidor) Cerrado sockets...");
            socket.close();
            System.out.println("(Servidor) Socket cerrado.");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
}
