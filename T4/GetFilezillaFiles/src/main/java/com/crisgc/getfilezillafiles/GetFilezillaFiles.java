package com.crisgc.getfilezillafiles;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author CrisGC
 */
public class GetFilezillaFiles {

    private static FTPClient clienteFTP;
    private static final String SERVIDOR = "localhost";
    private static final int PUERTO = 21;
    private static final String USUARIO = "usuario";
    private static final String PASSWORD = "12345678";

    public static void main(String[] args) {
        clienteFTP = new FTPClient();
        connect();
        System.out.println("Conexion establecida");
        getFiles("/");
        disconnect();
        System.out.println("Conexion finalizada");
    }

    public static void connect() {
        try {
            clienteFTP.connect(SERVIDOR, PUERTO);
            int respuesta = clienteFTP.getReplyCode();

            if (!FTPReply.isPositiveCompletion(respuesta)) {
                clienteFTP.disconnect();
                throw new IOException("Error al conectar con el servidor FTP");
            }

            boolean credencialesOK = clienteFTP.login(USUARIO, PASSWORD);

            if (!credencialesOK) {
                throw new IOException("Error al conectar con el servidor FTP. Credenciales incorrectas.");
            }

            clienteFTP.setFileType(FTP.BINARY_FILE_TYPE);
        } catch (IOException ex) {
            System.out.println("Error al conectar");
        }
    }

    public static void disconnect() {
        try {
            clienteFTP.disconnect();
        } catch (IOException ex) {
            System.out.println("Error al desconectar");
        }
    }

    public static void getFiles(String route) {
        try {
            FTPFile[] files = clienteFTP.listFiles(route);

            for (FTPFile file : files) {
                getFile(file.getName());
                System.out.println(file.getName());
            }
        } catch (IOException ex) {
            System.out.println("Error al recibir lista de archivos");
        }
    }

    public static boolean getFile(String file) {
        OutputStream os = null;
        try {
            os = new BufferedOutputStream(new FileOutputStream(file));
            boolean recibido = clienteFTP.retrieveFile(file, os);
            os.close();
            return recibido;
        } catch (FileNotFoundException ex) {
            System.out.println("Error, archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Error IO al recibir archivo");
        } finally {
            try {
                if (os != null){
                    os.close();
                } 
            } catch (IOException ex) {
                System.out.println("Error al recibir archivo, al cerrar el OutputStream");
            }
        }
        return false;
    }

}
