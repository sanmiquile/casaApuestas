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


    public static String crearCuenta (String nombre ) {
        String mensaje=" ";
        boolean  bandera = false;
        cuenta = new Cuenta(nombre, numCuenta, saldo);

     //   String[] palabras = infoUsuario.split(",");
     //   String nuevoInfoUsuario=palabras[1].trim().toUpperCase();

        bandera = true;
        Set<String> nombresUsuario=mapCuentasUsuario.keySet();
        System.out.println("validacion de la informacion usuario "+ nombre);
        for (String key: nombresUsuario){
        //permite comparar la llave de los objetos del hashmap
            if (key.equals(nombre)){
               // Mensaje  que confirma que un usuario con el mismo nombre ya  a creado una cuenta
                  mensaje="La cuenta no ha sido creada, ya se encuentra registrado un usuario con el mismo nombre";

                  return mensaje;

            }
            else if (bandera ==false){
                numCuenta++;
                cuenta.getSaldo();
                cuenta.getNumeroCuenta();
                mapCuentasUsuario.put(nombre,cuenta);

                 mensaje="La cuenta se ha creado exitosamente /n "+ "[Server] Cliente: "+ nombre +"," +numCuenta +","+ saldo;
                System.out.println(mapCuentasUsuario);
               return mensaje;
            }


        }


        return mensaje;

    }


    public static  String depositar(String inforUsuario){

        String mensaje=" ";
       String palabras[]=inforUsuario.split(",");
        boolean bandera=false;
        String nombreUsuario= palabras[1];
        int numCueenta = Integer.parseInt(palabras[2]);
         double   deposito= Double.parseDouble(palabras[3]);
        Cuenta auxiliar = new Cuenta(nombreUsuario,numCueenta,deposito);
        Set<String> nombresUsuario= mapCuentasUsuario.keySet();


        for (String key : nombresUsuario) {

            auxiliar = mapCuentasUsuario.get(key);

            if ( numCueenta== auxiliar.getNumeroCuenta()) {

                 double saldoUsuario= auxiliar.getSaldo();
                auxiliar.setSaldo(saldoUsuario + deposito);
                mensaje = "[Server] Depósito exitoso \n" + "Cuenta de Ahorros: " + cuenta + " - Nuevo saldo: "
                        + auxiliar.getSaldo();
                System.out.println(mapCuentasUsuario);
                bandera = true;
            }
        }

        if (bandera == false) {

            mensaje = "ERROR: No hay cuentas registradas con el número ingresado";
        }
        return mensaje;
    }



}


