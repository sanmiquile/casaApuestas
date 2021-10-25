package cliente.operaciones;

import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import java.io.IOException;

public class Sortear extends TCPClientProtocol {
    public void ejecutar() throws IOException {
        String numero = Console.leerDato("\nIngrese el número ganador: ");

        String mensajeAlServidor = "SORTEO,"+numero;
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
