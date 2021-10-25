package cliente.operaciones;

import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProcesarCargaAutomatica extends TCPClientProtocol {

    private String[]  lineas;

    public ProcesarCargaAutomatica(String[] lineas) {
        this.lineas = lineas;
    }

    public void ejecutar() throws IOException {
        if( lineas.length == 2 ){//SI ES CERRAR CON SI O NO
            for (String linea: lineas) {
                toNetwork.println(linea);
                String fromServer = fromNetwork.readLine();
                System.out.println(fromServer);
            }
        } else {
            toNetwork.println(lineas[0]);
            fromNetwork.lines().forEach(
                    linea->System.out.println(linea)
            );
        }


    }
}
