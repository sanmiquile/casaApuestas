package logica;
import java.util.HashMap;
/*
 * Esta clase sera el servidor que contendra toda la informacion de operaciones del proyecto.
 */

public class CasaApuesta {
    // Se debe crear las listas y hashMap de la informaqcion de los usuarios y las apuestas.
    static  private HashMap<String,Cuenta> mapCuentasUsuario = new HashMap<String,Cuenta>();
    static  private Cuenta cuenta;
     static private int numCuenta;
     static private double saldo;



    public static String crearCuenta (String infoUsuario ) {
        String mensaje=" ";

        numCuenta++;
        cuenta = new Cuenta(infoUsuario, numCuenta, saldo);
        String[] palabras = infoUsuario.split(",");
        String nuevoInfoUsiario=palabras[1].trim().toUpperCase();








        return mensaje;
    }




}

