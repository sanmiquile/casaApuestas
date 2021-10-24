package cliente;

import cliente.operaciones.CrearCuenta;
import cliente.operaciones.Depositar;
import cliente.sockets.TCPClient;
import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import java.util.Scanner;

public class ClienteModoText {
    public static void main(String[] args) {
        ClienteModoText clienteModoText = new ClienteModoText();
        try {
            clienteModoText.menuCliente();
        } catch (Exception e) {
            System.out.println("ERROR INESPERADO :"+e.getMessage());
        }
    }

    private void menuCliente() throws Exception {


        int opcion = 0;
        TCPClient tcpClient = new TCPClient();
        do {
            TCPClientProtocol tcpClientProtocol = null;
            System.out.println("MENU DE OPERACIONES\n 1. Crear cuenta\n 2.Depositar\n 3.Retirar\n 4.Apostar\n 5.Cancelar Cuenta\n 6.Consultar Saldo\n 7.Cerrar apuesta\n 8.Hacer reporte\n 9.Realizar Sorteo\n 10.Salir\n");
            System.out.println("Ingrese la opcion deseada: ");
            Scanner lectura = new Scanner(System.in);
            opcion = lectura.nextInt();

            switch (opcion) {
                case 1:
                    tcpClientProtocol = new CrearCuenta();
                    break;
                case 2: //realizarDeposito(palabras);
                    tcpClientProtocol = new Depositar();

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
            if( tcpClientProtocol != null ) {
                tcpClient.init(tcpClientProtocol);
            }
        } while (opcion != 10);
    }



}