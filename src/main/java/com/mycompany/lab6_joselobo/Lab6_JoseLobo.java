package com.mycompany.lab6_joselobo;

import java.util.Scanner;

/**
 *
 * @author JoseLobo
 */
public class Lab6_JoseLobo {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("Menu");
            System.out.println("1-->Turing");
            System.out.println("2-->Constante de Kaprekar");
            System.out.println("3-->Salir");
            System.out.println("Ingrese la opcion: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1 -> {
                    int tam;
                    do {
                        System.out.println("Ingrese el tamaño del arreglo: ");
                        tam = leer.nextInt();
                        if (tam <= 1) {
                            System.out.println("Dato Invalido");
                        }
                    } while (tam <= 1);
                    int[] generado = new int[tam];
                    generado = arrayrandom(tam);
                    System.out.println("R: Mueva el puntero una casilla a la derecha");
                    System.out.println("L: Mueva el puntero una casilla a la izquierda");
                    System.out.println("X: Agruegue el elemento al que está apuntando el apuntador a la cadena final");
                    System.out.println("Ingrese su cadena de instrucciones: ");
                    String instrucciones = leer.next().toUpperCase();
                    String resultado = ejercicio1(generado, instrucciones);
                    System.out.println("Original: ");
                    imprimir(generado);
                    System.out.println("Resultado");
                    System.out.println(resultado);
                }//case 1
                case 2 -> {
                    boolean test;
                    int num;
                    do {
                        System.out.println("Ingrese un numero de 4 cifras(no deben ser los 4 igual): ");
                        num = leer.nextInt();
                        test = cuatronoigual(num);
                        if (test == false) {
                            System.out.println("Dato invalido");
                        }//if false
                    } while (test == false);
                    ejercicio2(num);

                }//case 2
                case 3 -> {
                    System.out.println("Saliendo...");
                }//case 3
                default -> {
                    System.out.println("Opcion Invalida");
                }//defult
            }//switch
        } while (opcion != 3);
    }//main

    public static int[] arrayrandom(int tam) {
        int[] temp = new int[tam];
        for (int i = 0; i < tam; i++) {
            temp[i] = (int) (Math.random() * (10));
        }
        return temp;
    }//arrayrandom

    public static void imprimir(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print("[" + a[i] + "]");
        }//for
        System.out.println();
    }//imprimir

    public static String ejercicio1(int[] a, String instru) {
        int k = 0;
        String temporal = "";
        for (int i = 0; i < instru.length(); i++) {
            char letra = instru.charAt(i);
            switch (letra) {
                case 'R' -> {
                    k++;
                }//case R
                case 'L' -> {
                    k--;
                }//Case L
                case 'X' -> {
                    temporal += Si_X(k, a);
                }//Case X
                default -> {
                    System.out.println("Instruccion Invalida, orden Ignorado");
                }//default
            }//switch
        }//for
        String test = temporal;
        for (int i = 0; i < test.length(); i++) {
            char test2 = test.charAt(i);
            if (test2 == 'Q') {
                temporal = "No es valido";
            }
        }//for
        return temporal;
    }//ejercicion 1

    public static char Si_X(int k, int[] a) {
        char temp = 'Q';
        if (k >= a.length || k < 0) {
            System.out.println("Sus instrucciones son invalidas");
        } else {
            temp = (char) (a[k] + 48);
        }
        return temp;
    }//Si_X

    public static int char_num(char a) {
        String cadena = String.valueOf(a);
        int temp = Integer.parseInt(cadena);
        return temp;
    }//char_num

    public static boolean cuatronoigual(int num) {
        boolean temp = true;
        String numstring = String.valueOf(num);
        if (numstring.length() != 4) {
            temp = false;
        }//temp 
        if (temp == true) {
            int[] res = dijitos(num);
            if (res[0] == res[1] && res[1] == res[2] && res[2] == res[3]) {
                temp = false;
            }
        }//igual?
        return temp;
    }//cuatronoigual

    public static int[] dijitos(int num) {
        int[] res = new int[4];
        for (int i = 3; i >= 0; i--) {
            res[i] = num % 10;
            num /= 10;
        }//for
        return res;
    }//dijitos

    public static int[] menormayor(int[] base) {
        int[] temp = new int[base.length];
        for (int i = 0; i < base.length; i++) {
            int a = 10, b, cambiar = 0;
            for (int k = 0; k < base.length; k++) {
                b = base[k];
                if (b <= a) {
                    a = b;
                    cambiar = k;
                }
            }//for k
            base[cambiar] = 11;
            temp[i] = a;
        }//for 
        return temp;
    }//mayormenor

    public static int[] mayormenor(int[] base) {
        int[] temp = new int[base.length];
        base = menormayor(base);
        for (int i = base.length - 1, k = 0; i >= 0; i--, k++) {
            temp[k] = base[i];
        }
        return temp;
    }//mayormenor

    public static int array_num(int[] base) {
        String stringnum = "";
        for (int i = 0; i < base.length; i++) {
            stringnum += String.valueOf(base[i]);
        }//for
        int temp = Integer.parseInt(stringnum);
        return temp;
    }//array_num

    public static void ejercicio2(int num) {
        int c = num;
        do{
        int a =array_num(mayormenor(dijitos(c)));
        int b =array_num(menormayor(dijitos(c)));
        c = a-b;
        System.out.println(a+" - "+b+" = "+c);
        }while(c!=6174);
    }//ejercicio 2
}//class
