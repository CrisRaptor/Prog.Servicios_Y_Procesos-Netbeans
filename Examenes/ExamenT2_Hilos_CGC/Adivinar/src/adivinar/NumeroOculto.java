package adivinar;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CrisGC
 */
public class NumeroOculto extends Thread {

    private static boolean acertado;
    private static int numeroOculto;
    private final int id;

    public NumeroOculto(int numeroOculto, int id) {
        this.numeroOculto = numeroOculto;
        this.id = id;
        acertado = false;
    }

    @Override
    public void run() {
        int resultado, valor;
        while (!acertado) {
            valor = (int) (Math.random() * 101);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Error al dormir el hilo. " + ex.getMessage());
            }
            resultado = propuestaNumero(valor);
            anunciarResultado(resultado, valor);
        }
    }

    private int propuestaNumero(int num) {
        if (!acertado && num == numeroOculto) {
            acertado = true;
            return 1;
        } else if (acertado) {
            return -1;
        }
        return 0;
    }

    private void anunciarResultado(int num, int valor) {
        String cadena = "Hilo " + id + " propone: '" + valor + "'";
        if (acertado && num == 0) {
            num = -1;
        }
        switch (num) {
            case 0 -> {
                cadena += ". Ha fallado.";
            }
            case 1 -> {
                cadena += ". ACIERTO.";
            }
            default -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    System.out.println("Error al dormir el hilo. " + ex.getMessage());
                }
                cadena += ". El numero ya ha sido adivinado.";
            }
        }
        System.out.println(cadena);

    }
}
