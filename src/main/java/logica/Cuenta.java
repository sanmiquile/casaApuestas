package logica;

public class Cuenta extends Operacion {
    private String nombreUsuario;
    private int numeroCuenta = -1;
    private double saldo;

 // Constructor de la clase
    public Cuenta(String nombreUsuario, int numeroCuenta, double saldo) {
        this.nombreUsuario = nombreUsuario;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
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
