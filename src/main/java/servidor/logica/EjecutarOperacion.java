package servidor.logica;

import servidor.logica.operaciones.*;

import java.io.BufferedReader;
import java.io.PrintWriter;


public class EjecutarOperacion {


    public static void main(String[] args) {


     //   menuCliente();
        EjecutarOperacion ejecutarOperacion = new EjecutarOperacion();
//        System.out.println(ejecutarOperacion.ejecutar("CREAR_CUENTA,Juan Salgado", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("CREAR_CUENTA,Juan Salgado", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("CREAR_CUENTA, Andres Serna", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("DEPOSITAR, 1, 50000", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("DEPOSITAR, 3, 50000", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("DEPOSITAR, 1, -50000", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("RETIRAR, 2, 50000 ", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("RETIRAR, 1, 10000 ", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("CANCELAR_CUENTA,3", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("CANCELAR_CUENTA,1", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("CANCELAR_CUENTA,2", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("CANCELAR_CUENTA", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("REGISTRAR_APUESTA, 1, A, 3258", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("REGISTRAR_APUESTA, 1, B, 3258", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("REGISTRAR_APUESTA, 1, C, 3258", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("REGISTRAR_APUESTA, 1, A, 325", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("REGISTRAR_APUESTA, 1, B, 32", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("REGISTRAR_APUESTA, 1, C, 3", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("REGISTRAR_APUESTA, 1, A, 1325", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("REGISTRAR_APUESTA, 1, B, 132", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("REGISTRAR_APUESTA, 1, C, 13", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("CERRAR", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("CERRAR", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("REGISTRAR_APUESTA, 1, C, 13", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("REPORTAR", salida, entrada));
//        System.out.println(ejecutarOperacion.ejecutar("SORTEO,3258", salida, entrada));

    }

    public String ejecutar(String mensajeAlServidor, PrintWriter salida, BufferedReader entrada) {

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

            case "CANCELAR_CUENTA":
            case "CANCELAR":
                operacion=new CancelarCuenta();
                break;
            case "REGISTRAR_APUESTA":
            case "APOSTAR":
                operacion= new RegistrarApuesta();
                break;
            case "CONSULTAR_SALDO":
                operacion= new ConsultarSaldo();
                break;
            case "CERRAR":
                operacion= new Cerrar();
                break;
            case "REPORTAR":
                operacion= new Reportar();
                break;
            case "SORTEO":

                operacion=new Sortear();
                break;

            default:
                return "No se encontró la operación";


        }
        return operacion.ejecutar(parametros,salida,entrada);
    }

}
