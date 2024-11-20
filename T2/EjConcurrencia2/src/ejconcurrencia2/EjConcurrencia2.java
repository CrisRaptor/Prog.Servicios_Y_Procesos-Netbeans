package ejconcurrencia2;

import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author CrisGC
 */
public class EjConcurrencia2 {

    /*args:
    files/java_main_jdbc.txt files/examen_android_main.txt files/form_ventacoches_cs.txt 
    files/ejercicio_sistemas.txt files/plantilla_apuntes.txt files/ejercicio_algoritmos_planificacion.txt
    */
    public static void main(String[] args) {
        System.out.println("Archivos: "+args.length);
        for (String arg : args) {
            new Reader(arg).start();
        }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(EjConcurrencia2.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        Reader r = new Reader("");
        System.out.println("Total de lineas: "+ r.getTotalLines()
                +"\nTotal de palabras: "+ r.getTotalLines()
        +"\nTotal de letras: "+ r.getTotalChars());
    }
    
    
}
