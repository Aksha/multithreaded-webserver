import java.net.ServerSocket;
import java.net.Socket;

public class Main {

		ServerSocket serverSocket;
		
		public static void main(String[] args) throws Exception{
			new Main().runServer();
		}

		private void runServer() throws Exception {
			serverSocket = new ServerSocket(6543); // THis is the port number at which the server is running.
			acceptRequests(); // Accept requests to the server
		}
		
		private void acceptRequests() throws Exception{
			while(true){ // accept all the requests from all clients
				Socket s = serverSocket.accept();
				ConnectionHandler ch = new ConnectionHandler(s);
				
				ch.start(); // starting the thread (Connection Handler class inherits a thread becoming a thread class itself.
			}
		}
		
}
