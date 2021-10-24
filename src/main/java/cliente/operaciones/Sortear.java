package cliente.operaciones;

import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import java.io.IOException;

public class Sortear extends TCPClientProtocol {
    public void ejecutar() throws IOException {
        System.out.println("\nIngrese el número ganador: ");
        String numero = Console.capturarStringConsola();

        String mensajeAlServidor = "SORTEO,"+numero;
        toNetwork.println(mensajeAlServidor);

        fromNetwork.lines().forEach(
                linea->System.out.println(linea)
        );
//        String fromServer=fromNetwork.readLine();
//        System.out.println(fromServer);
    }
}
