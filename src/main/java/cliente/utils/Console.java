package cliente.utils;

import java.util.Scanner;

public final class Console {
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

    public static String capturarStringConsola() {
        String opi = "";
        Scanner lectura = new Scanner(System.in);
        opi = lectura.nextLine();
        return opi;
    }
}
