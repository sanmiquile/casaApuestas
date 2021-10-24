package cliente.sockets;

import java.net.Socket;

public class TCPClient {
	public static final int PORT=3400;
	public static final String SERVER="localhost";
	private Socket clientSideSocket;

	public void init(TCPClientProtocol tcpClientProtocol)throws Exception {
		 clientSideSocket= new Socket(SERVER,PORT);
		 tcpClientProtocol.protocol(clientSideSocket);
		 clientSideSocket.close();
	}

}
