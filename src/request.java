
public class request {
	
	String filename;
	
	//This is a constructor for processing the http request that accepts a string
	public request(String reqS) {
		//First line of the http request consists of three parts.  1 - request type, 2 - filename and 3- http version.  
		//To extract the filename, I am performing a split on each line and then taking the second word of the first line 
		// under the string variable "filename".
		String lines[] = reqS.split("\n");
		lines = lines[0].split(" ");
		filename = lines[1];
		
	}

}
