package cliente.operaciones;

import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import java.io.IOException;

public class Cerrar extends TCPClientProtocol {

    public void ejecutar() throws IOException {

        System.out.println("Ingrese la cuenta a  consultar: ");
        String cerrar = Console.capturarStringConsola();

        String mensajeAlServidor = "CERRAR," + cerrar ;
        toNetwork.println(mensajeAlServidor);
        String fromServer=fromNetwork.readLine();
        System.out.println(fromServer);
    }


}
