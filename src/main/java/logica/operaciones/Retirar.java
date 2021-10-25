package logica.operaciones;

import logica.modelos.CasaApuesta;
import logica.exceptions.CuentaNoExisteException;
import logica.exceptions.DepositoRetiroNoValidoException;
import logica.exceptions.FondosInsuficientesException;
import logica.exceptions.NumeroParametrosInvalidoException;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class Retirar implements Operacion{

    @Override
    public String ejecutar(String[] parametros, PrintWriter salida, BufferedReader entrada) {
        try {
            validarParametros(3, parametros.length);
            int numCuenta = Integer.parseInt( parametros[1].trim() );
            double valor = Double.parseDouble( parametros[2].trim() );
            CasaApuesta.getInstance().retirar(numCuenta,valor);
            return "Retiro exitoso en cuenta de ahorros "+numCuenta;
        } catch (CuentaNoExisteException | DepositoRetiroNoValidoException | FondosInsuficientesException | NumeroParametrosInvalidoException e) {
            return e.getMessage();
        }
    }
}
