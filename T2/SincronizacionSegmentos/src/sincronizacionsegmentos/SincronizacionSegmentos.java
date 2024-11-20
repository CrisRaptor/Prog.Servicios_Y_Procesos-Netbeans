package sincronizacionsegmentos;

/**
 *
 * @author CrisGC
 */
public class SincronizacionSegmentos extends Thread {

    int id;
    Object bloqueo1 = new Object();
    Object bloqueo2 = new Object();

    public SincronizacionSegmentos(int id) {
        this.id = id;
    }

    private synchronized void metodo1() {
        synchronized (bloqueo1) {
            System.out.println("Comienzo del metodo 1 | ID: " + id);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                return;
            }
            System.out.println("Fin del metodo 1 | ID: " + id);
        }

    }

    private synchronized void metodo2() {
        synchronized (bloqueo1) {
            System.out.println("Comienzo del metodo 2 | ID: " + id);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                return;
            }
            System.out.println("Fin del metodo 2 | ID: " + id);
        }
    }

    @Override
    public void run() {
        if (id == 1){
            metodo1();
            metodo2();
        } else {
            metodo2();
            metodo1();  
        }
        
    }

    public static void main(String[] args) {
        new SincronizacionSegmentos(1).start();
        new SincronizacionSegmentos(2).start();
    }

}
