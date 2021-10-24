package cliente.operaciones;

import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import java.io.IOException;

public class Depositar extends TCPClientProtocol {
    public void ejecutar() throws IOException {
        System.out.println("Ingrese la cuenta a depositar: ");
        String cuenta = Console.capturarStringConsola();
        System.out.println("Ingrese el saldo a depositar");
        String deposito = Console.capturarStringConsola();

        String mensajeAlServidor = "DEPOSITAR," + cuenta + "," + deposito;
        toNetwork.println(mensajeAlServidor);

        String fromServer=fromNetwork.readLine();
        System.out.println(fromServer);
    }
}
