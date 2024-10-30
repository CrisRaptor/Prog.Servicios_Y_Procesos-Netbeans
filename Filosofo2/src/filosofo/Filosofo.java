package filosofo;

public class Filosofo extends Thread {

    private Mesa mesa;
    private int comensal;

    public Filosofo(Mesa m, int comensal) {
        this.mesa = m;
        this.comensal = comensal;
    }

    public void run() {
        pensando();
        while (true) {
            mesa.cogerTenedores(comensal);
            comiendo();
            System.out.println("Filosofo " + comensal + " deja de comer");
            mesa.dejarTenedores(comensal);
            pensando();
        }
    }

    public void pensando() {
        System.out.println("Filosofo " + comensal + " piensa");
        try {
            Thread.sleep(1300);
        } catch (InterruptedException ex) {
            System.out.println("Error al comer");
        }
    }

    public void comiendo() {
        System.out.println("Filosofo " + comensal + " come");
        try {
            Thread.sleep(1300);
        } catch (InterruptedException ex) {
            System.out.println("Error al comer");
        }
    }
}
