package logica;

import javax.swing.*;

public class EjecutarOperacion {



    public static void main(String[] args) {


       menuOperaciones();

    }


  //  private static String [] obtenerOpcion() {
      //  String textoOperacion ;

        //textoOperacion= JOptionPane.showInputDialog("Ingrese la operación deseada: ");
        //String[] palabras = textoOperacion.split(",");

        //return palabras;

    //}

    private static void menuOperaciones() {
        int opcion = 0;
        System.out.println("INGRESE LA OPERACION QUE DESEA REALIZAR \n 1. Crear cuenta\n 2.Depositar\n 3.Retirar\n 4.Apostar\n 5.Cancelar Cuenta\n 6.Consultar Saldo\n 7.Cerrar apuesta\n 8.Hacer reporte\n 9.Realizar Sorteo\n 10.Salir\n");

        do {
            opcion= Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion deseada",opcion));
            switch (opcion){
                case 1:
                    //crearCuenta();
                    System.out.println("se creo una  cuenta");
                    break;
                case 2: //realizarDeposito();
                    System.out.println("se realizo un deposito ");
                    break;
                case 3:
                    // realizarRetiro();
                    System.out.println("se realizo un retiro");
                    break;
                case 4:
                    // realizarApuesta();
                    System.out.println("realizar apuesta");
                    break;
                case 5:
                    // cancelarCuenta();
                    System.out.println("cancelar cuenta");
                    break;
                case 6:
                    // consultarSaldo();
                    System.out.println("consultar saldo");
                    break;
                case 7:
                    // cerrarApuesta();
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




}
