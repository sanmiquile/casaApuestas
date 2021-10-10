package sockets.a_echo;

import java.net.Socket;

public class EchoTCPClient {
	public static final int PORT=17091;
	public static final String SERVER="2.tcp.ngrok.io";
	
	private Socket clientSideSocket;
	
	public EchoTCPClient() {
		System.out.println("Echo TCP Client..");	
	}
	
	public void init()throws Exception {
		 clientSideSocket= new Socket(SERVER,PORT);
		 EchoTCPClientProtocol.protocol(clientSideSocket);
		 
		 clientSideSocket.close();
	}
	
	public static  void  main (String args[])throws Exception {
		
		EchoTCPClient ec= new EchoTCPClient();
		
		  ec.init();		
	}

}
