package logica;

import logica.operaciones.*;

import java.util.Scanner;


public class EjecutarOperacion {


    public static void main(String[] args) {


     //   menuCliente();
        EjecutarOperacion ejecutarOperacion = new EjecutarOperacion();
        System.out.println(ejecutarOperacion.ejecutar("CREAR_CUENTA,Juan Salgado"));
        System.out.println(ejecutarOperacion.ejecutar("CREAR_CUENTA,Juan Salgado"));
        System.out.println(ejecutarOperacion.ejecutar("CREAR_CUENTA, Andres Serna"));
        System.out.println(ejecutarOperacion.ejecutar("DEPOSITAR, 1, 50000"));
        System.out.println(ejecutarOperacion.ejecutar("DEPOSITAR, 3, 50000"));
        System.out.println(ejecutarOperacion.ejecutar("DEPOSITAR, 1, -50000"));
        System.out.println(ejecutarOperacion.ejecutar("RETIRAR, 2, 50000 "));
        System.out.println(ejecutarOperacion.ejecutar("RETIRAR, 1, 10000 "));
        System.out.println(ejecutarOperacion.ejecutar("CANCELAR_CUENTA,3"));
        System.out.println(ejecutarOperacion.ejecutar("CANCELAR_CUENTA,1"));
        System.out.println(ejecutarOperacion.ejecutar("CANCELAR_CUENTA,2"));
        System.out.println(ejecutarOperacion.ejecutar("CANCELAR_CUENTA"));
        System.out.println(ejecutarOperacion.ejecutar("REGISTRAR_APUESTA, 1, A, 3258"));
        System.out.println(ejecutarOperacion.ejecutar("REGISTRAR_APUESTA, 1, B, 3258"));
        System.out.println(ejecutarOperacion.ejecutar("REGISTRAR_APUESTA, 1, C, 3258"));
        System.out.println(ejecutarOperacion.ejecutar("REGISTRAR_APUESTA, 1, A, 325"));
        System.out.println(ejecutarOperacion.ejecutar("REGISTRAR_APUESTA, 1, B, 32"));
        System.out.println(ejecutarOperacion.ejecutar("REGISTRAR_APUESTA, 1, C, 3"));
        System.out.println(ejecutarOperacion.ejecutar("REGISTRAR_APUESTA, 1, A, 1325"));
        System.out.println(ejecutarOperacion.ejecutar("REGISTRAR_APUESTA, 1, B, 132"));
        System.out.println(ejecutarOperacion.ejecutar("REGISTRAR_APUESTA, 1, C, 13"));
        System.out.println(ejecutarOperacion.ejecutar("CERRAR"));
        System.out.println(ejecutarOperacion.ejecutar("CERRAR"));
        System.out.println(ejecutarOperacion.ejecutar("REGISTRAR_APUESTA, 1, C, 13"));
        System.out.println(ejecutarOperacion.ejecutar("REPORTAR"));
        System.out.println(ejecutarOperacion.ejecutar("SORTEO,3258"));

    }

    public String ejecutar(String mensajeAlServidor) {

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

                operacion=new CancelarCuenta();
                break;
            case "REGISTRAR_APUESTA":
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
        return operacion.ejecutar(parametros);
    }

}
