package logica.operaciones;

import logica.modelos.CasaApuesta;
import logica.exceptions.NumeroParametrosInvalidoException;

public class Reportar implements Operacion{

    @Override
    public String ejecutar(String[] parametros) {
        try {
            validarParametros(1, parametros.length);
            return CasaApuesta.getInstance().reportar();
        } catch (NumeroParametrosInvalidoException e) {
            return e.getMessage();
        }
    }
}
