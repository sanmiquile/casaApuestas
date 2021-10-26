package servidor.logica.operaciones;

import servidor.logica.modelos.CasaApuesta;
import servidor.logica.exceptions.CuentaNoExisteException;
import servidor.logica.exceptions.DepositoRetiroNoValidoException;
import servidor.logica.exceptions.FondosInsuficientesException;
import servidor.logica.exceptions.NumeroParametrosInvalidoException;

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
