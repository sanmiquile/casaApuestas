package logica.operaciones;

import logica.modelos.CasaApuesta;
import logica.exceptions.CuentaNoExisteException;
import logica.exceptions.DepositoRetiroNoValidoException;
import logica.exceptions.NumeroParametrosInvalidoException;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class Despositar implements Operacion{

    @Override
    /*
       Metodo que valida que los parametros recibidos sean los requeridos, si es asi se realiza el deposito
       sino se lanza la excepcion que corresponda
     */
    public String ejecutar(String[] parametros, PrintWriter salida, BufferedReader entrada) {
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
