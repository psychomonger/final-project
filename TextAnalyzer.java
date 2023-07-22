/***********************************************************************
 * George E. Mitchell
 * 202330 Software Development I CEN-3024C-32552
 * Final Project | Word Occurences
 * 
 * This class handles the methods related to manipulating text.
 * 
 * @author George E. Mitchell
 * @since 07/14/2023
***********************************************************************/
package application;
import java.util.Arrays;

/**
 * This class handles the methods related to the manipulating of text.
 * 
 * @author George Mitchell
 * @since 07/14/2023
 */
public class TextAnalyzer {
	
	/**
	 * This method strips out the text for review from an HTML document.
	 * 
	 * @param html String of the raw text from HTML document.
	 * @param startOfTextDelim String that identifies the start of the text to process.
	 * @param endOfTextDelim String that identified the end of the text to process.
	 * @return String String of words derived from an HTML document.
	 * @author George Mitchell
	 * @since 07/14/2023
	 */
	public String getTextFromHTML(String html, String startOfTextDelim, String endOfTextDelim) {
		
		int posStartOfPoem = 0;
		int posEndOfPoem = 0;
		String text = null;
		
		// Get position of the start of the poem.
		posStartOfPoem = html.indexOf(startOfTextDelim);
		
		// Remove ALL text prior to the start of the poem.
		html = html.substring(posStartOfPoem);
		
		// Get position of end of the poem.
		posEndOfPoem = html.indexOf(endOfTextDelim);
				
		// Remove ALL text after the end of the poem.
		html = html.substring(0, posEndOfPoem);
		
		// Convert all HTML tags to spaces		
		html = html.replaceAll("<[^>]*>", " ");
		
		// Remove all line breaks.
		html = html.replace("\n", "").replace("\r", "");
		
		// Remove all non-alpha characters.
		html = html.replaceAll("[^A-Za-z0-9]", " ");
		
		// Replace all multiple spaces with a single space.
		html = html.trim().replaceAll(" +", " ");
		
		// Convert text to lower case.
		text = html.toLowerCase();
		
		// Return text.
		return text;
	
	}
	
	/**
	 * This method converts a text string of words to an array of words.
	 * 
	 * @param text String of words to be converted to an array.
	 * @return Array of strings.
	 * @author George Mitchell
	 * @since 07/14/2023
	 */
	public String[] convertText2Array(String text) {
		
		String[] array = null;
		array = text.split(" ");
		Arrays.sort(array);
		
		return array;
	}	
	
}
