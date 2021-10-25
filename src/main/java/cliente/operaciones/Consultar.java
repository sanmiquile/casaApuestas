package cliente.operaciones;

import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import java.io.IOException;

public class Consultar extends TCPClientProtocol {

    public void ejecutar() throws IOException {

        String cuenta = Console.leerDato("Ingrese la cuenta a  consultar: ");

        String mensajeAlServidor = "CONSULTAR_SALDO," + cuenta ;
        toNetwork.println(mensajeAlServidor);
        String fromServer=fromNetwork.readLine();
        Console.mostarMensaje(fromServer);
    }


}
