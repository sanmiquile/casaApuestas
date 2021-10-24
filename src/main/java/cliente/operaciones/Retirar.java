package cliente.operaciones;

import  cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import java.io.IOException;

public class Retirar extends TCPClientProtocol {

    public void ejecutar() throws IOException {
        System.out.println("Ingrese la cuenta a retirar: ");
        String cuenta = Console.capturarStringConsola();
        System.out.println("Ingrese el saldo a retirar");
        String retiro = Console.capturarStringConsola();

        String mensajeAlServidor = "RETIRAR," + cuenta + "," + retiro;
        toNetwork.println(mensajeAlServidor);

        String fromServer=fromNetwork.readLine();
        System.out.println(fromServer);
    }


}
