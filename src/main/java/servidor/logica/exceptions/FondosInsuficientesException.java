package servidor.logica.exceptions;

public class FondosInsuficientesException extends Exception{
    private static final String MENSAJE = "ERROR. Fondos insuficientes en cuenta de ahorros ";
    public FondosInsuficientesException(int numCuenta) {
        super(MENSAJE+numCuenta);
    }
}
