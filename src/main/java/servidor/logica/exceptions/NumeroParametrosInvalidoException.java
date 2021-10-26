package servidor.logica.exceptions;

public class NumeroParametrosInvalidoException extends Exception{
    private static final String MENSAJE = "NÚMERO DE PARAMETROS INVALIDO";
    public NumeroParametrosInvalidoException() {
        super(MENSAJE);
    }
}
