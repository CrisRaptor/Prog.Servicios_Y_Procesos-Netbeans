
package chatsockets;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServer {
    
    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream is;
    private OutputStream os;
    private DataInputStream dis;
    private DataOutputStream dos;
    
    public SocketTCPServer (int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
    }
    
    public void start() throws IOException {
        System.out.println("(Servidor) Esperando conexiones...");
        socket = serverSocket.accept();
        is = socket.getInputStream();
        os = socket.getOutputStream();
        System.out.println("(Servidor) Conexion establecida.");
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
    
    public String leerArchivo(String ruta){
        System.out.println("Fichero indicado: "+ruta);
        String archivo = "";
        String linea;
        try (BufferedReader in = new BufferedReader(new FileReader(ruta))) {
            linea = in.readLine();
            while (linea != null){
                archivo += linea + "\n";
                linea = in.readLine();
            };
            System.out.println("Archivo leido.");
            System.out.println("Enviando archivo.");
        } catch (IOException ex) {
            System.out.println("Error: File not found - " + ex.getMessage());
            archivo = "Archivo no encontrado";
            System.out.println(archivo);
        } 
        return archivo;
    }
}
