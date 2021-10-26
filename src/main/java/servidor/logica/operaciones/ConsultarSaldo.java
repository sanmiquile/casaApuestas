package servidor.logica.operaciones;

import servidor.logica.modelos.CasaApuesta;
import servidor.logica.exceptions.CuentaNoExisteException;
import servidor.logica.exceptions.NumeroParametrosInvalidoException;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class ConsultarSaldo implements Operacion{

    @Override
    public String ejecutar(String[] parametros, PrintWriter salida, BufferedReader entrada) {
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
