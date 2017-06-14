package implementation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Class with static methods used in reading, parsing and writing ArnoldC files
 * 
 * @author Tudor Paraschivescu
 */
public class ArnoldCFileParser {
	
	/** The Constant COUNT_ARNOLD_WORDS. */
	public static final int COUNT_ARNOLD_WORDS = 24;
	
	/** The Constant ARNOLDC_WORDS. */
	public static final String[] ARNOLDC_WORDS = {
			"BECAUSE I'M GOING TO SAY PLEASE",		// 0. If
			"BULLSHIT",								// 1. Else
			"YOU HAVE NO RESPECT FOR LOGIC",		// 2. EndIf
			"STICK AROUND",							// 3. While
			"CHILL",								// 4. EndWhile
			"GET UP",								// 5. PlusOperator
			"GET DOWN",								// 6. MinusOperator
			"YOU'RE FIRED",							// 7. MultiplicationOperator
			"HE HAD TO SPLIT",						// 8. DivisionOperator
			"I LET HIM GO",							// 9. ModuloOperator
			"YOU ARE NOT YOU YOU ARE ME",			// 10. EqualTo
			"LET OFF SOME STEAM BENNET",			// 11. GreaterThan
			"CONSIDER THAT A DIVORCE",				// 12. Or 
			"KNOCK KNOCK",							// 13. And
			"HEY CHRISTMAS TREE",					// 14. DeclareInt
			"YOU SET US UP",						// 15. SetInitialValue
			"IT'S SHOWTIME",						// 16. BeginMain
			"YOU HAVE BEEN TERMINATED",				// 17. EndMain
			"TALK TO THE HAND",						// 18. Print
			"GET TO THE CHOPPER",					// 19. AssignVariable
			"HERE IS MY INVITATION",				// 20. SetValue
			"ENOUGH TALK",							// 21. EndAssignVariable
			"@I LIED",								// 22. False
			"@NO PROBLEMO"							// 23. True
	};
	
	/**
	 * Read from a file and return an array list with the lines of the file.
	 *
	 * @param inputFile The input file
	 * @return An array list of Strings (representing the lines of the file)
	 * with an integer code (representing the code
	 * of the ArnoldC expression).
	 */
	static ArrayList<StringWithIntCode> readFrom(File inputFile) {
		
		BufferedReader reader;
		
		try {
			// Instantiate the input stream
			reader = new BufferedReader(new FileReader(inputFile));
		}
		catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException! - "
							+ "The input file does not exist");
			return null;
		}
		
		// An array list with the lines of the input file
		ArrayList<StringWithIntCode> inputLines = 
									new ArrayList<StringWithIntCode>();
		
		try {
			String newLine;
			StringWithIntCode newLineWithIntCode;
			
			// Read each line
			while ((newLine = reader.readLine()) != null) {
				
				// Remove the irrelevant lines
				newLineWithIntCode = removeNonsense(newLine);
				
				// Add the new line to the list (if it is not null)
				if (newLineWithIntCode != null) {
					inputLines.add(newLineWithIntCode);
				}
			}
			
			// Close the input stream
			reader.close();
		}
		catch (IOException e) {
			System.out.println("IOException! - An I/O error occured");
			return null;
		}
		
		return inputLines;
	}
	
	/**
	 * Remove the nonsense from a String.
	 *
	 * @param line The String from which the nonsense must be removed
	 * (nonsense = too many white spaces and useless shit)
	 * @return The transformed String (nonsense free, how Arnold likes it)
	 *  or null (if it's only full of nonsense)
	 */
	static StringWithIntCode removeNonsense(String line) {
		
		// Remove all useless white spaces
		line = line.trim().replaceAll(" +", " ");
		
		// The code of the Arnold expression
		int nrOfExpression = -1;
		for (int i = 0; i < COUNT_ARNOLD_WORDS; i++) {
			if (line.startsWith(ARNOLDC_WORDS[i])) {
				// THOSE ARE MY WORDS
				nrOfExpression = i;
				break;
			}
		}
		
		if (nrOfExpression == -1) {
			// THAT'S COMPLETE BULLSHIT
			return null;
		}
		
		// THIS IS ARNOLD SPEAKING
		return new StringWithIntCode(line, nrOfExpression);
	}
	
	/**
	 * Write a text in a newly created output file.
	 *
	 * @param text The text
	 * @param outputFile The output file
	 */
	public static void writeTo(String text, String outputFile) {
		
		try {
	        File file = new File(outputFile);
	        Writer output = new BufferedWriter(new FileWriter(file));

	        // Write the text
	        output.write(text);

	        // Close the stream
	        output.close();
	    }
		catch(Exception e) {
	        System.out.println("Could not create file");
	    }
	}

}
