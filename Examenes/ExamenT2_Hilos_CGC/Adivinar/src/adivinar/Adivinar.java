package adivinar;

/**
 *
 * @author CrisGC
 */
public class Adivinar {

    public static void main(String[] args) {
        int numeroOculto = (int) (Math.random() *101);
        
        for (int i = 1; i <= 10; i++) {
            NumeroOculto hilo = new NumeroOculto(numeroOculto,i);
            hilo.start();
        }
    }
}
