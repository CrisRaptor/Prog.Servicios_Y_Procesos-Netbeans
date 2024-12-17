package sockettcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketTCPServer {
    private ServerSocket serverSocket;

    public SocketTCPServer (int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
        while (true) {            
            Socket socket = serverSocket.accept();
            System.out.println("(Servidor) Conexiones abiertas.");
            new ServidorPerro(socket).start();
          
        }
    }
    
    public void stop() throws IOException {
        serverSocket.close();
    }
}