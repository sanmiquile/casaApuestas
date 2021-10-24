package logica.operaciones;

import logica.CasaApuesta;
import logica.Cuenta;
import logica.exceptions.CuentaExisteException;
import logica.exceptions.NumeroParametrosInvalidoException;

public class CrearCuenta implements Operacion{

    @Override
    public String ejecutar(String[] parametros) {
        try {
            validarParametros(2, parametros.length);
            Cuenta cuenta = CasaApuesta.getInstance().crearCuenta(parametros[1].trim());
            return "SE CREO LA CUENTA " + cuenta.getNumeroCuenta();
        } catch (CuentaExisteException | NumeroParametrosInvalidoException e) {
            return e.getMessage();
        }
    }
}
