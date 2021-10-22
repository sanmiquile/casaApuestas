package logica;

public class Cuenta extends Operacion {
    private String nombreUsuario;
    private int numeroCuenta = -1;
    private double saldo;

 // este metodo permite  numerar las cuentas
    public Cuenta(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        numeroCuenta++;
        saldo = 0.0;
    }

    public void depositar() {
        saldo = saldo + cantidadDinero;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
