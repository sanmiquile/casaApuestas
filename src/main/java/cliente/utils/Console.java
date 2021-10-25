package cliente.utils;

import javax.swing.*;
import java.util.Scanner;

public final class Console {
    public static boolean MODO_TEXTO = true;

    public static int capturarIntConsola() {
        int opi = 0;
        Scanner lectura = new Scanner(System.in);
        opi = lectura.nextInt();
        return opi;
    }

    public static double capturarDoubleConsola() {
        double opi = 0;
        System.out.println("Ingrese su nombre y apellido: ");
        Scanner lectura = new Scanner(System.in);
        opi = lectura.nextDouble();
        return opi;
    }

    public static String leerDato(String mensaje) {
        if( MODO_TEXTO ){
            return leerDatoTexto(mensaje);
        }
        return leerDatoGUI(mensaje);
    }

    public static void mostarMensaje(String mensaje){
        if( MODO_TEXTO ){
            System.out.println(mensaje);
        } else {
            JOptionPane.showMessageDialog(null,mensaje);
        }
    }

    public static String leerDatoTexto(String mensaje) {
        System.out.println(mensaje);
        return capturarStringConsola();
    }

    public static String leerDatoGUI(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }

    public static String capturarStringConsola() {
        String opi = "";
        Scanner lectura = new Scanner(System.in);
        opi = lectura.nextLine();
        return opi;
    }
}
