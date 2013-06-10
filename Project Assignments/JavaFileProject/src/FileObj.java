import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * The representation of the File Object that is obtained 
 * from the specified directory.
 */
public class FileObj
{
	// Declaration of the private fields of the Field Object.
	private File file;
	private static int fileNum = 0;  // Counter of the total number of objects created.

        /**
         * The constructor method instantiates the File Object of the .
         * @param f The file that is passed to the the Object.
         */
	public FileObj(File f)
	{
		file = f;
		fileNum++;
	}

        /**
         * The getObjectNum method returns the current number of the object.
         */
	public static int getObjNum()
	{
		return fileNum;
	}

        /**
         * The readFile method reads the group text data from the file, 
         * extracts hexadecimal ID values and compares them to the HashSet values.
         * If the HashSet contains ID, the counter is incremented, the data 
         * are passed to the file writer for the final activity output.
         * @throws IOException is thrown if the file does not exist.
         */
	public void readFile() throws IOException
	{
		int count = 0;			

		// Open the File.
		Scanner inputFile = new Scanner(file);

		// Read Lines from the file until the end of file.
		while(inputFile.hasNext())
		{
			// Read the next line.
			String line = inputFile.nextLine();

			// Split the String containing the hexadecimal number of each file 
			// and compare it to the TuesdayActiveIDs.log.
			String[] splitter = line.split(" ");
			for(int i = 0; i < splitter.length; i++)
				if(splitter[i].length() == 7)
					if((JavaIOApp.hexNumSet).contains(splitter[i]))
						count++;
		}

		// Close the File
		inputFile.close();
                
                // appends the counter to the activity file.
		appendToFile(file.getName() + " has " + count + " active hexadecimal ID matches!");
	}

       /**
        * The appendFile method writes data to the end of the file.
        * @throws IOException If the file is not found.
        */
	private void appendToFile(String str) throws IOException
	{
		// Open the file.
		
		String file = "/home/vladimir/Desktop/We-Care.ComFileProject/ActiveCountByGroup.txt";

		FileWriter fileWriter = new FileWriter(file, true);
		PrintWriter outputFile = new PrintWriter(fileWriter);

		// Write the data to the file.
		outputFile.println(str);
		
		// Close the file.
		outputFile.close();
	}
        
       /**
        * The toString method overrides the toString method and displays the state of the object.
        */
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("File " + "Name is " + file.getName() + "!");
		return builder.toString();
	}
}