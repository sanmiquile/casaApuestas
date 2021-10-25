package cliente.operaciones;

import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import java.io.IOException;

public class Depositar extends TCPClientProtocol {
    public void ejecutar() throws IOException {
        String cuenta = Console.leerDato("Ingrese la cuenta a depositar: ");
        String deposito = Console.leerDato("Ingrese el saldo a depositar");

        String mensajeAlServidor = "DEPOSITAR," + cuenta + "," + deposito;
        toNetwork.println(mensajeAlServidor);

        String fromServer=fromNetwork.readLine();
        Console.mostarMensaje(fromServer);
    }
}
