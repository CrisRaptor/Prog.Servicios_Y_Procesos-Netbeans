package ejconcurrencia1;

public class EjConcurrencia1 {

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new Incrementador().start();
        }
    }
    
}
