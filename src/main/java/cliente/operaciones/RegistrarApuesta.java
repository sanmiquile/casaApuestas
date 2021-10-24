package cliente.operaciones;

import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import java.io.IOException;

public class RegistrarApuesta extends TCPClientProtocol {

    public void ejecutar() throws IOException {
        System.out.println("Ingrese el numero de la cuenta: ");
        String cuenta = Console.capturarStringConsola();
        System.out.println("Ingrese el tipo de apuesta que desea realizar (A,B,C):");
        String tipo = Console.capturarStringConsola();
        System.out.println("Ingrese el numero ");
        String numero = Console.capturarStringConsola();

        String mensajeAlServidor = "REGISTRAR_APUESTA," + cuenta + "," + tipo + "," +numero ;
        toNetwork.println(mensajeAlServidor);

        String fromServer=fromNetwork.readLine();
        System.out.println(fromServer);
    }

}
