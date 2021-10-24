package cliente;

import cliente.operaciones.*;
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
            System.out.println("\nMENU DE OPERACIONES\n 1. Crear cuenta\t 2.Depositar\t 3.Retirar\t 4.Apostar\t 5.Cancelar Cuenta" +
                    "\n 6.Consultar Saldo\t 7.Cerrar apuesta\t 8.Hacer reporte\t 9.Realizar Sorteo\t 10.Salir\n");
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
                    tcpClientProtocol = new Retirar();
                    break;
                case 4:
                    // realizarApuesta(palabras);
                    tcpClientProtocol = new RegistrarApuesta();

                    break;
                case 5:
                    // cancelarCuenta(palabaras);
                    tcpClientProtocol = new CancelarCuenta();
                    break;
                case 6:
                    // consultarSaldo(palabras);
                    tcpClientProtocol = new Consultar();
                    break;
                case 7:
                    // cerrarApuesta(palabras);
                    tcpClientProtocol = new Cerrar();
                    break;
                case 8:
                    //realizarReporte;
                    tcpClientProtocol = new Reportar();
                    break;
                case 9:
                    // generarSorteo;
                    tcpClientProtocol = new Sortear();
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
