package ejconcurrencia1;

/**
 *
 * @author CrisGC
 */
public class Incrementador extends Thread{
    static int contador = 0;

    public Incrementador() {
    }

    @Override
    public void run() {
        int iteraciones = 0;
        do {    
            iteraciones++;
            //Metodo sin sincronizar
            contador++;
            System.out.println(contador);
            
            //Metodo sincronizado para acceder al metodo
            //System.out.println(incrementar());
            
        } while (iteraciones < 5000);
    }
    
    //Metodo sincronizado para acceder al metodo
    private synchronized int incrementar(){
        contador++;
        return contador;
    }
}
