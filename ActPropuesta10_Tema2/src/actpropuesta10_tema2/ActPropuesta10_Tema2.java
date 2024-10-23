package actpropuesta10_tema2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CrisGC
 */
// 
public class ActPropuesta10_Tema2 implements Runnable{

    Semaphore sm = new Semaphore(2);
    
    protected void metodo1(){
        try {
            sm.acquire();
            System.out.println("Encendiendo 1");
            Thread.sleep(2000);
            System.out.println("Apagando 1");
            sm.release();
        } catch (InterruptedException ex) {
        }
        
    }
    
    protected void metodo2() {
        try {
            System.out.println("Encendiendo 2");
            Thread.sleep(2000);
            System.out.println("Apagando 2");
        } catch (InterruptedException ex) {
        }
    }
    
    public static void main(String[] args) {
        ActPropuesta10_Tema2 act = new ActPropuesta10_Tema2();
        for (int i = 0; i < 8; i++) {
            new Thread(act).start();
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            
        }
        metodo1();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            
        }
        metodo2();
    }
    
}
