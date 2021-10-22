package logica;

public class Apuesta {
    private int numeroCuenta;
    private char tipoApuesta;
    private int numeroApuesta;

    public Apuesta(char tipoApuesta, int numeroApuesta) {
        this.tipoApuesta = tipoApuesta;
        this.numeroApuesta = numeroApuesta;
    }

    public char getTipoApuesta() {
        return tipoApuesta;
    }

    public void setTipoApuesta(char tipoApuesta) {
        this.tipoApuesta = tipoApuesta;
    }

    public int getNumeroApuesta() {
        return numeroApuesta;
    }

    public void setNumeroApuesta(int numeroApuesta) {
        this.numeroApuesta = numeroApuesta;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}

