package cliente;

import cliente.utils.Console;

public class CasaModoText {
    public static void main(String[] args) {
        Console.MODO_TEXTO = true;
        Casa casa = new Casa();
        try {
            casa.menuCliente();
        } catch (Exception e) {
            Console.mostarMensaje("ERROR INESPERADO :"+e.getMessage());
        }
    }

}
