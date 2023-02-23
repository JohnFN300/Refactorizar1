/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package iesvigan.ets.refactorizar1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Fernando
 */
public class Refactorizar1 {

      public static int primer_turno() {
        int minimo = 1;
        int maximo = 2;
        return (int) Math.floor(Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
    }

    public static String adaptar_nombre(String nombre1, String nombre2, int i1) {
        if (i1 == 1) {
            char letra1 = nombre1.toUpperCase().charAt(0);
            nombre1 = nombre1.substring(1);
            return letra1 + nombre1;
        } else {
            char letra2 = nombre2.toUpperCase().charAt(0);
            nombre2 = nombre2.substring(1);
            return letra2 + nombre2;
        }

    }

    public static boolean comprobar_nombre(String nombre1, String nombre2, int i4) {
        //Recorremos cada caracter de la cadena y comprobamos si son letras.
        //Para comprobarlo, lo pasamos a mayuscula y consultamos su numero ASCII.
        //Si está fuera del rango 65 - 90, es que NO son letras.
        //Para ser más exactos al tratarse del idioma español, tambien comprobamos
        //el valor 165 equivalente a la Ñ
        if (i4 == 1) {
            for (int i = 0; i < nombre1.length(); i++) {
                char caracter = nombre1.toUpperCase().charAt(i);
                int valorASCII = (int) caracter;

                if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90)) {
                    return false; //Se ha encontrado un caracter que no es letra
                }
            }
        } else if (i4 == 2) {
            for (int i = 0; i < nombre2.length(); i++) {
                char caracter2 = nombre2.toUpperCase().charAt(i);
                int valorASCII2 = (int) caracter2;
                if (valorASCII2 != 165 && (valorASCII2 < 65 || valorASCII2 > 90)) {
                    return false; //Se ha encontrado un caracter que no es letra
                }
            }
        }

