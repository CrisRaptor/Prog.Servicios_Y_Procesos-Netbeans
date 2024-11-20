
package sockettcpserver;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ricardovillabrieva
 */
public class SocketTCPServer {

    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream is;
    private OutputStream os;
    
    // Objetos específicos para el envío y recepción de cadenas de caracteres
//    private InputStreamReader isr;
//    private BufferedReader br;
    private DataInputStream dis;
    private DataOutputStream dos;
//    private PrintWriter pw;
    
    
    private SocketTCPServer(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
    }
    
    public void start() throws IOException {
        System.out.println("(Servidor) Esperando conexiones...");
        socket = serverSocket.accept();
        is = socket.getInputStream();
        os = socket.getOutputStream();
        System.out.println("(Servidor) Conexión establecida.");
    }
    
    public void stop() throws IOException {
        System.out.println("(Servidor) Cerrando conexiones...");
        is.close();
        os.close();
        socket.close();
        serverSocket.close();
        System.out.println("(Servidor) Conexiones cerradas.");
    }
    
    public void abrirCanalesDeTexto() {
        System.out.println("(Servidor) Abriendo canales de texto...");
        dis = new DataInputStream(is);
//        isr = new InputStreamReader(is);
//        br = new BufferedReader(isr);
        // Canales de escritura
//        pw = new PrintWriter(os,true);
        dos = new DataOutputStream(os);
        System.out.println("(Servidor) Canales de texto abiertos.");
    }
    
    public void cerrarCanalesDeTexto() throws IOException {
        System.out.println("(Servidor) Cerrando canales de texto...");
       //Canales de lectura
        dis.close();
//        br.close();
//        isr.close();
        //Canales de escritura
        dos.close();
//        pw.close();
        System.out.println("(Servidor) Canales de texto cerrados.");
    }
    
    public String leerMensajeTexto() throws IOException {
        System.out.println("(Servidor) Leyendo mensaje...");
        String mensaje = dis.readUTF();
        System.out.println("(Servidor) Mensaje leido.");
        return mensaje;
    }
    
    public void enviarMensajeTexto(String mensaje) throws IOException {
        System.out.println("(Servidor) Enviado mensaje...");
        dos.writeUTF(mensaje);
        System.out.println("(Servidor) Mensaje enviado.");
    }
    
    
    public static void main(String[] args) {
        try {
            SocketTCPServer servidor = new SocketTCPServer(49171);
            servidor.start();
            servidor.abrirCanalesDeTexto();
            
            //Recepcion del mensaje del Cliente
            String mensajeRecibido = servidor.leerMensajeTexto();
            System.out.println("(Servidor) Mensaje recibido: " + mensajeRecibido);
            // Envío del mensaje al cliente
            servidor.enviarMensajeTexto("Mensaje enviado desde el servidor");
            
            servidor.cerrarCanalesDeTexto();
            servidor.stop();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
}
