package servidor.logica.operaciones;

import servidor.logica.modelos.CasaApuesta;
import servidor.logica.exceptions.ApuestasCerradasException;
import servidor.logica.exceptions.NumeroParametrosInvalidoException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Cerrar implements Operacion{

    @Override
    public String ejecutar(String[] parametros, PrintWriter salida, BufferedReader entrada) {
        try {
            validarParametros(1, parametros.length);
            String respuesta = "SI";
            if( !CasaApuesta.getInstance().isApuestasCerradas() && !CasaApuesta.getInstance().hayApuestas()){
                salida.println("Está seguro de querer cerrar las apuestas ? ");
                respuesta = entrada.readLine();
            }
            if( "SI".equals(respuesta) ) {
                CasaApuesta.getInstance().cerrar();
                return "Se cerraron las apuestas";
            } else {
                return "Apuestas abiertas ";
            }
        } catch (NumeroParametrosInvalidoException | ApuestasCerradasException | IOException e) {
            return e.getMessage();
        }
    }
}
