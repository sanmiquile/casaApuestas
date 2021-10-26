package cliente;

import cliente.operaciones.*;
import cliente.sockets.TCPClient;
import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

public class Cliente {

    public void menuCliente() throws Exception {

        int opcion = 0;
        TCPClient tcpClient = new TCPClient();
        do {
            TCPClientProtocol tcpClientProtocol = null;
            String entrada = Console.leerDato("\n                  MENU DE OPERACIONES   \n " +
                                               "1. Crear cuenta\t   2.Depositar\t   3.Retirar\t   4.Apostar\n" +
                                              " 5.Cancelar Cuenta\t   6.Consultar Saldo\t   7.Salir\n\n"+
                                                "Ingrese la opcion deseada: ");

            opcion = Integer.parseInt(entrada);

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
                    Console.mostarMensaje("saliendo");
                    break;

                default:
                    Console.mostarMensaje("No se encontró la operación");
            }
            if( tcpClientProtocol != null ) {
                tcpClient.init(tcpClientProtocol);
            }
        } while (opcion != 7);
    }

}
