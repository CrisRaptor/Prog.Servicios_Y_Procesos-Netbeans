package ejercicio_hilosproduccion;

/**
 *
 * @author CrisGC
 */
public class Productor extends Thread {

    Buffer b;
    int id;
    static int cont = 1;

    public Productor(Buffer b) {
        this.b = b;
        id = cont;
        cont++;
    }

    @Override
    public void run() {
        boolean resultado;
        int random;
        while (!b.isTerminado()) {
            random = (int) (Math.random() * 10 + 1);

            resultado = b.producir(random);
            System.out.println("Productor " + id + " ha producido " + random + " : " + random);
            //System.out.println(b);
        }

    }

}
