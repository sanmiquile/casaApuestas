package logica.modelos;

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
    private Map<String,Cuenta> mapCuentasUsuario;
    private int indiceNumCuenta;
    private List<Apuesta> apuestas;
    private boolean apuestasCerradas;

     // se inicializan los datos
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

    /*
       - Metodo sincronizado que  evita que dos  usuarios creen la cuenta al mismo tiempo
       - En este metodo se valida la existencia del nombre del usuario en la lista, arroja una excepcion si el nombre ya existe.
         sino retorna el objeto cuenta
     */
    /*
       - Metodo sincronizado que  evita que dos  usuarios creen la cuenta al mismo tiempo
       - En este metodo se valida la existencia del nombre del usuario en la lista, arroja una excepcion si el nombre ya existe.
         sino retorna el objeto cuenta
     */

    public synchronized Cuenta crearCuenta (String nombre ) throws CuentaExisteException {
        boolean  bandera = false;
        if( mapCuentasUsuario.containsKey(nombre) ){
            throw new CuentaExisteException(nombre);
        }
        Cuenta cuenta = new Cuenta(nombre, obtenerNumeroCuenta(), 0);
        mapCuentasUsuario.put(nombre, cuenta);
        return cuenta;
    }


    /*
      Metodo que nos permite generar un numero de cuenta diferente
     */
    private int obtenerNumeroCuenta() {
        return indiceNumCuenta++;
    }

    /*
       Metodo que valida que el valor del deposito sea mayor a 0, si es asi se obtiene el numero de la cuenta y
       al saldo de la cuenta se le incrementa el valor del deposito, de no ser asi nos arrojara una excepcion
     */
    public void depositar(int numeroCuenta,double deposito) throws CuentaNoExisteException, DepositoRetiroNoValidoException {
        if(deposito < 0 ){
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


    /*
       Metodo que retorna de la lista de usuarios los  datos filtrados por el numero de cuenta y muetra el primero
     */
    private Cuenta obtenerCuentaByNumeroCuenta(int numeroCuenta) throws CuentaNoExisteException {
//        for (Cuenta cuenta: mapCuentasUsuario.values()    ) {
//            if( cuenta.getNumeroCuenta() == numeroCuenta){
//                return Optional.of(cuenta);
//            }
//        }
//        return Optional.empty();
        // Opcional tiene o no tiene a la cuenta
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
        stringBuilder.append(tipoA+" Apuestas tipo A, total: "+ (tipoA*Apuesta.VALOR_APUESTA) +"\n");
        stringBuilder.append(tipoB+" Apuestas tipo B, total: "+ (tipoB*Apuesta.VALOR_APUESTA) +"\n");
        stringBuilder.append(tipoC+" Apuestas tipo C, total: "+ (tipoC*Apuesta.VALOR_APUESTA) +"\n");
        return stringBuilder.toString();
    }

    public String sortear(String numGanador) throws FondosInsuficientesException {
        //se debe validar  cuantos ganadores hay por  el numero ganador  y dividir el premio en partes iguales

        List<Apuesta> apuestasGanadorasTipoA = new ArrayList<>();
        List<Apuesta> apuestasGanadorasTipoB = new ArrayList<>();
        List<Apuesta> apuestasGanadorasTipoC = new ArrayList<>();

        // las siguientes variables son para determinar la cantidad de apuestas realizadas por tipo
        int tipoA = 0;
        int tipoB = 0;
        int tipoC = 0;


        for (Apuesta apuesta : apuestas) {
            if( apuesta.esGanador(numGanador) ){
                switch (apuesta.getTipoApuesta()){
                    case 'A': apuestasGanadorasTipoA.add(apuesta); break;
                    case 'B': apuestasGanadorasTipoB.add(apuesta); break;
                    case 'C': apuestasGanadorasTipoC.add(apuesta); break;
                }
            }
             // otra forma de obtener la lista de ganadores por tipo
             // apuestasGanadorasTipoA = apuestas.stream()
     //               .filter( apuesta -> apuesta.getTipoApuesta()=='A')
//                    .filter( apuesta -> apuesta.esGanador(numGanador)).collect(Collectors.toList());


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

        pagarGanadores(pagoTipoA,apuestasGanadorasTipoA);
        pagarGanadores(pagoTipoB,apuestasGanadorasTipoB);
        pagarGanadores(pagoTipoC,apuestasGanadorasTipoB);


        return "Ganadores :  Premio total \n"
                + apuestasGanadorasTipoA.size() + " Tipo A     $" + pagoTipoA + "\n"
                + apuestasGanadorasTipoB.size() + " Tipo B     $" + pagoTipoB + "\n"
                + apuestasGanadorasTipoC.size() + " Tipo C     $" + pagoTipoC + "\n" ;
    }

    private void pagarGanadores(double pago, List<Apuesta> apuestasGanadoras) throws FondosInsuficientesException {
        double premio = pago / apuestasGanadoras.size();
        for (Apuesta apuesta: apuestasGanadoras ) {
            apuesta.getCuenta().incrementarSaldo(premio);
        }
        obterCuentaCasa().restarSaldo(pago);
    }


}