        //Terminado el bucle sin que se haya retornado false, es que todos los caracteres son letras
        return true;
    }

    public static int numero_aleatorio(int digitos_a_adivinar) {

        Random rnd = new Random();
        if (digitos_a_adivinar == 4) {
            //aqui digito 3 cifras de manera que me cree numeros entre el 0 y el 9 individualmente sin saltar la linea
            for (int i = 0; i < 3; i++) {
                return rnd.nextInt(10);
            }
        } else if (digitos_a_adivinar == 5) {
            //aqui digito 4 cifras de manera que me cree numeros entre el 0 y el 9 individualmente sin saltar la linea
            for (int i = 0; i < 4; i++) {
                return rnd.nextInt(10);
            }
        }
        //como la funcion me obliga a soltar un valor si o si, puse que me creara otro numero aleatorio y que se junte con los demas
        return rnd.nextInt(10);
    }

    public static int cifra(int res1) {

        return (res1 % 10);
    }

    public static String comprobar_tirada(int digito1, int digito2, int digito3, int digito4, int digito5, int num1, int num2, int num3, int num4, int num5, int i, int digitos_a_adivinar) {
        //los digitos van en orden y son los numeros randoms que genera la otra funcion
        //los nums van en orden inverso osea el num5 es el primer numero que ingresa el usuario
        // lo que hago es diferenciar entre numeros y digitos y imprimir el signo que sea conveniente
        if (digito1 == num5 && (i == 1 && digitos_a_adivinar == 5)) {
            return "*";
        } else if (digito1 > num5 && (i == 1 && digitos_a_adivinar == 5)) {
            return ">";
        } else if (digito1 < num5 && (i == 1 && digitos_a_adivinar == 5)) {
            return "<";
        } else if (digitos_a_adivinar == 4) {
            i++;
        }
        if (digito2 == num4 && i == 2) {
            return "*";
        } else if (digito2 > num4 && i == 2) {
            return ">";
        } else if (digito2 < num4 && i == 2) {
            return "<";
        }
        if (digito3 == num3 && i == 3) {
            return "*";
        } else if (digito3 > num3 && i == 3) {
            return ">";
        } else if (digito3 < num3 && i == 3) {
            return "<";
        }
        if (digito4 == num2 && i == 4) {
            return "*";
        } else if (digito4 > num2 && i == 4) {
            return ">";
        } else if (digito4 < num2 && i == 4) {
            return "<";
        }
        if (digito5 == num1 && i == 5) {
            return "*";
        } else if (digito5 > num1 && i == 5) {
            return ">";
        } else if (digito5 < num1 && i == 5) {
            return "<";
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean continua;
        do {
            try {
                continua = false;
                System.out.println("-----------MASTERMIND-----------");
                System.out.println("--------------------------------");
                System.out.println("¿Cuantos digitos vas a adivinar?");
                int digitos_a_adivinar = teclado.nextInt();
                while (digitos_a_adivinar != 4 && digitos_a_adivinar != 5) {
                    System.out.println("Solo puedes adivinar numeros de 4 o 5 cifras\nintroduce de nuevo la cifra que quieras adivinar ");
                    digitos_a_adivinar = teclado.nextInt();
                }
                System.out.println("Escribe el nombre del JUGADOR 1");
                String nombre1 = teclado.next();
                System.out.println("Escribe el nombre del JUGADOR 2");
                String nombre2 = teclado.next();
                int i4 = 1;
                while (!(comprobar_nombre(nombre1, nombre2, i4))) {
                    System.out.println("alguno de los nombres introducidos es incorrecto");
                    System.out.println("Escribe el nombre del JUGADOR 1");
                    nombre1 = teclado.next();
                    System.out.println("Escribe el nombre del JUGADOR 2");
                    nombre2 = teclado.next();
                }
                i4 = 2;
                while (!(comprobar_nombre(nombre1, nombre2, i4))) {
                    System.out.println("alguno de los nombres introducidos es incorrecto");
                    System.out.println("Escribe el nombre del JUGADOR 1");
                    nombre1 = teclado.next();
                    System.out.println("Escribe el nombre del JUGADOR 2");
                    nombre2 = teclado.next();
                }
                int i1 = 1;
                //el adaptar nombre lo cree con la variable i1 lo que significa que si i1 es 1 se refiere al jugador1, y si en tal caso que i1 fuese 2 se refiere al jugador 2
                System.out.println("Bienvenido " + adaptar_nombre(nombre1, nombre2, i1));
                i1 = 2;
                System.out.println("Bienvenido " + adaptar_nombre(nombre1, nombre2, i1));
                System.out.println("--------------------------------");
                int digito1 = numero_aleatorio(digitos_a_adivinar);
                int digito2 = numero_aleatorio(digitos_a_adivinar);
                int digito3 = numero_aleatorio(digitos_a_adivinar);
                int digito4 = numero_aleatorio(digitos_a_adivinar);
                int digito5 = numero_aleatorio(digitos_a_adivinar);
                int turno = primer_turno();
                System.out.println("Ahora intenta adivinar el numero");
                //Dentro del for hay 2 turnos, uno para cada jugador... este se repitira 5 veces para darle 5 oportunidades a cada uno, el for se acaba si no completan el juego en 5 intentos
                for (int i3 = 0; i3 < 5; i3++) {
                    if (turno == 1) {
                        i1 = 1;
                        System.out.println("Le toca al jugador " + adaptar_nombre(nombre1, nombre2, i1));
                    } else {
                        i1 = 2;
                        System.out.println("Le toca al jugador " + adaptar_nombre(nombre1, nombre2, i1));
                    }
                    //esto es para recibir los numeros de manera individual y guardarlo cada uno en una variable
                    int res1 = teclado.nextInt();
                    int num1 = cifra(res1);
                    res1 = res1 / 10;
                    int num2 = cifra(res1);
                    res1 = res1 / 10;
                    int num3 = cifra(res1);
                    res1 = res1 / 10;
                    int num4 = cifra(res1);
                    res1 = res1 / 10;
                    int num5 = cifra(res1);
                    String signo1 = "", signo2 = "", signo3 = "", signo4 = "", signo5 = "";

                    if (digitos_a_adivinar == 5) {
                        System.out.println("los numeros introducidos separados son " + num5 + "-" + num4 + "-" + num3 + "-" + num2 + "-" + num1);
                    } else {
                        System.out.println("los numeros introducidos separados son " + num4 + "-" + num3 + "-" + num2 + "-" + num1);
                    }
                    //esto switch es para comparar los digitos aleatorios con los numeros introducidos y va imprimiendo el signo <> o * segun corresponda
                    for (int i = 1; i < 6; i++) {
                        switch (i) {
                            case 1:
                                signo1 = comprobar_tirada(digito1, digito2, digito3, digito4, digito5, num1, num2, num3, num4, num5, i, digitos_a_adivinar);
                                break;
                            case 2:
                                signo2 = comprobar_tirada(digito1, digito2, digito3, digito4, digito5, num1, num2, num3, num4, num5, i, digitos_a_adivinar);
                                break;
                            case 3:
                                signo3 = comprobar_tirada(digito1, digito2, digito3, digito4, digito5, num1, num2, num3, num4, num5, i, digitos_a_adivinar);
                                break;
                            case 4:
                                signo4 = comprobar_tirada(digito1, digito2, digito3, digito4, digito5, num1, num2, num3, num4, num5, i, digitos_a_adivinar);
                                break;
                            case 5:
                                signo5 = comprobar_tirada(digito1, digito2, digito3, digito4, digito5, num1, num2, num3, num4, num5, i, digitos_a_adivinar);
                                break;
                            default:
                                i = 1;
                                break;
                        }

                    }
                    //a continuacion esta el codigo para 5 y 4 digitos, con un if para indicar que hacer en cada caso
                    if (digitos_a_adivinar == 5) {
                        System.out.println("\n" + signo1 + "" + signo2 + "" + signo3 + "" + signo4 + "" + signo5);
                        if ("*".equals(signo1) && "*".equals(signo2) && "*".equals(signo3) && "*".equals(signo4) && "*".equals(signo5)) {
                            if (turno == 1) {
                                i1 = 1;
                                System.out.println("Ha ganado " + adaptar_nombre(nombre1, nombre2, i1));
                                break;
                            }

                        }
                    } else if (digitos_a_adivinar == 4) {
                        System.out.println("\n" + signo1 + "" + signo2 + "" + signo3 + "" + signo4);
                        if ("*".equals(signo1) && "*".equals(signo2) && "*".equals(signo3) && "*".equals(signo4)) {
                            if (turno == 1) {
                                i1 = 1;
                                System.out.println("Ha ganado " + adaptar_nombre(nombre1, nombre2, i1));
                                break;
                            }
                        }

                    }
                    if (("*".equals(signo1) && "*".equals(signo2) && "*".equals(signo3) && "*".equals(signo4) && "*".equals(signo5)) || ("*".equals(signo1) && "*".equals(signo2) && "*".equals(signo3) && "*".equals(signo4))) {
                        i1 = 1;
                        System.out.println("Ha ganado " + adaptar_nombre(nombre1, nombre2, i1));
                        break;
                        //el siguiente codigo es la copia para que pueda jugar el segundo jugador, es lo mismo que arriba
                    } else {
                        if (turno == 1) {
                            i1 = 2;
                            System.out.println("Le toca al jugador " + adaptar_nombre(nombre1, nombre2, i1));
                        } else if (turno == 2) {
                            i1 = 1;
                            System.out.println("Le toca al jugador " + adaptar_nombre(nombre1, nombre2, i1));
                        }
                        res1 = teclado.nextInt();
                        num1 = cifra(res1);
                        res1 = res1 / 10;
                        num2 = cifra(res1);
                        res1 = res1 / 10;
                        num3 = cifra(res1);
                        res1 = res1 / 10;
                        num4 = cifra(res1);
                        res1 = res1 / 10;
                        num5 = cifra(res1);
                        signo1 = "";
                        signo2 = "";
                        signo3 = "";
                        signo4 = "";
                        signo5 = "";
                        if (digitos_a_adivinar == 5) {
                            System.out.println("los numeros introducidos separados son " + num5 + "-" + num4 + "-" + num3 + "-" + num2 + "-" + num1);
                        } else {
                            System.out.println("los numeros introducidos separados son " + num4 + "-" + num3 + "-" + num2 + "-" + num1);
                        }
                        for (int i = 1; i < 6; i++) {
                            switch (i) {
                                case 1:
                                    signo1 = comprobar_tirada(digito1, digito2, digito3, digito4, digito5, num1, num2, num3, num4, num5, i, digitos_a_adivinar);
                                    break;
                                case 2:
                                    signo2 = comprobar_tirada(digito1, digito2, digito3, digito4, digito5, num1, num2, num3, num4, num5, i, digitos_a_adivinar);
                                    break;
                                case 3:
                                    signo3 = comprobar_tirada(digito1, digito2, digito3, digito4, digito5, num1, num2, num3, num4, num5, i, digitos_a_adivinar);
                                    break;
                                case 4:
                                    signo4 = comprobar_tirada(digito1, digito2, digito3, digito4, digito5, num1, num2, num3, num4, num5, i, digitos_a_adivinar);
                                    break;
                                case 5:
                                    signo5 = comprobar_tirada(digito1, digito2, digito3, digito4, digito5, num1, num2, num3, num4, num5, i, digitos_a_adivinar);
                                    break;
                                default:
                                    i = 1;
                                    break;
                            }

                        }
                        if (digitos_a_adivinar == 5) {
                            System.out.println("\n" + signo1 + "" + signo2 + "" + signo3 + "" + signo4 + "" + signo5);
                            if ("*".equals(signo1) && ("*".equals(signo2) && "*".equals(signo3) && "*".equals(signo4) && "*".equals(signo5))) {
                                if (turno == 1) {
                                    i1 = 2;
                                    System.out.println("ha ganado " + adaptar_nombre(nombre1, nombre2, i1));
                                    break;
                                } else if (turno == 2) {
                                    i1 = 1;
                                    System.out.println("ha ganado " + adaptar_nombre(nombre1, nombre2, i1));
                                    break;
                                }

                            }
                        } else if (digitos_a_adivinar == 4) {
                            System.out.println("\n" + signo1 + "" + signo2 + "" + signo3 + "" + signo4);
                            if ("*".equals(signo1) && ("*".equals(signo2) && "*".equals(signo3) && "*".equals(signo4))) {
                                if (turno == 1) {
                                    i1 = 2;
                                    System.out.println("ha ganado " + adaptar_nombre(nombre1, nombre2, i1));
                                    break;
                                } else if (turno == 2) {
                                    i1 = 1;
                                    System.out.println("ha ganado " + adaptar_nombre(nombre1, nombre2, i1));
                                    break;
                                }
                            }

                        }
                    }
                    if (i3 == 4) {
                        System.out.println("Se han alcanzado los intentos maximos");
                    }
                }
            } catch (InputMismatchException ex) {
                System.out.println("Debe ingresar obligatoriamente un número entero.");
                teclado.next();
                continua = true;
            }
        } while (continua);
    }

}
