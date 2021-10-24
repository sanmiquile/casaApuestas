package cliente.operaciones;

import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import java.io.IOException;

public class CrearCuenta extends TCPClientProtocol {
    public void ejecutar() throws IOException {
        System.out.println("Ingrese su nombre y apellido: ");
        String nombre = Console.capturarStringConsola();
        String mensajeAlServidor = "CREAR_CUENTA," + nombre;
        toNetwork.println(mensajeAlServidor);

        String fromServer=fromNetwork.readLine();
        System.out.println(fromServer);
    }
}
