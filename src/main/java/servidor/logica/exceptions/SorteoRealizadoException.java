package servidor.logica.exceptions;

public class SorteoRealizadoException extends Exception{
    private static final String MENSAJE = "El sorteo ya fue realizado";
    public SorteoRealizadoException() {
        super(MENSAJE);
    }
}
