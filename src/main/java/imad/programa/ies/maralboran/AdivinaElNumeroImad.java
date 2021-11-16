/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imad.programa.ies.maralboran;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author imad
 */
public class AdivinaElNumeroImad {

    private static Random aleatorio = new Random();
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int numeroIntentosUsuario;
        int numMin = 0, numMax = 0;
        int numeroIntroducidoPorUsuario;
        int numeroGeneradoAleatorio = 0;
        String opcion = "";
        boolean controlIntroduccionCorrecta = true;
        do {

            mostrarMenu();
            opcion = teclado.nextLine();
            switch (opcion) {
                case "1":
               do{    
                    try{
                    System.out.println("Introduce el rango minimo con el que quiere jugar");
                    numMin = ComprobadorIntroduccionInt();
                    System.out.println("Introduce el rango maximo con el que quiere jugar");
                    numMax = ComprobadorIntroduccionInt();
                    numeroGeneradoAleatorio = generadorNumeroAleatorioEntreDosRangos(numMin,numMax);
                    controlIntroduccionCorrecta = false;
                     }catch(IllegalArgumentException IAE){
                        System.out.println("Vuelve a introducir los datos, asegurate de que el numero minimo\n "
                                + "no puede ser mayor que el numero maximo");
                        controlIntroduccionCorrecta = true;
                    }
               }while(controlIntroduccionCorrecta);    
                    System.out.println("¿Cuantos intentos necesita?");
                    numeroIntentosUsuario = ComprobadorIntroduccionInt();
                    do{
                        System.out.println("numero es: "+numeroGeneradoAleatorio);
                        System.out.println("Usted tiene "+numeroIntentosUsuario+ " vidas");
                        System.out.println("¿Qué numero es?");
                        numeroIntroducidoPorUsuario = ComprobadorIntroduccionInt();
                        if(numeroIntroducidoPorUsuario>numeroGeneradoAleatorio){
                            --numeroIntentosUsuario;
                            System.out.println("El numero a adivinar es menor");
                        }else if(numeroIntroducidoPorUsuario<numeroGeneradoAleatorio){
                          --numeroIntentosUsuario;
                            System.out.println("El numero  a adivinar es mayor");
                        }else{
                            System.out.println("Enorahbuena!!");
                            break;
                        }
                        teclado.nextLine();
                    }while(numeroIntentosUsuario !=0);
                    System.out.println("el numero es: "+numeroGeneradoAleatorio);
                    break;
                case "2":
                    break;
                default:
                    System.out.println("Opción no válida");
                }
                } while (!opcion.equals("2"));
            }

    // Método monstrarMenu. Sólo se utiliza en la clase AdivinaElNumeroImad
    // método privado. No recibe parámetros y no devuelve valor (void)
    private static void mostrarMenu() {
        System.out.println("Bienvenido al programa\n"
                + "1.- Pulse 1 para jugar\n"
                + "2.- Pulse 2 para salir");

    }

    // Método generadorNumeroAleatorioEntreDosRangos. Sólo se utiliza en la clase AdivinaElNumeroImad
    // método privado. recibe dos parámetros y  devuelve valor generado aleatroiamente entre los dos parametros recibidos
    private static int generadorNumeroAleatorioEntreDosRangos(int RANGO_MIN, int RANGO_MAX) {
        int numeroGeneradoAleatorio;
        numeroGeneradoAleatorio = aleatorio.nextInt(RANGO_MAX - RANGO_MIN + 1) + RANGO_MIN;
        return numeroGeneradoAleatorio;
    }

    //metodo que utilizamos para introduir un numer entro y comprueba si es valido, si lo es lo devuelve
    private static int ComprobadorIntroduccionInt() {
        int numeroIntroducido = 0;
        boolean repeticion = false;
        do {
            try {
                numeroIntroducido = teclado.nextInt();
                repeticion = false;
            } catch (InputMismatchException ime) {
                repeticion = true;
                // Código para tratar el error
                System.out.println("Se ha introducido texto en lugar de números. "
                        + "Vuelva a introducir los datos");
                teclado.nextLine();
            }
        } while (repeticion);
        return numeroIntroducido;

    }
}
