package cliente;

import cliente.utils.Console;

public class ClienteModoText {
    public static void main(String[] args) {
        Console.MODO_TEXTO = true;
        Cliente cliente = new Cliente();
        try {
            cliente.menuCliente();
        } catch (Exception e) {
            Console.mostarMensaje("ERROR INESPERADO :"+e.getMessage());
        }

    }
}
