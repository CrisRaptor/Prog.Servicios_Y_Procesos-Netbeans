package regar;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author CrisGC
 */
public class SistemaRiego extends TimerTask{

    @Override
    public void run() {
        System.out.println("Regando...");
    }
    
    public static void main(String[] args) {
        Timer temporizador = new Timer();
        temporizador.schedule(new SistemaRiego(), 1000,2000);
    }
}
