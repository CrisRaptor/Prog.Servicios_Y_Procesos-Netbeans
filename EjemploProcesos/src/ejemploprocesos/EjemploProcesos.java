package ejemploprocesos;

/**
 *
 * @author CrisGC
 */
public class EjemploProcesos {

    public static void main(String[] args) {
        try {
            String[] infoProceso = {"java",".\\ProcesoSecundario"};
            Process proceso = Runtime.getRuntime().exec(infoProceso);
            int valorRetorno = proceso.waitFor();
            System.out.println((valorRetorno == 0)?"Proceso completado":("Proceso fallido. Error: "+valorRetorno));
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
