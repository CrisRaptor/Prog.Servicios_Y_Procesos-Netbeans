package ejercicio_hilosproduccion;

/**
 *
 * @author CrisGC
 */
public class Ejercicio_HilosProduccion {

    public static void main(String[] args) {
        Buffer b = new Buffer();
        Productor p1 = new Productor(b);
        Productor p2 = new Productor(b);
        Consumidor c1 = new Consumidor(b);
        p1.start();
        p2.start();
        c1.start();
    }
    
}
