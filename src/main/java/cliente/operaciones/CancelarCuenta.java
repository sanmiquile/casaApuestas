package cliente.operaciones;

import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import java.io.IOException;

public class CancelarCuenta extends TCPClientProtocol {
    public void ejecutar() throws IOException {
        System.out.println("\nIngrese la cuenta a cancelar: ");
        String cuenta = Console.capturarStringConsola();
        String mensajeAlServidor = "CANCELAR_CUENTA," + cuenta;
        toNetwork.println(mensajeAlServidor);

        String fromServer=fromNetwork.readLine();
        System.out.println(fromServer);
    }
}
