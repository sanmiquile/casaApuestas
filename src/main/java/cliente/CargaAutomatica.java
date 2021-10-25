package cliente;

import cliente.operaciones.*;
import cliente.sockets.TCPClient;
import cliente.sockets.TCPClientProtocol;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class CargaAutomatica {
    public static void main(String[] args) {
        if( args.length < 1 ){
            System.out.println("Falta el nombre del archivo");
            return;
        }
        File file = new File(args[0]);
        if( !file.exists() ){
            System.out.println("El archivo "+args[0]+" no existe");
            return;
        }



        CargaAutomatica clienteModoText = new CargaAutomatica();
        try {
            clienteModoText.procesarArchivo(file);
        } catch (Exception e) {
            System.out.println("ERROR INESPERADO :"+e.getMessage());
        }
    }

    private void procesarArchivo(File file) throws Exception {
        TCPClient tcpClient = new TCPClient();

        BufferedReader bufferedReader = new BufferedReader( new FileReader(file));

        String linea;
        String [] lineas;
        String siguienteLinea = null;
        do {
            if( siguienteLinea != null ){
                linea = siguienteLinea;
                siguienteLinea = null;
            } else {
                linea = bufferedReader.readLine();
            }

            if( linea!= null && !"".equals(linea.trim()) ){
                if(! "CERRAR".equals(linea) ){
                    lineas = new String[1];
                    lineas[0] = linea;
                } else {
                    siguienteLinea = bufferedReader.readLine();
                    if( "SI".equals(siguienteLinea) || "NO".equals(siguienteLinea)){
                        lineas = new String[2];
                        lineas[0] = linea;
                        lineas[1] = siguienteLinea;
                        siguienteLinea = null;
                    } else {
                        lineas = new String[1];
                        lineas[0] = linea;
                    }
                }
                ProcesarCargaAutomatica procesarCargaAutomatica = new ProcesarCargaAutomatica(lineas);
                tcpClient.init(procesarCargaAutomatica);
                lineas = null;
            }
        }while (linea!= null && !"".equals(linea.trim()));
        bufferedReader.close();
    }



}
