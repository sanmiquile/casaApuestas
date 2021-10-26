package servidor.logica.operaciones;

import servidor.logica.modelos.CasaApuesta;
import servidor.logica.exceptions.*;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class RegistrarApuesta implements Operacion{

    @Override
    public String ejecutar(String[] parametros, PrintWriter salida, BufferedReader entrada) {
        try {
            validarParametros(4, parametros.length);
            int numCuenta = Integer.parseInt( parametros[1].trim() );
            char tipoApuesta = parametros[2].trim().charAt(0);
            CasaApuesta.getInstance().apostar(numCuenta,tipoApuesta,parametros[3].trim());
            return "Apuesta exitosa";
        } catch (CuentaNoExisteException | NumeroParametrosInvalidoException | TipoApuestaException | NumeroInvalidoException | FondosInsuficientesException | ApuestasCerradasException e) {
            return e.getMessage();
        }
    }
}
