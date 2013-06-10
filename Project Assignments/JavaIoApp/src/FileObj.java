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
         * The constructor method instantiates the File Object.
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
         * The readFile method reads the contents of the File Object.
         * @throws IOException if file is not found.
         */
	public void readFile() throws IOException
	{
		// Open the file.
		Scanner inputFile = new Scanner(file);
		
		// Read lines from the file until the end of the file.
		while(inputFile.hasNext())
		{
			// Read the next name.
			String line = inputFile.nextLine();
			
			// Display the line.
			System.out.println(line);
		}

		// Close the file.
		inputFile.close();
		System.out.println("Data read from the file!");
	}

	/**
         * The writeFile method writes info to the file.
         * @throws IOException 
         */
	public void writeToFile() throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		String str;

		// Enter the information to the file.
		do
		{
			System.out.print("Enter information to be entered in a file: ");
			str = keyboard.nextLine();
		}
		while(str == null || str.length() <= 0);	

		// Open the file.
		PrintWriter outputFile = new PrintWriter(file);

		// Write the data to the file.
		outputFile.println(str);
		
		// Close the file.
		outputFile.close();
		System.out.println("Data written to the file!");
	}

	/**
         * The appendFile method writes data to the end of the file.
         * @throws IOException If the file is not found.
         */
	public void appendToFile() throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		String str;

		// Enter the information to the file.
		do
		{
			System.out.print("Enter information to be appended to a file: ");
			str = keyboard.nextLine();
		}
		while(str == null || str.length() <= 0);	

		// Open the file.
		FileWriter fileWriter = new FileWriter(file, true);
		PrintWriter outputFile = new PrintWriter(fileWriter);

		// Write the data to the file.
		outputFile.println(str);
		
		// Close the file.
		outputFile.close();
		System.out.println("Data appended to the file!");
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