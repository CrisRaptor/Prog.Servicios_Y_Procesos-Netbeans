package gestorhojas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CrisGC
 */
public class GestorHojas extends Thread{

    private static List<String> lista = new ArrayList<>();

    @Override
    public void run() {
        while (true) {
            if (lista.size() >= 10) {
                lista.remove(0);
            } else if (lista.size() < 10) {
                lista.add("Texto");
            }

            for (String texto : lista) {
                System.out.println(texto + " ");
            }
        } 
    }

    
    
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            lista.add("Texto");
        }
        
        for (int i = 0; i < 100; i++) {
            new GestorHojas().start();
        }
    }

}
