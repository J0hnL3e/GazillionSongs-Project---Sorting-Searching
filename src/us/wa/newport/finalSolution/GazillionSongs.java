package us.wa.newport.finalSolution;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;
public class GazillionSongs 
//Client Code [Gets input file name, command, and output file name and performs command's function]
{
	public static void main(String[] args) throws FileNotFoundException {
		//Greeting!!
        System.out.println("Hello user! Welcome to the Song Program which will sort and filter a database of songs");
        Scanner console = new Scanner(System.in);
        System.out.print("Please enter input file: ");
        String inputFileName = console.nextLine();
        File file = new File(inputFileName);
        //Checking for file existence before file creation
        while (file.exists() == false){
            System.out.println("Input file does not exist. Please enter an existing file name");
            System.out.print("Please enter correct input file: ");
            inputFileName = console.nextLine();
            file = new File(inputFileName);
        }
        Scanner in = new Scanner(file);
        SongCollection main = new SongCollection();
        //Continuous addition of Song if data present
        while (in.hasNextLine()){
            main.addSong(in.nextLine());
        }
        System.out.print("Please enter filter/sort command: ");
        String command = console.nextLine();
        String[] commandParts = command.split(":");
        //System exit without proper command format
        //Branching of function depending on command
        if (commandParts[0].equals("filter"))
            main.filter(commandParts[1], commandParts[2]);
        else if (commandParts[0].equals("insertionSort"))
            main.insertionSort(commandParts[1]);
        else if (commandParts[0].equals("selectionSort"))
            main.selectionSort(commandParts[1]);
        else if (commandParts[0].equals("mergeSort"))
            main.mergeSort(commandParts[1]);
        else {
            System.out.println("Incorrect sort/filer command. Exiting...");
        }
        System.out.print("Please enter output file: ");
        String outputFileName = console.nextLine();
        //Check for incorrect/invalid output file name
        if (outputFileName.contains(":"))
        	System.out.println("Incorrect file name. Exiting...");
        else{
        	 File outFile = new File(outputFileName);
        	 //Confirm overwrite only when file exists and user says yes
        	 if (outFile.exists() == true){
        		 System.out.print("Overwrite existing text? ");
        		 if (console.next().equals("Yes")){
        			 PrintStream output = new PrintStream(new File(outputFileName));
        			 main.printSongs(output);
        			 System.out.println("File successfully overwritten");
        		 }
        	 }
        	 else {
        		 PrintStream output = new PrintStream(new File(outputFileName));
        		 main.printSongs(output);
        	 }
        	 //Closing scanners/System for no resource leak
        	 console.close();
        	 in.close();
        	 System.gc();
        
        }
	}
}
