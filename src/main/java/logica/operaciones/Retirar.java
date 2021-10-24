package logica.operaciones;

import logica.modelos.CasaApuesta;
import logica.exceptions.CuentaNoExisteException;
import logica.exceptions.DepositoRetiroNoValidoException;
import logica.exceptions.FondosInsuficientesException;
import logica.exceptions.NumeroParametrosInvalidoException;

public class Retirar implements Operacion{

    @Override
    public String ejecutar(String[] parametros) {
        try {
            validarParametros(2, parametros.length);
            int numCuenta = Integer.parseInt( parametros[1].trim() );
            double valor = Double.parseDouble( parametros[2].trim() );
            CasaApuesta.getInstance().retirar(numCuenta,valor);
            return "Retiro exitoso en cuenta de ahorros "+numCuenta;
        } catch (CuentaNoExisteException | DepositoRetiroNoValidoException | FondosInsuficientesException | NumeroParametrosInvalidoException e) {
            return e.getMessage();
        }
    }
}
