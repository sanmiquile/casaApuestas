package logica.operaciones;

import logica.CasaApuesta;
import logica.exceptions.*;

public class RegistrarApuesta implements Operacion{

    @Override
    public String ejecutar(String[] parametros) {
        try {
            validarParametros(4, parametros.length);
            int numCuenta = Integer.parseInt( parametros[1].trim() );
            char tipoApuesta = parametros[2].trim().charAt(0);
            CasaApuesta.getInstance().apostar(numCuenta,tipoApuesta,parametros[3].trim());
            return "Depósito exitoso en cuenta de ahorros "+numCuenta;
        } catch (CuentaNoExisteException | NumeroParametrosInvalidoException | TipoApuestaException | NumeroInvalidoException | FondosInsuficientesException | ApuestasCerradasException e) {
            return e.getMessage();
        }
    }
}
