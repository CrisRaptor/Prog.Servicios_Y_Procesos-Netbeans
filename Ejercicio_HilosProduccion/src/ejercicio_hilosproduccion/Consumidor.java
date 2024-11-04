package ejercicio_hilosproduccion;

/**
 *
 * @author CrisGC
 */
public class Consumidor extends Thread {

    Buffer b;
    int id;
    int suma;
    static int max = 100;
    static int cont = 1;

    public Consumidor(Buffer b) {
        this.b = b;
        suma = 0;
        id = cont;
        cont++;
    }

    @Override
    public void run() {
        int valor;

        while (!b.isTerminado()) {
            valor = b.consumir();
            suma += valor;
            System.out.println("Consumidor " + id + " ha consumido " + valor+ " | Suma: "+suma);
            //System.out.println(b);
            if (suma >= max){
                b.setTerminado(true);
            }
        } 
        
    }

}
