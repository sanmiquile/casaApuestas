package cliente.operaciones;

import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import java.io.IOException;

public class CancelarCuenta extends TCPClientProtocol {
    public void ejecutar() throws IOException {
        String cuenta = Console.leerDato("\nIngrese la cuenta a cancelar: ");
        String mensajeAlServidor = "CANCELAR_CUENTA," + cuenta;
        toNetwork.println(mensajeAlServidor);

        String fromServer=fromNetwork.readLine();
        Console.mostarMensaje(fromServer);
    }
}
