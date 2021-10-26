package servidor.logica.exceptions;

public class ApuestasCerradasException extends Exception{
    private static final String MENSAJE = "LAS APUESTAS YA ESTAN CERRADAS";
    public ApuestasCerradasException() {
        super(MENSAJE);
    }
}
