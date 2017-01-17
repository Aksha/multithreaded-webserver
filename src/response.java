import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.util.Date;


public class response {
	request httpRequest; //this is the http reuest that is passed in to the constructor from the connection handler
	
	String response; //this gets generated on the output screen
	
	String root = "/Users/Aks/Desktop/all\\ files/projects/Server/bin/root"; // this is the folder in which all the server's files will be present.
	public response(request request) { //constructor for response.
		httpRequest = request;
		
		//to read the html file to be displayed on the browser.
		File file = new File(root + request.filename);
		
		try{
		
		//to read the contents of html file to be displayed on the browser.		
		FileInputStream fis = new FileInputStream(file);
		
		/*When this request message reaches the server, the server can take either one of these actions:
			The server interprets the request received, maps the request into a file under the server's document directory, and returns the file requested to the client.
			The server interprets the request received, maps the request into a program kept in the server, executes the program, and returns the output of the program to the client.
			The request cannot be satisfied, the server returns an error message.*/
		
		
		response = "HTTP/1.1 200 OK \r \n   Server: Our Java Server/1.0 \r\n" ; // HTTP response status
		response += "Content-Type: text/html \r \n";
		response += "Content-Length: " + file.length() + "\r \n"; //HTTP response message header
		
		
		int eofLineCheck;
			while( (eofLineCheck = fis.read()) != -1) {
				response += (char) eofLineCheck; //HTTP response message
			}	
			
		}
		catch(FileNotFoundException e){
			response = response.replace("200", "400"); // file not found status is returned	
		}
		catch(Exception e) {
			response = response.replace("200", "500"); // Internal server error
		}
		
		
	}
}
