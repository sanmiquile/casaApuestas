package logica.exceptions;

public class DepositoRetiroNoValidoException extends Exception{
    private static final String MENSAJE = "EL VALOR INDICADO NO ES VALIDO";
    public DepositoRetiroNoValidoException() {
        super(MENSAJE);
    }
}
