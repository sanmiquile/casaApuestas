package logica.operaciones;

import logica.CasaApuesta;
import logica.exceptions.NumeroParametrosInvalidoException;

public class Sortear implements Operacion{
    @Override
    public String ejecutar(String[] parametros) {
        try {
            validarParametros(2, parametros.length);
            int numGanador = Integer.parseInt( parametros[1].trim() );
            return CasaApuesta.getInstance().sortear(numGanador);
        } catch (NumeroParametrosInvalidoException e) {
            return e.getMessage();
        }
    }

}
