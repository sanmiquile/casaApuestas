package cliente.operaciones;

import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import java.io.IOException;

public class RegistrarApuesta extends TCPClientProtocol {

    public void ejecutar() throws IOException {
        String cuenta = Console.leerDato("Ingrese el numero de la cuenta: ");
        String tipo = Console.leerDato("Ingrese el tipo de apuesta que desea realizar (A,B,C):");
        String numero = Console.leerDato("Ingrese el numero ");

        String mensajeAlServidor = "REGISTRAR_APUESTA," + cuenta + "," + tipo + "," +numero ;
        toNetwork.println(mensajeAlServidor);

        String fromServer=fromNetwork.readLine();
        Console.mostarMensaje(fromServer);
    }

}
