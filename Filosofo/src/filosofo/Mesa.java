package filosofo;

public class Mesa {
     
    private boolean[] tenedores;
     
    public Mesa(int numTenedores){
        tenedores = new boolean[numTenedores];
    }
     
    public int tenedorIzquierda(int comensal){
        int pos;
        if (comensal == 1) {
            pos = tenedores.length-1;
        } else {
            pos = comensal-2;
        }
        return pos;
    }
     
    public int tenedorDerecha(int comensal){
        
        return comensal-1;
    }
     
    public synchronized void cogerTenedores(int comensal){
        while (tenedores[tenedorIzquierda(comensal)]||tenedores[tenedorDerecha(comensal)]){
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        tenedores[tenedorIzquierda(comensal)] = true;
        tenedores[tenedorDerecha(comensal)] = true;
        
    }
     
    public synchronized void dejarTenedores (int comensal){
        tenedores[tenedorIzquierda(comensal)] = false;
        tenedores[tenedorDerecha(comensal)] = false;
        notifyAll();
    }

}
