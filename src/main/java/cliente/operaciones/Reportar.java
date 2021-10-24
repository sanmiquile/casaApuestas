package cliente.operaciones;

import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import java.io.IOException;

public class Reportar extends TCPClientProtocol {
    public void ejecutar() throws IOException {
        String mensajeAlServidor = "REPORTAR";
        toNetwork.println(mensajeAlServidor);

        fromNetwork.lines().forEach(
                linea->System.out.println(linea)
        );
//        String fromServer=fromNetwork.readLine();
//        System.out.println(fromServer);
    }
}
