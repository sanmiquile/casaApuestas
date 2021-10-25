package cliente.operaciones;

import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import java.io.IOException;

public class CrearCuenta extends TCPClientProtocol {
    public void ejecutar() throws IOException {

        String nombre = Console.leerDato("Ingrese su nombre y apellido: ");
        String mensajeAlServidor = "CREAR_CUENTA," + nombre;
        toNetwork.println(mensajeAlServidor);

        String fromServer=fromNetwork.readLine();
        Console.mostarMensaje(fromServer);
    }
}
