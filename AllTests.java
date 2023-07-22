/***********************************************************************
 * George E. Mitchell
 * 202330 Software Development I CEN-3024C-32552
 * Final Project | Word Occurences
 * 
 * This JUnit test suite automates the various application unit tests.
 * 
 * @author George E. Mitchell
 * @since 07/14/2023
***********************************************************************/
package application;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


/**
 * This class is used to automate the various application unit tests.
 * 
 * @author George E. Mitchell
 * @since 07/14/2023
 */
@Suite
@SelectClasses({ 
		ConvertText2ArrayTest.class, 
		ReadFileAsStringTest.class 
})
public class AllTests {}


