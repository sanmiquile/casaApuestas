package logica.exceptions;

public class TipoApuestaException extends Exception{
    private static final String MENSAJE = "TIPO DE APUESTA INVALIDO";
    public TipoApuestaException() {
        super(MENSAJE);
    }
}
