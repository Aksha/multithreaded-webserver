import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;



//This handles the connections with the requests from teh clients
public class ConnectionHandler extends Thread{ //Inheriting the thread making it a thread

	Socket s;
	
	//I am using this to send the output to the client from the response class.  
	PrintWriter pw;
	
	//This is to get the input from the client.
	BufferedReader br;

	public ConnectionHandler(Socket s) throws Exception{ //constructor that accepts the socket
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		pw = new PrintWriter(s.getOutputStream());
	}

	//This method gets called automatically once the thread starts
	public void run() {
		
		try {
		String reqS = "";
		
		while(br.ready() || reqS.length() == 0) //reading the request from the client.
			reqS += (char) br.read();
		
		System.out.println(reqS); //to see what the request message looks like (testing if the input is read in correctly)
		request req = new request(reqS);
		
		response res = new response(req);
		
		pw.write(res.response.toCharArray());
		
		pw.close();
		br.close();
		s.close();
		}
		catch(Exception e){
			e.printStackTrace();
		} 
		
	}

	
	
	
}
