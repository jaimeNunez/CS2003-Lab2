//Student: Jaime Nunez
//Date: 9/7/17
//Student ID: 1451353

package lab2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class SeatMap {
	
	//readFile()
	//populateArray()
	//getSeat()
    int numRows;
    int numCols;
    String[][] studentName = new String[numRows][numCols];
	
	public void readFile() {
		try {
		    File inputFile = new File("names.dat");
		    Scanner input = new Scanner(inputFile);
		    //String[][] studentName;

		    
		    //initialize all of the variables you will use in the readFile method
		    //String currentStudent;
		    //count should determine the number of names in the list
		    int count = 0;
		    while (input.hasNextLine()){
		    	System.out.println();
		    	count++;
		    }

		    input.close();
		    //determine the number of rows needed
		    //the number of rows will always be 2. The number of colums will change depending on how large the list of names is. 
		    if(count % 2 == 0)
		    {
		    	numRows = 2;
		    	numCols = (count/2);
		    }
		    //otherwise the count is odd so we need to create one extra row
		    else
		    {
		    	numRows = 2;
		    	//since the number of colums will be odd, add 0.5 to make it an integer. This will give us an extra seat
		    	numCols = (int) ((count/2) + 0.5);
		    }
		    
		    //String[][] studentName = new String[numRows][numCols];
		    
		    // store all elements in a 2-D array
		    //while the input file has another student name, add that student to the 2D array
		    while (input.hasNextLine()){
		    	String currentStudent;
		    	currentStudent = input.nextLine();
		    	for(int idx = 0; idx < numRows; idx++)
				{
					for(int i = 0; i < numCols; i++)
					{
						studentName[idx][i] = currentStudent;
					}
				}
		    }
		}
		
		catch (IOException e) {
		    System.err.println("IOException in reading input file!!!");
		}	
	    } //end readFile()

	//public void populateArray(){
		//String currentStudent;
		//File inputFile = new File("names.dat");
	    //Scanner input = new Scanner(inputFile);
	    //while (input.hasNextLine()){
	    //	currentStudent = input.nextLine();
	    //	for(int idx = 0; idx < numRows; idx++)
		//	{
		//		for(int i = 0; i < numCols; i++)
		//		{
		//			studentName[idx][i] = currentStudent;
		//		}
		//	}
	    //}
	//}
	
	public String getSeat(int i, int j)
	{
		String name = studentName[i][j];
		return name;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SeatMap seatingChart = new SeatMap();
		System.out.println("Please enter the seat you want. It should be in the form, 'row number, colums number'");
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		System.out.println(seatingChart.getSeat(x,y));

		//System.out.println(getSeat());
	}

}
