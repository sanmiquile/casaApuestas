package servidor.logica.exceptions;

public class CuentaNoExisteException extends Exception{
    private static final String MENSAJE = "LA CUENTA %d NO EXISTE";
    public CuentaNoExisteException(int numeroCuenta) {
        super(String.format(MENSAJE,numeroCuenta));
    }
}
