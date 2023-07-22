/***********************************************************************
 * George E. Mitchell
 * 202330 Software Development I CEN-3024C-32552
 * Final Project | Word Occurences
 * 
 * This class tests if a file manager object is able to
 * read a text file into a string.
 * 
 * @author George E. Mitchell
 * @since 07/14/2023
***********************************************************************/
package application;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test; 


/**
 * Tests if TextAnalyzer object successfully read
 * a text file into a string.
 * 
 * @author George E. Mitchell
 * @since 07/14/2023
 */
class ReadFileAsStringTest {

	@Test
	void test() {
		
		FileManager fm = new FileManager();
		String fileURL = "C://TheRavenPoemWithHTMLTags.txt";
		String contents = "";
		String hasContents = "N";
		int contentsLength = 0;
		
		contents = fm.readFileAsString(fileURL);
		contentsLength = contents.length();
		if(contentsLength > 0) { hasContents = "Y"; }
		
		assertEquals("Y", hasContents);
	
	}

}
