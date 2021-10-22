package logica;
import java.util.HashMap;
import java.util.Set;
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
        boolean  bandera= false;
        cuenta = new Cuenta(infoUsuario, numCuenta, saldo);
        String[] palabras = infoUsuario.split(",");
        String nuevoInfoUsiario=palabras[1].trim().toUpperCase();


        Set<String> nombresUsuario=mapCuentasUsuario.keySet();

        for (String key: nombresUsuario){

            if (key.equals(nuevoInfoUsiario)){
               // Mensaje  que confirma que un usuario con el mismo nombre ya  a creado una cuenta
                mensaje="";
                  bandera= true;

            }
            else if (bandera ==false){
                numCuenta++;
                cuenta.getSaldo();
                cuenta.getNumeroCuenta();
                mapCuentasUsuario.put(nuevoInfoUsiario,cuenta);

                mensaje="";


            }


        }










        return mensaje;
    }




}

