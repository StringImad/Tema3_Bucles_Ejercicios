/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imad.programa.ies.maralboran;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author imad
 */
public class NumerosPrimos {

    public static void main(String[] args) {
        //1.- Numero primo se meta por teclado o lo genere el programa 
        //    Rango de numero generado estara entre 2 y 600_000_000
        //2.- Si el numero N es par no es primo excepto 2, Recorrer todo el rango de impares
        //    desde 3 hasta N/2.
        //declaracion variables
        int numeroAComprobar;
        int eleccion = 0;
        final int RANGO_MAX = 600_000_000;
        final int RANGO_MIN = 2;

        boolean repeticion = true;
        //Declaracion de objetos
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();
        //Bucle de repeticion del programa se repite hasta que el usuario le de a salir
        do {
            //Bucle do que asegura la introduccion correcta de los datos del menu
            do {
                System.out.println("Elige una de las opciones del menu\n1.- manual\n"
                        + "2.- Aleatorio\n"
                        + "3.- Salir");
                eleccion = teclado.nextInt();
            } while (eleccion < 1 || eleccion > 3);
            switch (eleccion) {
                case 1:
                    do {
                        System.out.println("Introduce un numero para comprobar entre (2 y 600 000 000)");
                        numeroAComprobar = teclado.nextInt();
                    } while (numeroAComprobar < RANGO_MIN || numeroAComprobar > RANGO_MAX);
                    System.out.println(comprobadorPrimos(numeroAComprobar));
                    break;
                case 2:
                    numeroAComprobar = aleatorio.nextInt(RANGO_MAX - RANGO_MIN + 1) + RANGO_MIN;
                    System.out.println("Numero aleatorio generado es: " + numeroAComprobar);
                    System.out.println(comprobadorPrimos(numeroAComprobar));
                    break;
                case 3:
                    repeticion = false;
                    break;
            }

        } while (repeticion);
    }

    //Metodo que recibe un numero entero y devuleve si es primo o no
    public static String comprobadorPrimos(int numeroRecibido) {
        String respuestaPrimo;
        int divisorNoPrimo = 0;
        int contador = 0;

        //Si el resto del numero dividio entre 2 es distinto a 0 o es igual a 2
        //significa que el numero es primo
        for (int i = numeroRecibido; i > 0; i--) {
            if (numeroRecibido % i == 0) {
                contador++;
            }
        }

        if (contador == 2) {

            respuestaPrimo = "Numero primo";
        } else {

//            for (int i = 0; i < numeroRecibido; i++) {
//                if (numeroRecibido / i == 0) {
//                    divisorNoPrimo = i;
//                }
//            }
            respuestaPrimo = "Numero no primo";

        }

        return respuestaPrimo;
    }
}
