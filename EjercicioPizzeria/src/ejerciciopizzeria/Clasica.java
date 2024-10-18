package ejerciciopizzeria;

/**
 *
 * @author CrisGC
 */
public class Clasica extends Pizza {
    boolean bordeRelleno = false;

    public Clasica(int segundosCoccion, double precio) {
        super(segundosCoccion, precio);
    }
    
    public Clasica(int segundosCoccion, double precio, boolean bordeRelleno) {
        super(segundosCoccion, precio);
        this.bordeRelleno = bordeRelleno;
    }

    public boolean isBordeRelleno() {
        return bordeRelleno;
    }

    @Override
    public String toString() {
        return super.toString() + ((bordeRelleno)?", Borde relleno: Si":"");
    }
    
    
}
