package ejconcurrencia2;


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
        System.out.println(args.length);
        for (String arg : args) {
            new Reader(arg).start();
        }
    }
    
    
}
