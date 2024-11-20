package conexionjavapython;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author CrisGC
 */
public class ConexionJavaPython {

    public static void main(String[] args) {
        try {
            Process proceso = new ProcessBuilder(
                    "py",
                    "C:\\Users\\ALUMNO2425\\Documents\\Java\\Netbeans\\ConexionJavaPython\\proceso_Python.py"
            ).start();
            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            proceso.waitFor();
            int exitStatus = proceso.exitValue();
            System.out.println("Retorno: " + br.readLine());
            System.out.println("Valor de la salida: " + exitStatus);
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
