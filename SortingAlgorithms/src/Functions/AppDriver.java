package Functions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Objects.Cone;
import Objects.Cylinder;
import Objects.OctagonPrism;
import Objects.PentagonPrism;
import Objects.Pyramid;
import Objects.SquarePrism;
import Objects.ThreeDGeoShape;
import Objects.TrianglePrism;
import Sorting.BubbleSort;
import Sorting.InsertionSort;
import Sorting.MergeSort;
import Sorting.QuickSort;
import Sorting.SelectionSort;
import Sorting.ShakerSort;

/**
 * 
 * @author Talha Khamoor
 *
 * This class contains the main method and has the main functionalities within. Such as loading
 * the array, printing it can calling methods to sort
 *
 */
public class AppDriver {

	
	// attributes
	private static String argOne;
	private static String argTwo;
	private static String argThree;
	private static String fileName;
	private static String sortMethod;
	private static String sortBy;
	private static boolean isArgsValid;
	private static ThreeDGeoShape[] shapeArray;
	private static long start;
	private static long stop;

	/**
	 * 
	 * @param args
	 * 
	 * main method takes in args from command line and starts the program
	 */
	public static void main(String[] args) {

		try {
			
			// takes in three args
			argOne = args[0];
			argTwo = args[1];
			argThree = args[2];

			//calls method to check if the inputs are valid, a boolean!
			isArgsValid = vallidateMainArgs(argOne, argTwo, argThree);

			// if the args are valid it then calls the following methods
			if (isArgsValid) {
				loadArray();
				sortArray();
				printArray();

			} else {
				// else prints this statement
				System.out.println("Your input arguments have an issue!");
			}

			// catching exceptions 
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Seems like youre missing one of the required arguments!");
		}

	}

	/**
	 * print method. This just loops through the array list and prints the already
	 * sorted list. It also takes some in the args and includes it in the report
	 * aswell as the run time of the program
	 */
	private static void printArray() {
		// calc run time
		long runTime = stop - start;
		String sortedBy = "";
		String sortedMethod = "";
		// getting the largest and smallest item in sorted array
		ThreeDGeoShape firstItem = shapeArray[0];
		ThreeDGeoShape lastItem = shapeArray[shapeArray.length - 1];
		//if else tree to figure out what we were sorting by for our print
		if (sortBy.equalsIgnoreCase("h")) {
			 sortedBy = "height";
		}else if(sortBy.equalsIgnoreCase("a")) {
			 sortedBy = "area";
		}else if(sortBy.equalsIgnoreCase("v")) {
			 sortedBy = "volume";
		}
		//if else tree to figure out what we sorting by for our print
		if (sortMethod.equalsIgnoreCase("b")) {
			sortedMethod = "bubble sort";
		} else if (sortMethod.equalsIgnoreCase("s")) {
			sortedMethod = "selection sort";
		} else if (sortMethod.equalsIgnoreCase("i")) {
			sortedMethod = "insertion sort";
		} else if (sortMethod.equalsIgnoreCase("m")) {
			sortedMethod = "merge sort";
		} else if (sortMethod.equalsIgnoreCase("q")) {
			sortedMethod = "quick sort";
		} else if (sortMethod.equalsIgnoreCase("z")) {
			sortedMethod = "shaker sort";
		}
		
		// print the header to our report
		System.out.println("==================================================================================================================================");
		System.out.println("                                     Results of " + sortedMethod + " on " + sortedBy + " for file " + fileName);
		System.out.println("==================================================================================================================================");
		System.out.println("Largest Find: " + firstItem);
		System.out.println("Smallest Find: " + lastItem);
		System.out.println("Runtime of sort: " + runTime + " milliseconds");
		System.out.println("==================================================================================================================================");
		System.out.println("Every thousandth find between largest and smallest values found");
		System.out.println("==================================================================================================================================");
		//looping through each item and printin
		for (int x = 1000; x < shapeArray.length; x += 1000) {
			ThreeDGeoShape shape = shapeArray[x];
			System.out.println(x + " : " + shape);
		}
		System.out.println("==================================================================================================================================");

	}

