package sockets.a_echo;


import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	
 public static final int PORT =3400;
 
 private ServerSocket  listener;
 private Socket ServerSideSocket;
 
   public TCPServer(){
	   
	   System.out.println("Echop TCP server is running on port: "+ PORT);
   }
   
   private void init() throws Exception {
	   listener = new ServerSocket(PORT);
	   
	   while(true) {
		   ServerSideSocket = listener.accept();
           System.out.println("LLEGO CLIENTE ...");
		   new TCPServerProtocol().protocol(ServerSideSocket);
	   }
	 
   
   }	   
   
   public  static void main(String args[])throws Exception{
	   TCPServer es= new TCPServer();
	   es.init();
	    
  }
   
}

