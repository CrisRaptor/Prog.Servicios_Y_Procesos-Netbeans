package sockettcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketTCPServer {
    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream input;
    private OutputStream output;
    private DataInputStream inputString;
    private DataOutputStream outputString;
    //No funcionales
//    private ObjectInputStream inputObject;
//    private ObjectOutputStream outputObject;

    public SocketTCPServer (int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
    }
    
    public void start() throws IOException {
        socket = serverSocket.accept();
        input = socket.getInputStream();
        output = socket.getOutputStream();
        System.out.println("(Servidor) Conexion establecida.");
    }
    
    public void stop() throws IOException {
        input.close();
        output.close();
        socket.close();
        serverSocket.close();
        System.out.println("(Servidor) Conexiones cerradas.");
    } 
    
    public void abrirCanalesTexto(){
        inputString = new DataInputStream(input);
        outputString = new DataOutputStream(output);
        System.out.println("(Servidor) Canales de texto abiertos...");
    }
    
    public void cerrarCanalesTexto() throws IOException{
        inputString.close();
        outputString.close();
        System.out.println("(Servidor) Canales de texto cerrados...");
    }
    
    public void enviarMensajeTexto(String texto) throws IOException{
        outputString.writeUTF(texto);
        System.out.println("(Servidor) Mensaje enviado...");
    }
    
    public String recibirMensajeTexto() throws IOException{
        String mensaje = inputString.readUTF();
        System.out.println("(Servidor) Mensaje recibido...");
        return mensaje;
    }
    
    //No funcionales
//    public void abrirCanalesObjeto() throws IOException{
//        inputObject = new ObjectInputStream(input);
//        outputObject = new ObjectOutputStream(output);
//        System.out.println("(Servidor) Canales de objeto abiertos...");
//    }
//    
//    public void cerrarCanalesObjeto() throws IOException{
//        inputString.close();
//        outputString.close();
//        System.out.println("(Servidor) Canales de objeto cerrados...");
//    }
//    
//    public void enviarObjeto(Object objeto) throws IOException{
//        outputObject.writeObject(objeto);
//    }
//    
//    public Object recibirObjeto() throws IOException, ClassNotFoundException{
//        Object objeto = inputObject.readObject();
//        return objeto;
//    }
}
