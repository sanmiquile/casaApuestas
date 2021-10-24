package logica.modelos;

import logica.exceptions.NumeroInvalidoException;
import logica.exceptions.TipoApuestaException;

public class Apuesta {
    public static final double VALOR_APUESTA = 10000;
    private final Cuenta cuenta;
    private final char tipoApuesta;
    private final String numeroApuesta;

    public Apuesta(Cuenta cuenta, char tipoApuesta, String numeroApuesta) throws TipoApuestaException, NumeroInvalidoException {
        this.cuenta = cuenta;
        this.tipoApuesta = tipoApuesta;
        this.numeroApuesta = validarTipoApuestaNumero(tipoApuesta,numeroApuesta);
    }

    private String validarTipoApuestaNumero(char tipoApuesta,String numeroApuesta) throws TipoApuestaException, NumeroInvalidoException {
        int digitos=0;
        switch (tipoApuesta){
            case 'A':
                digitos = 4;
                break;
            case 'B':
                digitos = 3;
                break;
            case 'C':
                digitos = 2;
                break;
            default:
                throw new TipoApuestaException();
        }
        if( numeroApuesta.length() < digitos ){
            throw new NumeroInvalidoException();
        }
        return numeroApuesta.substring(numeroApuesta.length()-digitos);
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public char getTipoApuesta() {
        return tipoApuesta;
    }

    public String getNumeroApuesta() {
        return numeroApuesta;
    }

    public boolean esGanador(String numeroGanador){
        // si el ganador es 1234
        // si el es tipo A 5678 (longitud 4) 4 - 4 = 0 una subcadena numero desde la 0 hasta el fin seria 1234
        // si el es tipo B 678 (longitud 3) 4 - 3 = 1 una subcadena numero desde la 1 hasta el fin seria 234
        // si el es tipo C  78 (longitud 2) 4 - 2 = 2 una subcadena numero desde la 1 hasta el fin seria 34
        String numeroGanadorAuxiliar = numeroGanador.substring( 4 - numeroApuesta.length() );
        return numeroGanadorAuxiliar.equals(numeroApuesta);
    }

    @Override
    public String toString() {
        return cuenta.getNombreUsuario() +","+tipoApuesta+","+numeroApuesta;
    }
}

