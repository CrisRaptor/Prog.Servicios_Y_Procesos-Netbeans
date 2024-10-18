package t1aplicacion22_cgc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 *
 * @author CrisGC
 */
public class T1Aplicacion22_CGC {

    public static void main(String[] args) {
        try {
            ProcessBuilder procesoB = new ProcessBuilder("C:\\Program Files\\Mozilla Firefox\\firefox.exe", "https://github.com/CrisRaptor");
            procesoB.start();
            Map<String, String> env = procesoB.environment();
            Process p = procesoB.start();
            System.out.println(env);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
