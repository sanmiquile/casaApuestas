package servidor.logica.exceptions;

public class CuentaExisteException extends Exception{
    private static final String MENSAJE = "LA CUENTA PARA %s YA EXISTE";
    public CuentaExisteException(String nombre) {
        super(String.format(MENSAJE,nombre));
    }
}
