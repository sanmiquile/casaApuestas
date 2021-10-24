package logica.operaciones;

import logica.CasaApuesta;
import logica.exceptions.FondosInsuficientesException;
import logica.exceptions.NumeroParametrosInvalidoException;

public class Sortear implements Operacion{
    @Override
    public String ejecutar(String[] parametros) {
        try {
            validarParametros(2, parametros.length);
            String numGanador =  parametros[1].trim() ;
            return CasaApuesta.getInstance().sortear(numGanador);
        } catch (NumeroParametrosInvalidoException | FondosInsuficientesException e) {
            return e.getMessage();
        }
    }

}
