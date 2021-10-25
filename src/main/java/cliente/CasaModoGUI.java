package cliente;

import cliente.utils.Console;

public class CasaModoGUI {
    public static void main(String[] args) {
        Console.MODO_TEXTO = false;
        Casa casa = new Casa();
        try {
            casa.menuCliente();
        } catch (Exception e) {
            Console.mostarMensaje("ERROR INESPERADO :"+e.getMessage());
        }
    }

}