	/**
	 * This method sorts the arrays. Not actually but calls the different classes that 
	 * does actually sort them. Calls different methods in different classes based of
	 * one of the arguments passed from the command line
	 */
	private static void sortArray() {

		// if else tree to decide which sort to call based off args
		if (sortMethod.equalsIgnoreCase("b")) {
			BubbleSort bs = new BubbleSort();
			start = System.currentTimeMillis();
			shapeArray = bs.sort(sortBy, shapeArray);
			stop = System.currentTimeMillis();
		} else if (sortMethod.equalsIgnoreCase("s")) {
			SelectionSort ss = new SelectionSort();
			start = System.currentTimeMillis();
			shapeArray = ss.sort(sortBy, shapeArray);
			stop = System.currentTimeMillis();
		} else if (sortMethod.equalsIgnoreCase("i")) {
			InsertionSort is = new InsertionSort();
			start = System.currentTimeMillis();
			shapeArray = is.sort(sortBy, shapeArray);
			stop = System.currentTimeMillis();
		} else if (sortMethod.equalsIgnoreCase("m")) {
			MergeSort ms = new MergeSort();
			start = System.currentTimeMillis();
			shapeArray = ms.sort(sortBy, shapeArray, shapeArray.length);
			stop = System.currentTimeMillis();
		} else if (sortMethod.equalsIgnoreCase("q")) {
			QuickSort qs = new QuickSort();
			start = System.currentTimeMillis();
			shapeArray = qs.sort(sortBy, shapeArray, 0, shapeArray.length - 1);
			stop = System.currentTimeMillis();
		} else if (sortMethod.equalsIgnoreCase("z")) {
			ShakerSort shks = new ShakerSort();
			start = System.currentTimeMillis();
			shapeArray = shks.sort(sortBy, shapeArray);
			stop = System.currentTimeMillis();
		} else {
			// incase the sort method you entered is not one of the above
			System.out.println("You have chosen an invalid sort method!");

		}
	}

	
	/**
	 * This method loads the array. It takes the text file and one by one loads the array
	 * takes the first item from text file to figure out the number of shapes inside
	 */
	private static void loadArray() {

		// try statement to open the file
		try {
			// getting file and creating scanner to read through it
			File inputFile = new File("res/" + fileName);
			Scanner in = new Scanner(inputFile);
			//getting the amount of shapes in file
			int amountOfObjects = Integer.parseInt((in.next()));
			//creating shape array with the size we just got above
			shapeArray = new ThreeDGeoShape[amountOfObjects];
			
			// for loop that iterates the amount of time the number of shapes are in the file
			for (int x = 0; x < amountOfObjects; x++) {
				
				// if else statement that figures out what kind of shape it is
				// and creating the object based off that and adding it to the array
				String shapeName = in.next();
				double height = Double.parseDouble(in.next());
				if (shapeName.equals("Cylinder")) {
					double radius = Double.parseDouble(in.next());
					shapeArray[x] = new Cylinder(shapeName, height, radius);
				} else if (shapeName.equals("Cone")) {
					double radius = Double.parseDouble(in.next());
					shapeArray[x] = new Cone(shapeName, height, radius);
				} else if (shapeName.equals("Pyramid")) {
					double sideLength = Double.parseDouble(in.next());
					shapeArray[x] = new Pyramid(shapeName, height, sideLength);
				} else if (shapeName.equals("TriangularPrism")) {
					double sideLength = Double.parseDouble(in.next());
					shapeArray[x] = new TrianglePrism(shapeName, height, sideLength);
				} else if (shapeName.equals("OctagonalPrism")) {
					double sideLength = Double.parseDouble(in.next());
					shapeArray[x] = new OctagonPrism(shapeName, height, sideLength);
				} else if (shapeName.equals("PentagonalPrism")) {
					double sideLength = Double.parseDouble(in.next());
					shapeArray[x] = new PentagonPrism(shapeName, height, sideLength);
				} else if (shapeName.equals("SquarePrism")) {
					double sideLength = Double.parseDouble(in.next());
					shapeArray[x] = new SquarePrism(shapeName, height, sideLength);
				}

			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method validates the arguments passed in through the command line  
	 * @param one
	 * @param two
	 * @param three
	 * @return
	 */
	private static boolean vallidateMainArgs(String one, String two, String three) {

		boolean isFileNameSet;
		boolean isSortBySet;
		boolean isSortMethodSet;
		// setting these booleans to false
		isFileNameSet = isSortBySet = isSortMethodSet = false;
		
		// if statement to see if the arguments are valid 
		if (one.substring(0, 2).equalsIgnoreCase("-f") || one.substring(0, 2).equalsIgnoreCase("-t")
				|| one.substring(0, 2).equalsIgnoreCase("-s")) {
			
			// case to see which one it exactly is and setting variable based of that
			one = one.toLowerCase();
			switch (one.substring(0, 2)) {
			case "-f":
				fileName = one.substring(2);
				isFileNameSet = true;
				break;
			case "-t":
				sortBy = one.substring(2);
				isSortBySet = true;
				break;
			case "-s":
				sortMethod = one.substring(2);
				isSortMethodSet = true;
				break;
			}
		}

		// if statement to see if arguments are valid
		if (two.substring(0, 2).equalsIgnoreCase("-f") || two.substring(0, 2).equalsIgnoreCase("-t")
				|| two.substring(0, 2).equalsIgnoreCase("-s")) {
			
			// case to see which one it exactly is and setting variable based of that
			two = two.toLowerCase();
			switch (two.substring(0, 2)) {
			case "-f":
				fileName = two.substring(2);
				isFileNameSet = true;
				break;
			case "-t":
				sortBy = two.substring(2);
				isSortBySet = true;
				break;
			case "-s":
				sortMethod = two.substring(2);
				isSortMethodSet = true;
				break;
			}
		}

		// if statement to see if arguments are valid
		if (three.substring(0, 2).equalsIgnoreCase("-f") || three.substring(0, 2).equalsIgnoreCase("-t")
				|| three.substring(0, 2).equalsIgnoreCase("-s")) {
			
			// case to see which one it exactly is and setting variable based of that
			three = three.toLowerCase();
			switch (three.substring(0, 2)) {
			case "-f":
				fileName = three.substring(2);
				isFileNameSet = true;
				break;
			case "-t":
				sortBy = three.substring(2);
				isSortBySet = true;
				break;
			case "-s":
				sortMethod = three.substring(2);
				isSortMethodSet = true;
				break;
			}
		}
		
		// if statement to see if booleans were set true and returns true if all args are valid
		if (isFileNameSet == true && isSortMethodSet == true && isSortBySet == true) {
			return true;

		} else {
			return false;
		}

	}

}
