package cliente;

import cliente.operaciones.Cerrar;
import cliente.operaciones.Reportar;
import cliente.operaciones.Sortear;
import cliente.sockets.TCPClient;
import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

public class Casa {

    public void menuCliente() throws Exception {

        int opcion = 0;
        TCPClient tcpClient = new TCPClient();
        do {
            TCPClientProtocol tcpClientProtocol = null;
            String entrada = Console.leerDato("\nMENU DE OPERACIONES\n 1.Cerrar apuesta\t 2.Hacer reporte\t 3.Realizar Sorteo\t 4.Salir\n");

            opcion = Integer.parseInt(entrada);

            switch (opcion) {
                case 1:
                    // cerrarApuesta(palabras);
                    tcpClientProtocol = new Cerrar();
                    break;
                case 2:
                    //realizarReporte;
                    tcpClientProtocol = new Reportar();
                    break;
                case 3:
                    // generarSorteo;
                    tcpClientProtocol = new Sortear();
                    break;
                case 4:
                    Console.mostarMensaje("saliendo");
                    break;

                default:
                    Console.mostarMensaje("No se encontró la operación");
            }
            if( tcpClientProtocol != null ) {
                tcpClient.init(tcpClientProtocol);
            }
        } while (opcion != 4);
    }

}
