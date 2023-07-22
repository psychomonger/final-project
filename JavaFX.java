/***********************************************************************
 * George E. Mitchell
 * 202330 Software Development I CEN-3024C-32552
 * Final Project | Word Occurences
 * 
 * This application reads an HTML file to extract a poem for analysis;
 * specifically to count the number of occurrences of each word and
 * output a list of the most used words. This is achieved by inserting
 * each word into a database table and then querying the 20 most
 * frequently used.
 * 
 * @author George E. Mitchell
 * @since 07/14/2023
***********************************************************************/
package application;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font; 
import javafx.scene.text.FontWeight; 
import javafx.scene.Group;
import javafx.scene.text.FontPosture;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.TextField; 


/**
 * This class produces the application's GUI interface.
 * 
 * @author George E. Mitchell
 * @since 07/14/2023
 */
public class JavaFX extends Application implements EventHandler<ActionEvent> {
	
	// Declare objects.
		static Button button;
		static Text text;
		static Text text1;
		static Text text2;
		static Group root;
		static Scene scene;
		static TextArea textarea;
		static Label label;
		static Font font;
		static TextField textfield;
		static String output = "";
	
		/**
		 * Application main method.
		 * 
		 * @param args
		 * @throws SQLException
		 * @throws ClassNotFoundException
		 * @author George E. Mitchell
		 * @since 07/14/2023
		 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		// Declare and initialize required objects and variables.
		JDBC jdbc = new JDBC();
		FileManager fm = new FileManager();
		TextAnalyzer ta = new TextAnalyzer();
		
		String html = null;
		String text = null;
		String fileURL = "C://TheRavenPoemWithHTMLTags.txt";
		String startOfTextDelim = "<h1>The Raven</h1>";
		String endOfTextDelim = "<!--end chapter-->";
		int numResultsToOutput = 20;
		String[] array = null;
		
		// Get raw HTML from file.
		html = fm.readFileAsString(fileURL);
		
		// Get text from raw HTML.
		text = ta.getTextFromHTML(html, startOfTextDelim, endOfTextDelim);	
		
		// Convert text to array of words.
		array = ta.convertText2Array(text);
		
		// Connect to database.
		jdbc.connect();
		
		// Clear words table.
		jdbc.clearWords();
		
		// Iterate array of words and insert into database.
		for(int i=0; i < array.length; i++) {
			
			String word = array[i]; 
			jdbc.insertWords(i, word);
			
		}
		
		// Get results from query and prepare for output.
		ResultSet rs = jdbc.getResults(numResultsToOutput);
		while(rs.next()) {
			for(int i=1; i<=2; i++) {
				output += rs.getString(i) + " ";
			}
			output += System.lineSeparator();
		}
		
		// Close database connection.
		jdbc.close();
		
		// Launch application GUI.
    	Application.launch(JavaFX.class, args);
		
	}


	/**
	 * JavaFX start method which activates the GUI stage.
	 * 
	 * @param stage
	 * @author George E. Mitchell
	 * @since 07/14/2023
	 */
	public void start(Stage stage) throws Exception {
		
		//Create a text object. 
    	text = new Text();      
    	text.setText("The Raven Text Analyzer!"); 
    	text.setX(10); 
    	text.setY(30);
    	font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16);
    	text.setFont(font); 
    			         
    	//Create a text object. 
    	text1 = new Text();      
    	text1.setText("This program extracts the poem The Raven by Edgar Allen Poe from an HTML text file and outputs a count of the 20 most frequently used words. Click the RUN button to start the program."); 
    	text1.setX(10); 
    	text1.setY(60);
    	text1.setWrappingWidth(750);
    	font = Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 14);
    	text1.setFont(font);
    	
    	// Create button object.
    	button = new Button();
    	button.setText("RUN");
    	button.setLayoutX(10); 
    	button.setLayoutY(100);
    	button.setStyle("-fx-font: 15 arial; -fx-base: #ee2211;");
    	button.setOnAction(this);
    	
    	// Create label object.
    	label = new Label("RESULTS");
    	label.setLayoutX(10);
    	label.setLayoutY(150);
    	font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14);
    	label.setFont(font);
    	
    	// Create text object.
    	text2 = new Text();      
    	text2.setText(""); 
    	text2.setX(10); 
    	text2.setY(200);
    	font = Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 14);
    	text2.setFont(font);
    			  			            
    	//Creating a Group object   
    	root = new Group(text, text1, label, text2, button);   
   			               
    	//Creating a scene object 
    	scene = new Scene(root, 800, 800);  
    	      
    	//Setting title to the Stage 
    	stage.setTitle("Final Project | Word Occurences"); 
    			         
    	//Adding scene to the stage 
    	stage.setScene(scene); 
    			         
    	//Displaying the contents of the stage 
    	stage.show(); 
		
	}
	
	/**
	 * This method handles the action event related to
	 * clicking the Run button.
	 * 
	 * @override
	 * @param arg0
	 * @author George E. Mitchell
	 * @since 07/14/2023
	 */
	public void handle(ActionEvent arg0) {
		
		// Output results to GUI.
		this.outputResultsToGUI();
		
	}
	
	/**
	 * This method outputs the results to the GUI.
	 * 
	 * @author George E. Mitchell
	 * @since 07/14/2023
	 */
	public void outputResultsToGUI() {
		
		// Update GUI with results.
		text2.setText(output); 

	}
		
}