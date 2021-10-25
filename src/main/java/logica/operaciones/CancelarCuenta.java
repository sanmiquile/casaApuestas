package logica.operaciones;

import logica.modelos.CasaApuesta;
import logica.exceptions.CuentaConSaldoException;
import logica.exceptions.CuentaNoExisteException;
import logica.exceptions.NumeroParametrosInvalidoException;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class CancelarCuenta implements Operacion{

    @Override
    public String ejecutar(String[] parametros, PrintWriter salida, BufferedReader entrada) {
        try {
            validarParametros(2, parametros.length);
            int numCuenta=Integer.parseInt(parametros[1]);
            CasaApuesta.getInstance().cancelarCuenta(numCuenta);
            return "Cuenta "+ numCuenta+" cancelada exitosamente";
        } catch (CuentaNoExisteException | CuentaConSaldoException | NumeroParametrosInvalidoException e) {
            return e.getMessage();
        }
    }
}
