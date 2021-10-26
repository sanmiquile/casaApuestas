package servidor.logica.exceptions;

public class NumeroInvalidoException extends Exception{
    private static final String MENSAJE = "NÚMERO INVALIDO";
    public NumeroInvalidoException() {
        super(MENSAJE);
    }
}
