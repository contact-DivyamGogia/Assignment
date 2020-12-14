import java.io.*;
import java.net.*;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class UpOrDown {
	
		    public static void main (String args[]) throws Exception
		    {
		    	Scanner s = new Scanner(System.in);
		    	String str = s.nextLine();
		    	String path = s.nextLine();
		    	ArrayList<Integer> StatusCode = new ArrayList<Integer>();
		        while(s.hasNextInt()){
		           StatusCode.add(s.nextInt());
		        }

		    	
		    	//Extracting text file and putting in arrayList
		    	List<String> lines = Collections.emptyList();
		        try {
		        	lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
		        	}
		        catch (IOException e) { // TODO Auto-generated catch block
		        	e.printStackTrace();
		        	}

		        //Taking URL from User
		        
		        //Checking Each URL
		        for (int i = 0; i < lines.size(); i++) {
		            str = str + lines.get(i);
		            
		            URL url = new URL(str);
		            
		            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			        connection.setRequestMethod("GET");
			        connection.connect();

			        int code = connection.getResponseCode();

			        for (int j = 0; j < StatusCode.size(); j++) {
			        	if (code==StatusCode.get(j))
				        {
				        	System.out.print(str+" ");
				        	System.out.println("[Status Code "+code+"]");
				            
				        }
			        }
			        
		            
		        }
		  }
}

