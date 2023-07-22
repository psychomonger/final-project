/***********************************************************************
 * George E. Mitchell
 * 202330 Software Development I CEN-3024C-32552
 * Final Project | Word Occurences
 * 
 * This class handles the methods related to accessing files.
 * 
 * @author George E. Mitchell
 * @since 07/14/2023
***********************************************************************/
package application;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * This class handles the methods related to access files.
 *  
 * @author George E. Mitchell
 * @since 07/14/2023
 */
public class FileManager {
	
	/**
	 * This method reads a text file into a string. 
	 * 
	 * @param fileURL String url of location of file to read.
	 * @return String string of raw text from HTML file.
	 * @author George Mitchell
	 * @since 07/14/2023
	 */
	public String readFileAsString(String fileURL) {
		
		String text = "";
		
		try {  
			
			text = new String(Files.readAllBytes(Paths.get(fileURL)));
		
		} catch (IOException e) {
			
			e.printStackTrace();	    
		
		}

	    return text;
	    
	  }
		
}
