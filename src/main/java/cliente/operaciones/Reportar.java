package cliente.operaciones;

import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import java.io.IOException;

public class Reportar extends TCPClientProtocol {
    public void ejecutar() throws IOException {
        String mensajeAlServidor = "REPORTAR";
        toNetwork.println(mensajeAlServidor);

        StringBuilder stringBuilder = new StringBuilder();
        fromNetwork.lines().forEach(
                linea->stringBuilder.append(linea+"\n")
        );
        Console.mostarMensaje(stringBuilder.toString());
//        String fromServer=fromNetwork.readLine();
//        System.out.println(fromServer);
    }
}
