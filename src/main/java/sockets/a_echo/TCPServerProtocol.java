package sockets.a_echo;

import logica.EjecutarOperacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPServerProtocol {
	private PrintWriter toNetwork;
	private BufferedReader fromNetwork;

	public void protocol(Socket socket)throws IOException{
	   
		createStreams(socket);
		
		String message= fromNetwork.readLine();
		System.out.println("MENSAJE DEL CLIENTE: "+message);
		EjecutarOperacion ejecutarOperacion = new EjecutarOperacion();
		String answer= ejecutarOperacion.ejecutar(message,toNetwork,fromNetwork);
		System.out.println("RESPONDIENDO: "+answer);
		toNetwork.println(answer);
		socket.close();
	}

	private void createStreams(Socket socket)throws IOException{
		toNetwork= new PrintWriter(socket.getOutputStream(), true);
		fromNetwork= new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

}
