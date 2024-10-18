package ejerciciopizzeria;

import java.util.Scanner;

/**
 *
 * @author CrisGC
 */
public class EjercicioPizzeria {

    static Scanner kin = new Scanner(System.in);

    public static void main(String[] args) {
        //Parametros
        Cola<Pizza> pizzeria = new Cola<>(5);
        Pizza pizza;
        int opcion, cantPizzas, pizzasBordeRelleno = 0;

        //Bucle de ejecucion, finaliza cuando "opcion" = 0
        do {
            //Muestra el menu y solicita una opcion
            opcion = menu();

            switch (opcion) {
                case 1 -> //Inserta una pizza en el horno
                    System.out.println((pizzeria.push(elegirPizza()))
                            ? "La pizza esta en el horno" : "El horno está lleno");//Respuesta

                case 2 -> {//Muestra el % de pizzas con bordes rellenos
                    pizzasBordeRelleno = 0;
                    cantPizzas = pizzeria.getNumElementos();
                    for (int i = 1; i <= cantPizzas; i++) {
                        pizza = pizzeria.pop();
                        if (pizza instanceof Clasica clasica) {
                            if (clasica.isBordeRelleno()) {
                                pizzasBordeRelleno++;
                            }
                        }
                        pizzeria.push(pizza);
                    }
                    
                    //Respuesta
                    if (cantPizzas > 0) {
                        System.out.printf("El %.2f de las pizzas tienen bordes rellenos", (pizzasBordeRelleno * 100.0 / cantPizzas));
                    } else {
                        System.out.println("No hay pizza con bordes rellenos");
                    }
                }
                
                case 3 -> {//Hornea las pizzas, prioriza los calzones antes del resto
                    //Identifica y hornea calzones
                    cantPizzas = pizzeria.getNumElementos();
                    for (int i = 1; i <= cantPizzas; i++) {
                        pizza = pizzeria.pop();
                        if (pizza instanceof Calzone) {
                            System.out.println(pizza.toString());
                            hornear(pizza);
                        } else {
                            pizzeria.push(pizza);
                        }
                    }
                    
                    //Hornear el resto
                    cantPizzas = pizzeria.getNumElementos();
                    for (int i = 1; i <= cantPizzas; i++) {
                        pizza = pizzeria.pop();
                        System.out.println(pizza.toString());
                        hornear(pizza);
                    }
                }
            }
        } while (opcion != 0);
    }

    public static int menu() {
        int opcion = 0;

        do {
            System.out.println("""
                            
                            ___MENU___
                           1.- Pedir una pizza
                           2.- Cantidad de pizzas con bordes rellenos
                           3.- Encender el horno
                           0.- Salir""");
            opcion = kin.nextInt();
        } while ((opcion < 0) || (opcion > 3));
        
        return opcion;
    }

    private static Pizza elegirPizza() {
        //Parametros
        double precio;
        int segundosHorno, tipoPizza;
        char letra;
        boolean borde;
        Pizza pizza;

        //Atributos solicitados por escaner
        System.out.print("Indica el precio: ");
        precio = kin.nextDouble();
        System.out.print("Indica los segundos de coccion: ");
        segundosHorno = kin.nextInt();
        
        do {//Elegir tipo de pizza
            System.out.print("Indique si es Clasica [1] o Calzone [2]: ");
            tipoPizza = kin.nextInt();
        } while ((tipoPizza < 1) || (tipoPizza > 2));
        
        if (tipoPizza == 1) {
            do {//Solicita el parametro extra de Pizza Clasica
                System.out.print("Indique si quiere el borde relleno con queso [S/N]: ");
                letra = kin.next().toUpperCase().charAt(0);
            } while ((letra != 'S') && (letra != 'N'));
            borde = (letra == 'S');
            pizza = new Clasica(segundosHorno, precio, borde);
        } else {
            pizza = new Calzone(segundosHorno, precio);
        }

        return pizza;
    }

    private static void hornear(Pizza pizza) {
        try {
            Thread.sleep(pizza.getSegundosCoccion() * 1000);
        } catch (InterruptedException ex) {
        }
    }
}
