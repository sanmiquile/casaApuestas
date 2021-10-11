package logica;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Locale;

public class EjecutarOperacion {



    public static void main(String[] args) {

        buscarOperacion();

    }

    private static void buscarOperacion() {

        String operacion;
       boolean centinela =true;

        do {

            operacion= obtenerOpcion();


            switch (operacion){
                case "CREAR_CUENTA":
                    //crearCuenta();
                    System.out.println("crear cuenta");
                    break;
                case "DEPOSITAR":
                    System.out.println("Depositar valor");
                    break;
                case "RETIRAR":

                    System.out.println("Retirar valor");
                    break;
                case "APOSTAR":

                    System.out.println("realizar apuesta");
                    break;
                case "CANCELAR":

                    System.out.println("cancelar cuenta");
                    break;
                case "CONSULTAR_SALDO":

                    System.out.println("consultar saldo");
                    break;
                case "CERRAR":

                    System.out.println("cerrar apuesta");
                    break;
                case  "REPORTAR":

                    System.out.println("hacer reporte");
                    break;
                case "SORTEO":

                    System.out.println("Realizando sorteo");
                    break;
                case "SALIR": centinela= false;

                    System.out.println("saliendo");
                    break;

                default:
                    System.out.println("No se encontró la operación");
            }
        }while(centinela );
    }

    private static String obtenerOpcion() {
        String textoOperacion;

        textoOperacion= JOptionPane.showInputDialog("Ingrese la operación deseada: ");
        String[] palabras = textoOperacion.split(",");

        return palabras[0].toUpperCase();

    }


}
