package barberia;

import java.util.Random;

public class Barbero implements Runnable {

    private String nombre;
    private int segundosMaximoEspera;
    private GestorSillas gestorSillas;
    private static Random generadorAle;
    //Nuevo atributo para cerrar la barberia
    private static boolean cerrado = false;

    static {
        generadorAle = new Random();  
    }

    public Barbero(GestorSillas gestorSillas, String nombre) {
        this.gestorSillas = gestorSillas;
        this.nombre = "Barbero " + nombre;
        this.segundosMaximoEspera = 3;

    }
    
    /**
     * El barbero cierra o abre la barberia
     * @param cerrado true si cierra, false si lo abre
     */
    public static void setCerrado(boolean cerrado) {
        Barbero.cerrado = cerrado;
    }

    //Cris: Sin editar
    public static void esperarTiempoAzar(int tiempoMax) {

        // Se calculan unos milisegundos al azar
        int msgs = (1 + generadorAle.nextInt(tiempoMax)) * 1000;

        try {
            Thread.currentThread().sleep(msgs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public void run() {
        
        int posSillaClienteSinAtender;
        //Editado, termina si se cierra la barberia
        while (!cerrado) {
            
            posSillaClienteSinAtender = this.gestorSillas.getSiguienteCliente();
            if (posSillaClienteSinAtender == -1) {
                Barbero.esperarTiempoAzar(this.segundosMaximoEspera);
            } else {
                System.out.println("Barbero atendiendo silla: " + posSillaClienteSinAtender);
                Barbero.esperarTiempoAzar(this.segundosMaximoEspera);
                this.gestorSillas.liberarSilla(posSillaClienteSinAtender);
            }
        }
    }
}
