package cliente.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public abstract class TCPClientProtocol {

	protected PrintWriter toNetwork;
	protected BufferedReader fromNetwork;
	
	public void protocol(Socket socket)throws Exception{
		createStreams(socket);
		ejecutar();
	}

	public abstract void ejecutar() throws IOException;

	private void createStreams(Socket socket)throws IOException{
		 toNetwork=new PrintWriter(socket.getOutputStream(),true);
		 fromNetwork=new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

}
