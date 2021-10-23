package logica;

import logica.operaciones.CrearCuenta;
import logica.operaciones.Despositar;
import logica.operaciones.Operacion;
import logica.operaciones.Retirar;

import java.util.Scanner;


public class EjecutarOperacion {


    public static void main(String[] args) {


     //   menuCliente();
        EjecutarOperacion ejecutarOperacion = new EjecutarOperacion();
        System.out.println(ejecutarOperacion.mandarMensaje("CREAR_CUENTA,Juan Salgado"));
        System.out.println(ejecutarOperacion.mandarMensaje("CREAR_CUENTA,Juan Salgado"));
        System.out.println(ejecutarOperacion.mandarMensaje("CREAR_CUENTA, Andres Serna"));
        System.out.println(ejecutarOperacion.mandarMensaje("DEPOSITAR, 1, 50000"));
        System.out.println(ejecutarOperacion.mandarMensaje("DEPOSITAR, 3, 50000"));
        System.out.println(ejecutarOperacion.mandarMensaje("DEPOSITAR, 1, -50000"));
        System.out.println(ejecutarOperacion.mandarMensaje("RETIRAR, 2, 50000 "));
        System.out.println(ejecutarOperacion.mandarMensaje("RETIRAR, 1, 50000 "));

    }


    private void menuCliente() {

        System.out.println("MENU DE OPERACIONES\n 1. Crear cuenta\n 2.Depositar\n 3.Retirar\n 4.Apostar\n 5.Cancelar Cuenta\n 6.Consultar Saldo\n 7.Cerrar apuesta\n 8.Hacer reporte\n 9.Realizar Sorteo\n 10.Salir\n");
        int opcion = 0;

        do {

            System.out.println("Ingrese la opcion deseada: ");
            Scanner lectura = new Scanner(System.in);
            opcion = lectura.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese su nombre y apellido: ");
                    String nombre = capturarStringConsola();
                    String mensajeAlServidor = "CREAR_CUENTA," + nombre;
                    System.out.println("Mensaje al servidor: " + mensajeAlServidor);
                    mandarMensaje(mensajeAlServidor);

                    break;
                case 2: //realizarDeposito(palabras);
                    System.out.println("Ingrese la cuenta a depositar");
                    String cuenta = capturarStringConsola();
                    System.out.println("Ingrese el saldo a depositar");
                    String deposito = capturarStringConsola();
                    String mensajeAlServidor2 = "DEPOSITAR," + cuenta + "," + deposito;
                    System.out.println("Mensaje al servidor: " + mensajeAlServidor2);
                    mandarMensaje(mensajeAlServidor2);
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
                case 8:
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
        } while (opcion != 10);
    }



    private String mandarMensaje(String mensajeAlServidor) {

        String[] parametros = mensajeAlServidor.split(",");
        String metodo = parametros[0].trim().toUpperCase();
        Operacion operacion;
        switch (metodo) {
            case "CREAR_CUENTA":
                operacion = new CrearCuenta();
                break;
            case "DEPOSITAR":
                operacion = new Despositar();
                break;

            case "RETIRAR":
                operacion = new Retirar();
                break;
            default:
                return "No se encontró la operación";
        }
        return operacion.ejecutar(parametros);
    }


    public static int capturarIntConsola() {
        int opi = 0;
        Scanner lectura = new Scanner(System.in);
        opi = lectura.nextInt();
        return opi;
    }

    public static double capturarDoubleConsola() {
        double opi = 0;
        System.out.println("Ingrese su nombre y apellido: ");
        Scanner lectura = new Scanner(System.in);
        opi = lectura.nextDouble();
        return opi;
    }

    public static String capturarStringConsola() {
        String opi = "";
        Scanner lectura = new Scanner(System.in);
        opi = lectura.nextLine();
        System.out.println("Entrada recibida por teclado es: \"" + opi + "\"");
        return opi;
    }

}
