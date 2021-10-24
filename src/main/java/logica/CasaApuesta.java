package logica;

import logica.exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * Esta clase sera el servidor que contendra toda la informacion de operaciones del proyecto.
 */

public class CasaApuesta {
    private static final String NOMBRE_CASA = "Casa Apuestas";
    // Se debe crear las listas y hashMap de la informaqcion de los usuarios y las apuestas.
    private Map<String, Cuenta> mapCuentasUsuario;
    private int indiceNumCuenta;
    private List<Apuesta> apuestas;
    private boolean apuestasCerradas;


    public CasaApuesta() {
        mapCuentasUsuario = new HashMap<String, Cuenta>();
        apuestas = new ArrayList<>();
        indiceNumCuenta = 0;
        apuestasCerradas = false;
        try {
            crearCuenta(NOMBRE_CASA);
        } catch (CuentaExisteException e) {

        }
    }

    private static final CasaApuesta instance = new CasaApuesta();

    public static CasaApuesta getInstance() {
        return instance;
    }

    public synchronized Cuenta crearCuenta(String nombre) throws CuentaExisteException {
        boolean bandera = false;
        if (mapCuentasUsuario.containsKey(nombre)) {
            throw new CuentaExisteException(nombre);
        }
        Cuenta cuenta = new Cuenta(nombre, obtenerNumeroCuenta(), 0);
        mapCuentasUsuario.put(nombre, cuenta);
        return cuenta;
    }

    private int obtenerNumeroCuenta() {
        return indiceNumCuenta++;
    }

    public void depositar(int numeroCuenta, double deposito) throws CuentaNoExisteException, DepositoRetiroNoValidoException {
        if (deposito < 0) {
            throw new DepositoRetiroNoValidoException();
        }
        Cuenta cuenta = obtenerCuentaByNumeroCuenta(numeroCuenta);
        cuenta.incrementarSaldo(deposito);
    }

    public void retirar(int numeroCuenta, double retiro) throws CuentaNoExisteException, DepositoRetiroNoValidoException, FondosInsuficientesException {
        if (retiro <= 0) {
            throw new DepositoRetiroNoValidoException();
        }
        Cuenta cuenta = obtenerCuentaByNumeroCuenta(numeroCuenta);
        cuenta.restarSaldo(retiro);
    }

    private Cuenta obtenerCuentaByNumeroCuenta(int numeroCuenta) throws CuentaNoExisteException {
//        for (Cuenta cuenta: mapCuentasUsuario.values()    ) {
//            if( cuenta.getNumeroCuenta() == numeroCuenta){
//                return Optional.of(cuenta);
//            }
//        }
//        return Optional.empty();
        return mapCuentasUsuario.values().stream()
                .filter(cuenta -> cuenta.getNumeroCuenta() == numeroCuenta)
                .findFirst().orElseThrow(() -> new CuentaNoExisteException(numeroCuenta));
    }


    public synchronized void cancelarCuenta(int numCuenta) throws CuentaNoExisteException, CuentaConSaldoException {
        Cuenta cuenta = obtenerCuentaByNumeroCuenta(numCuenta);
        if (cuenta.getSaldo() != 0) {
            throw new CuentaConSaldoException();

        }
        mapCuentasUsuario.remove(cuenta.getNombreUsuario());

    }

    public void apostar(int numCuenta, char tipoApuesta, String numero) throws CuentaNoExisteException, TipoApuestaException, NumeroInvalidoException, FondosInsuficientesException, ApuestasCerradasException {
        if (apuestasCerradas) {
            throw new ApuestasCerradasException();
        }
        Cuenta cuenta = obtenerCuentaByNumeroCuenta(numCuenta);
        Apuesta apuesta = new Apuesta(cuenta, tipoApuesta, numero);
        cuenta.restarSaldo(Apuesta.VALOR_APUESTA);
        obterCuentaCasa().incrementarSaldo(Apuesta.VALOR_APUESTA);
        apuestas.add(apuesta);
    }

    private Cuenta obterCuentaCasa() {
        return mapCuentasUsuario.get(NOMBRE_CASA);
    }

    public double consultarSaldo(int numCuenta) throws CuentaNoExisteException {
        return obtenerCuentaByNumeroCuenta(numCuenta).getSaldo();
    }

    public void cerrar() throws ApuestasCerradasException {
        if (apuestasCerradas) {
            throw new ApuestasCerradasException();
        }
        apuestasCerradas = true;
    }

    public String reportar() {
        StringBuilder stringBuilder = new StringBuilder();
        int tipoA = 0;
        int tipoB = 0;
        int tipoC = 0;
        for (Apuesta apuesta : apuestas) {
            stringBuilder.append(apuesta.toString() + "\n");
            switch (apuesta.getTipoApuesta()) {
                case 'A':
                    tipoA++;
                    break;
                case 'B':
                    tipoB++;
                    break;
                case 'C':
                    tipoC++;
                    break;
            }
        }
        stringBuilder.append(tipoA + " Apuestas tipo A, total: " + (tipoA * Apuesta.VALOR_APUESTA) + "\n");
        stringBuilder.append(tipoB + " Apuestas tipo B, total: " + (tipoB * Apuesta.VALOR_APUESTA) + "\n");
        stringBuilder.append(tipoC + " Apuestas tipo C, total: " + (tipoC * Apuesta.VALOR_APUESTA) + "\n");
        return stringBuilder.toString();
    }

    public String sortear(int numGanador) {
        //se debe validar  cuantos ganadores hay por  el numero ganador  y dividir el premio en partes iguales
        int tipoA = 0;
        int tipoB = 0;
        int tipoC = 0;
        for (Apuesta apuesta : apuestas) {

            switch (apuesta.getTipoApuesta()) {
                case 'A':
                    tipoA++;
                    break;
                case 'B':
                    tipoB++;
                    break;
                case 'C':
                    tipoC++;
                    break;
            }
        }
        double pagoTipoA = ((tipoA * Apuesta.VALOR_APUESTA) * 80) / 100;
        double pagoTipoB = ((tipoB * Apuesta.VALOR_APUESTA) * 70) / 100;
        double pagoTipoC = ((tipoC * Apuesta.VALOR_APUESTA) * 60) / 100;

        return " A " + pagoTipoA + "B " + pagoTipoB + "c " + pagoTipoC;
        int canGanadorA=0;
        int canGanadorB = 0;
        int canGanadorC = 0;
        List<Cuenta> ganadores= new ArrayList<Cuenta>();


        for (Apuesta apuesta : apuestas) {

            int numApuesta=Integer.parseInt(apuesta.getNumeroApuesta());
            if (numApuesta==numGanador) {


                switch (apuesta.g) {

                    case 'A':
                        canGanadorA++;
                        break;
                    case 'B':
                        canGanadorB++;
                        break;
                    case 'C':
                        canGanadorC++;
                        break;
                }


            }
        }
    }
}

