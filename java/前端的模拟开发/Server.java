package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	public static void main(String[] args) {
		ServerSocket server;
		try {
			server = new ServerSocket(1214);
			while(null==server||!server.isClosed()) {
				Socket client=server.accept();
				new Thread(new Dispatcher(client)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
