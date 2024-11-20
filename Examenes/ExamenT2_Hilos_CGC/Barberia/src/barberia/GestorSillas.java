
package barberia;

import java.util.concurrent.Semaphore;

public class GestorSillas {
    
    private final int MAX_SILLAS;
    private static int clientesAtendidos = 0;
    //Asientos disponibles
    Semaphore[] sillas;
    //Indica si hay un cliente esta sentado en esa silla sin ser atendido
    boolean[] clientesEsperando;

    public GestorSillas(int numSillas) {
        
        MAX_SILLAS = numSillas;
        // Construimos los vectores...
        sillas = new Semaphore[MAX_SILLAS];
        clientesEsperando = new boolean[MAX_SILLAS];
        for (int i = 0; i < MAX_SILLAS; i++) {
            sillas[i] = new Semaphore(1);
        }
    }

    public static int getClientesAtendidos() {
        return clientesAtendidos;
    }
    
    
    /**
     * Nos dice la posicion de una silla tiene algun cliente que no esta atendido, y lo atiende
     * @return un numero de silla o -1 si no hay clientes sin atender
     */
    public synchronized int getSiguienteCliente() {
        int pos = 0;
        while (pos < MAX_SILLAS){
            if (clientesEsperando[pos]) {//Mira si el cliente esta en espera
                clientesEsperando[pos] = false; //El cliente es atendido
                return pos;
            }
            pos++;
        }
        return -1;
    }

    
    /**
     * Nos dice el numero una silla que esta libre, y el cliente se sienta
     * @return Devuelve una posicion o -1 si esta todo ocupado
     */
    public synchronized int getPosSillaLibre() {
        int pos = 0;
        while (pos < MAX_SILLAS){
            if (sillas[pos].tryAcquire()) {//Comprueba cada silla
                clientesEsperando[pos] = true; //El cliente se sienta
                return pos;
            }
            pos++;
        }
        // Si llegamos aqui­ es que no habi­a nada libre
        return -1;
    }
    
    
    /**
     * El cliente de esa silla, se marcha, por lo que se marca esa silla como "libre"
     * @param pos Posicion de la silla liberada
     */
    public synchronized void liberarSilla(int pos) {
        clientesAtendidos++;
        sillas[pos].release(); //Libera la silla
        System.out.println("Se marcha el cliente de la silla: " + pos);
    }
}
