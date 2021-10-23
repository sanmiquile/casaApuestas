package logica.operaciones;

import logica.CasaApuesta;
import logica.Cuenta;
import logica.exceptions.CuentaConSaldoException;
import logica.exceptions.CuentaExisteException;
import logica.exceptions.CuentaNoExisteException;

public class CancelarCuenta implements Operacion{

    @Override
    public String ejecutar(String[] parametros) {
        try {
            int numCuenta=Integer.parseInt(parametros[1]);
            CasaApuesta.getInstance().cancelarCuenta(numCuenta);
            return "Cuenta "+ numCuenta+" cancelada exitosamente";
        } catch (CuentaNoExisteException | CuentaConSaldoException e) {
            return e.getMessage();
        }
    }
}
