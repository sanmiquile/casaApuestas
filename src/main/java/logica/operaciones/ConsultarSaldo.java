package logica.operaciones;

import logica.CasaApuesta;
import logica.exceptions.CuentaNoExisteException;
import logica.exceptions.NumeroParametrosInvalidoException;

public class ConsultarSaldo implements Operacion{

    @Override
    public String ejecutar(String[] parametros) {
        try {
            validarParametros(2, parametros.length);
            int numCuenta=Integer.parseInt(parametros[1]);
            double saldo = CasaApuesta.getInstance().consultarSaldo(numCuenta);
            return "Saldo "+saldo;
        } catch (CuentaNoExisteException | NumeroParametrosInvalidoException e) {
            return e.getMessage();
        }
    }
}
