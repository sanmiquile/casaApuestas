package cliente.sockets;

import java.net.Socket;

public class TCPClient {
	public static final int PORT=19421;
	public static final String SERVER="8.tcp.ngrok.io";
	private Socket clientSideSocket;

	public void init(TCPClientProtocol tcpClientProtocol)throws Exception {
		 clientSideSocket= new Socket(SERVER,PORT);
		 tcpClientProtocol.protocol(clientSideSocket);
		 clientSideSocket.close();
	}

}
