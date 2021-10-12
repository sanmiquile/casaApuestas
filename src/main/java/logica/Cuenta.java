package logica;

public class Cuenta extends Operacion {
    String nombreUsuario;
    int valorAsignado;
    double saldo;
    private CasaApuesta casaApuesta;

    public Cuenta(String nombreUsuario, int valorAsignado, double saldo) {
        this.nombreUsuario = nombreUsuario;
        this.valorAsignado = valorAsignado;
        this.saldo = saldo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getValorAsignado() {
        return valorAsignado;
    }

    public void setValorAsignado(int valorAsignado) {
        this.valorAsignado = valorAsignado;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
