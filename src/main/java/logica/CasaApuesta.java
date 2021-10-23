package logica;
import logica.exceptions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
/*
 * Esta clase sera el servidor que contendra toda la informacion de operaciones del proyecto.
 */

public class CasaApuesta {
    // Se debe crear las listas y hashMap de la informaqcion de los usuarios y las apuestas.
    private Map<String,Cuenta> mapCuentasUsuario;
    private int numCuenta;

    public CasaApuesta() {
        mapCuentasUsuario = new HashMap<String,Cuenta>();
        numCuenta = 0;
        try {
            crearCuenta("Casa Apuestas");
        } catch (CuentaExisteException e) {

        }
    }

    private static final CasaApuesta instance = new CasaApuesta();

    public static CasaApuesta getInstance(){
        return instance;
    }

    public synchronized Cuenta crearCuenta (String nombre ) throws CuentaExisteException {
        boolean  bandera = false;
        if( mapCuentasUsuario.containsKey(nombre) ){
            throw new CuentaExisteException(nombre);
        }
        Cuenta cuenta = new Cuenta(nombre, obtenerNumeroCuenta(), 0);
        mapCuentasUsuario.put(nombre,cuenta);
        return cuenta;
    }

    private int obtenerNumeroCuenta() {
        return numCuenta++;
    }

    public void depositar(int numeroCuenta,double deposito) throws CuentaNoExisteException, DepositoRetiroNoValidoException {
        if(deposito < 0 ){
            throw new DepositoRetiroNoValidoException();
        }
        Optional<Cuenta> optional = obtenerCuentaByNumeroCuenta(numeroCuenta);
        Cuenta cuenta = optional.orElseThrow( ()->new CuentaNoExisteException(numeroCuenta) );
        cuenta.incrementarSaldo( deposito );
    }

    public void retirar(int numeroCuenta,double retiro) throws CuentaNoExisteException, DepositoRetiroNoValidoException, FondosInsuficientesException {
        if(retiro <= 0 ){
            throw new DepositoRetiroNoValidoException();
        }
        Optional<Cuenta> optional = obtenerCuentaByNumeroCuenta(numeroCuenta);
        Cuenta cuenta = optional.orElseThrow( ()->new CuentaNoExisteException(numeroCuenta) );
        cuenta.restarSaldo( retiro );
    }
    private Optional<Cuenta> obtenerCuentaByNumeroCuenta(int numeroCuenta) {
//        for (Cuenta cuenta: mapCuentasUsuario.values()    ) {
//            if( cuenta.getNumeroCuenta() == numeroCuenta){
//                return Optional.of(cuenta);
//            }
//        }
//        return Optional.empty();

        return mapCuentasUsuario.values().stream().filter(cuenta -> cuenta.getNumeroCuenta()==numeroCuenta).findFirst();
    }


    public  synchronized void cancelarCuenta(int numCuenta) throws CuentaNoExisteException, CuentaConSaldoException {

        Optional<Cuenta> optional = obtenerCuentaByNumeroCuenta(numCuenta);
        Cuenta cuenta = optional.orElseThrow( ()->new CuentaNoExisteException(numCuenta) );
        if (cuenta.getSaldo()!=0){
            throw new CuentaConSaldoException();

        }
        mapCuentasUsuario.remove(cuenta.getNombreUsuario());

    }
}


