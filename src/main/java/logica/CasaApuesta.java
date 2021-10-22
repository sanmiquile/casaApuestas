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
     static private double saldo=0.0;



    public static String crearCuenta (String infoUsuario ) {
        String mensaje=" ";
        boolean  bandera= false;
        cuenta = new Cuenta(infoUsuario, numCuenta, saldo);
        String[] palabras = infoUsuario.split(",");
        String nuevoInfoUsuario=palabras[1].trim().toUpperCase();


        Set<String> nombresUsuario=mapCuentasUsuario.keySet();
        System.out.println("validacion de la informacion usuario"+ nuevoInfoUsuario);
        for (String key: nombresUsuario){

            if (key.equals(nuevoInfoUsuario)){
               // Mensaje  que confirma que un usuario con el mismo nombre ya  a creado una cuenta
                  mensaje="La cuenta no ha sido creada, ya se encuentra registrado un usuario con el mismo nombre";
                  bandera= true;
                  return mensaje;

            }
            else if (bandera ==false){
                numCuenta++;
                cuenta.getSaldo();
                cuenta.getNumeroCuenta();
                mapCuentasUsuario.put(nuevoInfoUsuario,cuenta);

                 mensaje="La cuenta se ha creado exitosamente /n "+ "[Server] Cliente: "+ nuevoInfoUsuario +"," +numCuenta +","+ saldo;
                System.out.println(mapCuentasUsuario);
               return mensaje;
            }


        }


        return mensaje;

    }




}

