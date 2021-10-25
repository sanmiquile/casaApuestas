package cliente.operaciones;

import  cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import java.io.IOException;

public class Retirar extends TCPClientProtocol {

    public void ejecutar() throws IOException {
        String cuenta = Console.leerDato("Ingrese la cuenta a retirar: ");
        String retiro = Console.leerDato("Ingrese el saldo a retirar");

        String mensajeAlServidor = "RETIRAR," + cuenta + "," + retiro;
        toNetwork.println(mensajeAlServidor);

        String fromServer=fromNetwork.readLine();
        Console.mostarMensaje(fromServer);
    }


}
