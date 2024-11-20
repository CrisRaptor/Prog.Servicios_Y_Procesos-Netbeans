package ejerciciopizzeria;

/**
 *
 * @author CrisGC
 */
public class Cola<T> implements AccionesEstructuras<T> {

    private T[] cola;
    private int elementos;

    public Cola(int capacidad) {
        cola = (T[]) new Object[capacidad];
        elementos = 0;
    }
    
    @Override
    public boolean push(T elemento) {
        boolean exito = true;
        
        if (elementos >= cola.length) {
            exito = false;
        } else {
            cola[this.elementos++] = elemento;
        }
        
        return exito;      
    }

    @Override
    public T pop() {
        T objeto = cola[0];
        
        for (int i=0; i <this.elementos - 1; i++) {
            cola[i] = cola[i+1];
        }
        this.elementos--;
        
        return objeto; 
    }

    @Override
    public boolean esVacia() {
        return this.elementos == 0;
    }

    @Override
    public int getNumElementos() {
        return this.elementos;
    }
}
