package sincronizacionmetodos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CrisGC
 */
public class SincronizacionMetodos implements Runnable{

    private synchronized void metodo1(){
        System.out.println("Comienzo del metodo 1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            return;
        }
        System.out.println("Fin del metodo 1");
    }
    
    private synchronized void metodo2(){
        System.out.println("Comienzo del metodo 2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            return;
        }
        System.out.println("Fin del metodo 2");
    }

    @Override
    public void run() {
        metodo1();
        metodo2();
    }
    
    public static void main(String[] args) {
        SincronizacionMetodos sm = new SincronizacionMetodos();
        new Thread(sm).start();
        new Thread(sm).start();
    }
}
