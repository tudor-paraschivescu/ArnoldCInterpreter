import java.io.File;
import java.io.FilenameFilter;

import implementation.AbstractSyntaxTree;
import implementation.ArnoldCFileParser;
import implementation.InterpretTreeVisitor;
import implementation.PrintTreeVisitor;

/**
 * The class that tests the project
 * 
 * @author Tudor Paraschivescu
 */
public class TestProject {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		// The input directory
		File inputDir = new File("tests");
		
		// The input files
		File[] inputFiles = inputDir.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.endsWith(".ac");
		    };
		});
		
		// The output directory
		File outputDir = new File("output");
		
		// Create the output directory
		outputDir.mkdirs();
		
		for (int i = 0; i < inputFiles.length; i++) {
			
			// Create the names of the output files
			String outFileName = "output/" + 
							inputFiles[i].getName().replace(".ac", ".out");
			String astFileName = "output/" +
							inputFiles[i].getName().replace(".ac", ".ast");
			
			// Create the AST
			AbstractSyntaxTree AST = new AbstractSyntaxTree(inputFiles[i]);
			
			// Instantiate the visitors
			PrintTreeVisitor printVisitor = new PrintTreeVisitor();
			InterpretTreeVisitor interpretVisitor = new InterpretTreeVisitor();
			
			// Get the ASTree structure and write it to file
			String astOutput = printVisitor.printAST(AST.getMainNode(), 1);
			ArnoldCFileParser.writeTo(astOutput, astFileName);
			
			// Get the output and write it to file
			String outOutput = interpretVisitor.interpretAST(AST.getMainNode());
			ArnoldCFileParser.writeTo(outOutput, outFileName);
		}
	}

}
