package psp_t2_areatriangulo;

/**
 *
 * @author CrisGC
 */
public class PSP_T2_AreaTriangulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int base, altura;
        for (int i = 0; i < 1000000; i++) {
            base = (int) (Math.random() * 19 + 1);//Random 1-20
            altura = (int) (Math.random() * 19 + 1);//Random 1-20
            new Triangulo(base,altura).start();
        }
    }
    
    public static class Triangulo extends Thread{
        int base, altura;

        public Triangulo(int base, int altura) {
            this.base = base;
            this.altura = altura;
        }

        @Override
        public void run() {
            double area = ((double)this.base*this.altura)/2;
            System.out.printf("Base %d | Altura %d | Area %.2f\n", this.base,this.altura,area);
        }
    }
}
