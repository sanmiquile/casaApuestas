package logica.operaciones;

import logica.CasaApuesta;
import logica.Cuenta;
import logica.exceptions.CuentaExisteException;

public class CrearCuenta implements Operacion{

    @Override
    public String ejecutar(String[] parametros) {
        try {
            Cuenta cuenta = CasaApuesta.getInstance().crearCuenta(parametros[1].trim());
            return "SE CREO LA CUENTA " + cuenta.getNumeroCuenta();
        } catch (CuentaExisteException e) {
            return e.getMessage();
        }
    }
}
