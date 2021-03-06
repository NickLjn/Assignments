package assignment6;

import java.io.*;

public class ModifyParseMethod {
	public static void parse(File file) throws IOException{
	      RandomAccessFile input = null;
	      String line = null;
	      
	      try {
	          input = new RandomAccessFile(file, "r");
	          while ((line = input.readLine()) != null) {
	              System.out.println(line);
	          }
	          return;
	      }
	          catch(IOException e){
	        	  e.printStackTrace();
	          }
	          finally {
	            if (input != null) {
	            	try{
	                    input.close();
	                   }
	        	    catch(IOException e){
	        		    e.printStackTrace();
	        	    }
	              }
	         }
	 }
}
