package barberia;

import java.util.Arrays;
//Cris: Sin editar
public class Cliente implements Runnable {

    private GestorSillas gestorSillas;

    public Cliente(GestorSillas gestorSillas) {
        this.gestorSillas = gestorSillas;
    }

    //Cris: Sin editar
    @Override
    public void run() {
        // Los clientes no esperan que haya sillas libres, no hay bucle infinito.
        // Si no hay sillas libres se van...
        entrarEnBarberia();
    }
    
    //Cris: Sin editar
    public void entrarEnBarberia() {
        
        
        int posSillaLibre = gestorSillas.getPosSillaLibre();
        if (posSillaLibre == -1) {
            System.out.println("Nuevo cliente - No habia sillas libres, me marcho");
        } else {
            System.out.println("Nuevo cliente se sienta en la silla: " + posSillaLibre);
        }
        
    }
}
