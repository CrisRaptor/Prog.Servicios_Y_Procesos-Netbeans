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
            
            byte[] bufferLectura = new byte[64];
            String linea = "";
            DatagramPacket datagramaEntrada = new DatagramPacket(bufferLectura, bufferLectura.length);
            socket.receive(datagramaEntrada);
            
            while (!linea.equals("FIN")) {
                datagramaEntrada = new DatagramPacket(bufferLectura, bufferLectura.length);
                socket.receive(datagramaEntrada);
                linea = new String(datagramaEntrada.getData(), 0 ,datagramaEntrada.getLength());
                System.out.println(linea);
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
