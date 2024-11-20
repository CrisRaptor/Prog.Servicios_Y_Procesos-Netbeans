package ejercicio_hilosproduccion;

import java.util.Arrays;

/**
 *
 * @author CrisGC
 */
public class Buffer {

    public int[] valores;
    private int size = 10;
    private int cantValores;
    private boolean terminado;
   

    public Buffer() {
        valores = new int[size];
        cantValores = 0;
        terminado = false;
    }

    public boolean isTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }

    public synchronized int consumir() {
        int valor = 0;
        if (cantValores > 0) {
            valor = valores[cantValores - 1];
            valores[cantValores - 1] = 0;
            cantValores--;
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Error de la espera - "+ex.getMessage());
            }
        }

        return valor;
    }

    public synchronized boolean producir(int i) {
        boolean insertado;
        if (cantValores == valores.length) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Error de la espera - "+ex.getMessage());
            }
            insertado = false;
        } else {
            valores[cantValores] = i;
            cantValores++;
            insertado = true;
            notifyAll();
        }

        return insertado;
    }

    @Override
    public String toString() {
        return "Buffer |" + "Cant " + cantValores + " | Valores=" + Arrays.toString(valores);
    }

}
