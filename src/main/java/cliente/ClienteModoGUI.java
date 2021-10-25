package cliente;

import cliente.operaciones.*;
import cliente.sockets.TCPClient;
import cliente.sockets.TCPClientProtocol;
import cliente.utils.Console;

import javax.swing.*;
import java.util.Scanner;

public class ClienteModoGUI {
    public static void main(String[] args) {
        Console.MODO_TEXTO = false;
        Cliente cliente = new Cliente();
        try {
            cliente.menuCliente();
        } catch (Exception e) {
            Console.mostarMensaje("ERROR INESPERADO :"+e.getMessage());
        }
    }

}
