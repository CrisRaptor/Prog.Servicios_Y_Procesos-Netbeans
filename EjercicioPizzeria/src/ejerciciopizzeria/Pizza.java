package ejerciciopizzeria;

/**
 *
 * @author CrisGC
 */
public class Pizza {
    static int codigo = 0;
    int segundosCoccion;
    double precio;

    public Pizza(int segundosCoccion, double precio) {
        this.codigo = codigo;
        codigo++;
        this.segundosCoccion = segundosCoccion;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+" | Codigo: "+ codigo + "\nTiempo de Coccion (s):" + segundosCoccion + ", Precio: " + String.format("%.2f",precio);
    }

    public int getSegundosCoccion() {
        return segundosCoccion;
    }
}
