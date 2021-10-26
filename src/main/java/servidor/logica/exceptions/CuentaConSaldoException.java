package servidor.logica.exceptions;

public class CuentaConSaldoException extends Exception{
    private static final String MENSAJE = "No se puede cancelar la cuenta tiene  saldo";
    public CuentaConSaldoException() {
        super(MENSAJE);
    }
}
