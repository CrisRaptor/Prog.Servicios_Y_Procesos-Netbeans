package filosofo;

import java.util.concurrent.Semaphore;

public class Mesa {

    private boolean[] tenedores;
    private static Semaphore[] semaforos;

    public Mesa(int numTenedores) {
        tenedores = new boolean[numTenedores];
        semaforos = new Semaphore[numTenedores];
        for (int i = 0; i < semaforos.length; i++) {
            semaforos[i] = new Semaphore(1);
        }
    }

    public int tenedorIzquierda(int comensal) {
        int pos;
        if (comensal == 1) {
            pos = tenedores.length - 1;
        } else {
            pos = comensal - 2;
        }
        return pos;
    }

    public int tenedorDerecha(int comensal) {
        return comensal - 1;
    }

    public void cogerTenedores(int comensal) {
        boolean izq, der;
        int tenIzq = tenedorIzquierda(comensal), tenDer = tenedorDerecha(comensal);
        izq = semaforos[tenIzq].tryAcquire();
        der = semaforos[tenDer].tryAcquire();
        while (!der || !izq) {
            if (izq) {
                semaforos[tenIzq].release();
            }
            if (der) {
                semaforos[tenDer].release();
            }

            izq = semaforos[tenIzq].tryAcquire();
            der = semaforos[tenDer].tryAcquire();
        }
    }

    public void dejarTenedores(int comensal) {
        semaforos[tenedorIzquierda(comensal)].release();
        semaforos[tenedorDerecha(comensal)].release();
    }
}
