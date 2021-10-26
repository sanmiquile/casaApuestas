package servidor.logica.operaciones;

import servidor.logica.exceptions.SorteoRealizadoException;
import servidor.logica.modelos.CasaApuesta;
import servidor.logica.exceptions.FondosInsuficientesException;
import servidor.logica.exceptions.NumeroParametrosInvalidoException;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class Sortear implements Operacion{
    @Override
    public String ejecutar(String[] parametros, PrintWriter salida, BufferedReader entrada) {
        try {
            validarParametros(2, parametros.length);
            String numGanador =  parametros[1].trim() ;
            return CasaApuesta.getInstance().sortear(numGanador);
        } catch (NumeroParametrosInvalidoException | FondosInsuficientesException | SorteoRealizadoException e) {
            return e.getMessage();
        }
    }

}
