package cliente.operaciones;

import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import java.io.IOException;

public class Consultar extends TCPClientProtocol {

    public void ejecutar() throws IOException {

        System.out.println("Ingrese la cuenta a  consultar: ");
        String cuenta = Console.capturarStringConsola();

        String mensajeAlServidor = "CONSULTAR_CUENTA," + cuenta ;
        toNetwork.println(mensajeAlServidor);
        String fromServer=fromNetwork.readLine();
        System.out.println(fromServer);
    }


}
