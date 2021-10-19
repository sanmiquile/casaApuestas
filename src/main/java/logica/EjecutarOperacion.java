package logica;

import javax.swing.*;
import java.util.Scanner;

public class EjecutarOperacion {



    public static void main(String[] args) {

       //obtenerOpcion();

        menuOperaciones();

    }


    private static String [] obtenerOpcion() {
        String textoOperacion ;

        textoOperacion= JOptionPane.showInputDialog("Ingrese la operación deseada: ");
        String[] palabras = textoOperacion.split(",");

        return palabras;

    }

    private static void menuOperaciones() {

        System.out.println("MENU DE OPERACIONES\n 1. Crear cuenta\n 2.Depositar\n 3.Retirar\n 4.Apostar\n 5.Cancelar Cuenta\n 6.Consultar Saldo\n 7.Cerrar apuesta\n 8.Hacer reporte\n 9.Realizar Sorteo\n 10.Salir\n");
        int opcion=0;

        do {

            System.out.println("Ingrese la opcion deseada: ");
            Scanner lectura = new Scanner (System.in);
             opcion = lectura.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Ingrese su nombre y apellido: ");
                    String nombre = capturarStringConsola();
                    //crearCuenta(nombre);

                    System.out.println("se creo una  cuenta");
                    break;
                case 2: //realizarDeposito(palabras);
                    System.out.println("se realizo un deposito ");
                    break;
                case 3:
                    // realizarRetiro(palabras);
                    System.out.println("se realizo un retiro");
                    break;
                case 4:
                    // realizarApuesta(palabras);
                    System.out.println("realizar apuesta");
                    break;
                case 5:
                    // cancelarCuenta(palabaras);
                    System.out.println("cancelar cuenta");
                    break;
                case 6:
                    // consultarSaldo(palabras);
                    System.out.println("consultar saldo");
                    break;
                case 7:
                    // cerrarApuesta(palabras);
                    System.out.println("cerrar apuesta");
                    break;
                case  8:
                    //realizarReporte;
                    System.out.println("hacer reporte");
                    break;
                case 9:
                     // generarSorteo;
                    System.out.println("Realizando sorteo");
                    break;
                case 10:

                    System.out.println("saliendo");
                    break;

                default:
                    System.out.println("No se encontró la operación");
            }
        }while(opcion !=10);
    }

    public static int capturarIntConsola(){
    int opi=0;
    Scanner lectura = new Scanner (System.in);
    opi = lectura.nextInt();
    return opi;
}
    public static double capturarDoubleConsola(){
        double  opi=0;
        System.out.println("Ingrese su nombre y apellido: ");
        Scanner lectura = new Scanner (System.in);
        opi = lectura.nextDouble();
        return opi;
    }

    public static String capturarStringConsola(){
        String  opi="";
        Scanner lectura = new Scanner (System.in);
        opi = lectura.next();
        return opi;
    }
}
