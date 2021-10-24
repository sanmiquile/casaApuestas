package sockets.a_echo;


import java.net.ServerSocket;
import java.net.Socket;

public class EchoTCPServer {
	
 public static final int PORT =3400;
 
 private ServerSocket  listener;
 private Socket ServerSideSocket;
 
   public EchoTCPServer(){
	   
	   System.out.println("Echop TCP server is running on port: "+ PORT);
   }
   
   private void init() throws Exception {
	   listener = new ServerSocket(PORT);
	   
	   while(true) {
		   ServerSideSocket = listener.accept();
           System.out.println("LLEGO CLIENTE ...");
		   EchoTCPServerProtocol.protocol(ServerSideSocket);
	   }
	 
   
   }	   
   
   public  static void main(String args[])throws Exception{
	   EchoTCPServer es= new EchoTCPServer();
	   es.init();
	    
  }
   
}

