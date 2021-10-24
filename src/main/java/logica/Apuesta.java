package logica;

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

    @Override
    public String toString() {
        return cuenta.getNombreUsuario() +","+tipoApuesta+","+numeroApuesta;
    }
}

