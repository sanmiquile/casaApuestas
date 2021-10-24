package logica.operaciones;

import logica.CasaApuesta;
import logica.exceptions.CuentaNoExisteException;
import logica.exceptions.DepositoRetiroNoValidoException;
import logica.exceptions.NumeroParametrosInvalidoException;

public class Despositar implements Operacion{

    @Override
    /*
       Metodo que valida que los parametros recibidos sean los requeridos, si es asi se realiza el deposito
       sino se lanza la excepcion que corresponda
     */
    public String ejecutar(String[] parametros) {
        try {
            validarParametros(3, parametros.length);
            int numCuenta = Integer.parseInt( parametros[1].trim() );
            double valor = Double.parseDouble( parametros[2].trim() );
            CasaApuesta.getInstance().depositar(numCuenta,valor);
            return "Depósito exitoso en cuenta de ahorros "+numCuenta;
        } catch (CuentaNoExisteException | DepositoRetiroNoValidoException | NumeroParametrosInvalidoException e) {
            return e.getMessage();
        }
    }
}
