package servidor.logica.modelos;

import servidor.logica.exceptions.FondosInsuficientesException;

public class Cuenta  {
    private final String nombreUsuario;
    private final int numeroCuenta;
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

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    /*
       Metodo que le suma el monto de dinero depositado al saldo
     */

    public synchronized void incrementarSaldo(double deposito) {
        saldo += deposito;
    }
    /*
       Metodo que le resta al saldo el monto de dinero retirado
     */
    public synchronized void restarSaldo(double retiro) throws FondosInsuficientesException {
        if(retiro>saldo){
            throw new FondosInsuficientesException(numeroCuenta);
        }
        saldo=saldo-retiro;
    }
}
