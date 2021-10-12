package logica;

import javax.swing.*;

public class EjecutarOperacion {



    public static void main(String[] args) {

        buscarOperacion();

    }


    private static String [] obtenerOpcion() {
        String textoOperacion ;

        textoOperacion= JOptionPane.showInputDialog("Ingrese la operación deseada: ");
        String[] palabras = textoOperacion.split(",");

        return palabras;

    }

    private static void buscarOperacion() {

        String[] operacion;
       boolean centinela =true;

        do {

            operacion= obtenerOpcion();


            switch (operacion[0]){
                case "CREAR_CUENTA":
                    //crearCuenta();
                    System.out.println("se creo una  cuenta");
                    break;
                case "DEPOSITAR":
                    System.out.println("se realizo un deposito ");
                    break;
                case "RETIRAR":

                    System.out.println("se realizo un retiro");
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




}
