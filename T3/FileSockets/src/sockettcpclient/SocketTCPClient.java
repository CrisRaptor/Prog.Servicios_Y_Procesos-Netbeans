
package sockettcpclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class SocketTCPClient {

    private String serverIP;
    private int serverPort;
    private Socket socket;
    private InputStream is;
    private OutputStream os;
    private DataInputStream dis;
    private DataOutputStream dos;
    
    
    public SocketTCPClient(String serverIP, int serverPort) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }
    
    public void start() throws UnknownHostException, IOException {
        System.out.println("(Cliente) Estableciento conexion...");
        socket = new Socket(serverIP, serverPort);
        os = socket.getOutputStream();
        is = socket.getInputStream();
        System.out.println("(Cliente) Conexion establecida.");
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
//        isr = new InputStreamReader(is);
//        br = new BufferedReader(isr);
        // Canales de escritura
//        pw = new PrintWriter(os,true);
        dos = new DataOutputStream(os);
        System.out.println("(Cliente) Canales de texto abiertos.");
    }
    
    public void cerrarCanalesDeTexto() throws IOException {
        System.out.println("(Cliente) Cerrando canales de texto...");
        //Canales de lectura
        dis.close();
//        br.close();
//        isr.close();
        //Canales de escritura
        dos.close();
//        pw.close();
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
        Scanner kin = new Scanner(System.in);
        SocketTCPClient cliente = new SocketTCPClient("192.168.4.83",49171);//Ej "localhost",49171
        try {
            cliente.start();
            cliente.abrirCanalesDeTexto();
            System.out.println("Mensaje del servidor: " + cliente.leerMensajeTexto());
            //Ejemplos de ficheros del servidor local: ejercicio.txt, trick.bat, DEPENDENCIAS_MAVEN.txt
            cliente.enviarMensajeTexto(kin.nextLine());
            System.out.println("Archivo del servidor:\n " + cliente.leerMensajeTexto());
            cliente.cerrarCanalesDeTexto();
            cliente.stop();
        }catch (UnknownHostException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
