package logica.operaciones;

import logica.modelos.CasaApuesta;
import logica.exceptions.NumeroParametrosInvalidoException;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class Reportar implements Operacion{

    @Override
    public String ejecutar(String[] parametros, PrintWriter salida, BufferedReader entrada) {
        try {
            validarParametros(1, parametros.length);
            return CasaApuesta.getInstance().reportar();
        } catch (NumeroParametrosInvalidoException e) {
            return e.getMessage();
        }
    }
}
