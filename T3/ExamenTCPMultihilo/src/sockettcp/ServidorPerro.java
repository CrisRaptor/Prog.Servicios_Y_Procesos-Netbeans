package sockettcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServidorPerro extends Thread{
    
    private static Perro[] listaPerros = {
                            new Perro("Balto",98),
                            new Perro("Chonino",40),
                            new Perro("Laika",66),
                            new Perro("Stubby",50),
                            new Perro("Smoky",51),
                            new Perro("Barry",223),
                            new Perro("Old Drum",154)
                        };
    private Socket socket;
    private InputStream input;
    private OutputStream output;
    private DataInputStream inputString;
    private DataOutputStream outputString;

    public ServidorPerro(Socket socket) {
        this.socket = socket;
        
    }

    @Override
    public void run() {
        try {
            abrirCanales();
            abrirCanalesTexto();
            System.out.println("--- INICIO PETICION ---");
            String recibido = recibirMensajeTexto();
            while(!recibido.equals("Dame Perro")){
                recibido = recibirMensajeTexto();
            }
            enviarMensajeTexto(String.valueOf(listaPerros.length));
            enviarMensajeTexto("OK.POSICION");
            int posicion = Integer.parseInt(recibirMensajeTexto());
            if(posicion >= 0 && posicion < (listaPerros.length)){
                enviarMensajeTexto("ENVIO PERRO");
                Perro perro = listaPerros[posicion];
                enviarMensajeTexto(perro.toString());
            } else {    
                enviarMensajeTexto("ERROR");
            }
            System.out.println("--- FIN PETICION ---");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        try {
            SocketTCPServer server = new SocketTCPServer(50001);
        } catch (IOException ex) {
            System.out.println("Error en el input/output");
            ex.printStackTrace();
        } 
    }
    
    public void abrirCanales() throws IOException{
         input = socket.getInputStream();
        output = socket.getOutputStream();
        System.out.println("(Servidor) Canales abiertos...");
     }
     
     public void cerrarCanales() throws IOException{
         input = socket.getInputStream();
        output = socket.getOutputStream();
        System.out.println("(Servidor) Canales cerrados...");
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
        System.out.println("(Servidor) Mensaje enviado: "+texto);
    }
    
    public String recibirMensajeTexto() throws IOException{
        String mensaje = inputString.readUTF();
        System.out.println("(Servidor) Mensaje recibido: "+mensaje);
        return mensaje;
    }
}
