
package sockettcpclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author ricardovillabrieva
 */
public class SocketTCPClient {

    private String serverIP;
    private int serverPort;
    private Socket socket;
    private InputStream is;
    private OutputStream os;
    // Objetos específicos para el envío y recepción de cadenas de caracteres
    private DataInputStream dis;
    private DataOutputStream dos;
    
    private SocketTCPClient(String serverIP, int serverPort) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }
    
    public void start() throws UnknownHostException, IOException {
        System.out.println("(Cliente) Estableciendo conexión...");
        socket = new Socket(serverIP, serverPort);
        os = socket.getOutputStream();
        is = socket.getInputStream();

        System.out.println("(Cliente) Conexión establecida.");
    }
    
    public void stop() throws IOException {
        System.out.println("(Cliente) Cerrando conexiones...");
        is.close();
        os.close();
        socket.close();  
        System.out.println("(Cliente) Conexiones cerradas.");
    }
    
    public void abrirCanalesDeTexto() {
        System.out.println("(Cliente) Abriendo canales de texto...");
        // Canales de lectura
        dis = new DataInputStream(is);
        // Canales de escritura
        dos = new DataOutputStream(os);
        System.out.println("(Cliente) Canales de texto abiertos.");
    }
    
    public void cerrarCanalesDeTexto() throws IOException {
        System.out.println("(Cliente) Cerrando canales de texto...");
        //Canales de lectura
        dis.close();
        //Canales de escritura
        dos.close();
        System.out.println("(Cliente) Canales de texto cerrados.");
    }
    
    public String leerMensajeTexto() throws IOException {
        System.out.println("(Cliente) Leyendo mensaje...");
        String mensaje = dis.readUTF();
        System.out.println("(Cliente) Mensaje leido.");
        return mensaje;
    }
    
    public void enviarMensajeTexto(String mensaje) throws IOException {
        System.out.println("(Cliente) Enviado mensaje...");
        dos.writeUTF(mensaje);
        System.out.println("(Cliente) Mensaje enviado.");
    }
    
    
    
    public static void main(String[] args) {
        SocketTCPClient cliente = new SocketTCPClient("localhost",49171);
        try {
            
            cliente.start();
            cliente.abrirCanalesDeTexto();
            
            // Envío del mensaje al servidor
            cliente.enviarMensajeTexto("Mensaje enviado desde el cliente");
            
            //Recepcion del mensaje del Servidor
            String mensajeRecibido = cliente.leerMensajeTexto();
            System.out.println("(Cliente) Mensaje recibido: " + mensajeRecibido);
            
            cliente.cerrarCanalesDeTexto();
            cliente.stop();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
