package ejerciciopizzeria;

/**
 *
 * @author CrisGC
 */
public class Calzone extends Pizza {

    public Calzone(int segundosCoccion, double precio) {
        super(segundosCoccion, (precio*1.05));
    }
    
}
