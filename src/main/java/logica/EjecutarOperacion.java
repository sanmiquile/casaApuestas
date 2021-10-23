package logica;

import java.util.Scanner;

import static logica.CasaApuesta.crearCuenta;

public class EjecutarOperacion {



    public static void main(String[] args) {



        menuCliente();

    }


    private static void menuCliente() {

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
                    String mensajeAlServidor= "CREAR_CUENTA,"+nombre;
                    System.out.println("Mensaje al servidor: "+mensajeAlServidor);
                    mandarMensaje(mensajeAlServidor);

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

    private static void mandarMensaje(String mensajeAlServidor) {

        String[] palabras = mensajeAlServidor.split(",");
        String metodo=palabras[0].trim().toUpperCase();


                switch (metodo){
                    case "CREAR_CUENTA":
                        String nombre=palabras[1].trim().toUpperCase();
                        String cuenta= crearCuenta(nombre);
                        System.out.println("se creó una  cuenta"+cuenta);
                        break;

                    default:
                        System.out.println("No se encontró la operación");
                }
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
        opi = lectura.nextLine();
        System.out.println ("Entrada recibida por teclado es: \"" + opi +"\"");
        return opi;
    }

}
