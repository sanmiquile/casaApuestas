package cliente.operaciones;

import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import java.io.IOException;

public class Cerrar extends TCPClientProtocol {

    public void ejecutar() throws IOException {

        String cerrar;

        String mensajeAlServidor = "CERRAR" ;
        toNetwork.println(mensajeAlServidor);
        String fromServer=fromNetwork.readLine();

        if( "Está seguro de querer cerrar las apuestas ? ".contains(fromServer) ){
            cerrar = Console.leerDato(fromServer+ "SI/NO :");
            toNetwork.println(cerrar);
            fromServer=fromNetwork.readLine();
        }
        Console.mostarMensaje(fromServer);
    }


}
