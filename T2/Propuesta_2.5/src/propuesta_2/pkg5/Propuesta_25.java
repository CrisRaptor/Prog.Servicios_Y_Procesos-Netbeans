package propuesta_2.pkg5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CrisGC
 */
public class Propuesta_25 {

    public static void main(String[] args) {
        new Hilo("1").start();
        new Hilo("2").start();
        new Hilo("3").start();
        new Hilo("4").start();
        new Hilo("5").start();
        
    }
    
    public static class Hilo extends Thread{
        String name;

        public Hilo(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while(true){
                System.out.println("Soy el bucle "+this.name+" y estoy trabajando");
                try {
                    Thread.sleep((int) (Math.random() * 9000 + 1));
                } catch (InterruptedException ex) {
                    System.out.println("ERROR - No se pudo dormir: "+ex.getMessage());
                }
            }
        }
        
        
    }
}
