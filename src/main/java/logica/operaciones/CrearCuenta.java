package logica.operaciones;

import logica.modelos.CasaApuesta;
import logica.modelos.Cuenta;
import logica.exceptions.CuentaExisteException;
import logica.exceptions.NumeroParametrosInvalidoException;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class CrearCuenta implements Operacion{

    @Override
    /*
      - Metodo que valida que el numero de datos ingresados por el usuario coincidan con los establecidos
        si esto es correcto se  crea la cuenta con sus respectivos datos y retorna un mensaje de confirmacion.
        De lo contrario se lanza una de las dos exepciones.
     */
    public String ejecutar(String[] parametros, PrintWriter salida, BufferedReader entrada) {
        try {
            validarParametros(2, parametros.length);
            Cuenta cuenta = CasaApuesta.getInstance().crearCuenta(parametros[1].trim());
            return "SE CREO LA CUENTA " + cuenta.getNumeroCuenta();
        } catch (CuentaExisteException | NumeroParametrosInvalidoException e) {
            return e.getMessage();
        }
    }
}
