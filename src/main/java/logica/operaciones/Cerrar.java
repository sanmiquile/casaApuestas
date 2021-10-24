package logica.operaciones;

import logica.CasaApuesta;
import logica.exceptions.ApuestasCerradasException;
import logica.exceptions.CuentaNoExisteException;
import logica.exceptions.NumeroParametrosInvalidoException;

public class Cerrar implements Operacion{

    @Override
    public String ejecutar(String[] parametros) {
        try {
            validarParametros(1, parametros.length);
            CasaApuesta.getInstance().cerrar();
            return "Se cerraron las apuestas";
        } catch (NumeroParametrosInvalidoException | ApuestasCerradasException e) {
            return e.getMessage();
        }
    }
}
