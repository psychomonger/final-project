/***********************************************************************
 * George E. Mitchell
 * 202330 Software Development I CEN-3024C-32552
 * Final Project | Word Occurences
 * 
 * This class handles all database related functionality.
 * 
 * @author George E. Mitchell
 * @since 07/14/2023
***********************************************************************/
package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * This class handles all database related functionality.
 * 
 * @author George E. Mitchell
 * @since 07/14/2023
 */
public class JDBC {
	
	Connection con;
	Statement statement;
	String url = "jdbc:mysql://localhost:3306/textanalyzer";
	String uname = "javauser";
	String password = "password";
	
	
	/**
	 * This method opens the connection to the database.
	 * 
	 * @throws SQLException, ClassNotFoundException
	 * @author George E. Mitchell
	 * @since 07/14/2023
	 */
	public void connect() throws SQLException, ClassNotFoundException {		

		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, uname, password);
		statement = con.createStatement();
		
	}
	
	/**
	 * This method clears the database table for next load.
	 * 
	 * @throws SQLException
	 * @author George E. Mitchell
	 * @since 07/14/2023
	 */
	public void clearWords() throws SQLException {
		
		String sql = "delete from words";
		statement.executeUpdate(sql);
		
	}
	
	
	/**
	 * This method inserts a word into the Word table.
	 * 
	 * @param id
	 * @param word
	 * @throws SQLException
	 * @author George E. Mitchell
	 * @since 07/14/2023
	 */
	public void insertWords(int id, String word) throws SQLException  {
		
		String sql = "INSERT INTO words (ID, WORD) VALUES(" + id + ", '" + word + "')";
		statement.executeUpdate(sql);

	}
	
	
	/**
	 * This method gets the results from the database for display in the GUI.
	 * 
	 * @param numResultsToOutput
	 * @return rs ResultSet
	 * @throws SQLException
	 * @author George E. Mitchell
	 * @since 07/14/2023
	 */
	public ResultSet getResults(int numResultsToOutput) throws SQLException {
	
		String sql = "select word, count(1) as wordCount from words group by word order by wordCount desc limit " + numResultsToOutput;
		ResultSet rs = statement.executeQuery(sql);
		return rs;
			
	}
	
	
	/**
	 * This method closes the database connection.
	 * 
	 * @throws SQLException
	 * @author George E. Mitchell
	 * @since 07/14/2023
	 */
	public void close() throws SQLException {
		statement.close();
		con.close();
	}

}
