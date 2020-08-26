package Sorting;

import Comparing.BaseAreaCompare;
import Comparing.VolumeCompare;
import Objects.ThreeDGeoShape;

/**
 * Insertion sort class sorting arraylist from largest to smallest
 * @author Talha Khamoor and Marayam
 * 
 *
 */
public class InsertionSort {

	/**
	 * This method passes parameters shape array and sortby, and together they 
	 * sort arraylist largest to smallest depending on what sortby is equal to.
	 * @param sortBy
	 * @param shapeArray
	 * @return
	 */
	public ThreeDGeoShape[] sort(String sortBy, ThreeDGeoShape[] shapeArray) {

		// creating these compare objects to compare shapes with
		BaseAreaCompare ac = new BaseAreaCompare();
		VolumeCompare vc = new VolumeCompare();
		// for loop to iterate through each element
		for(int i = 1; i < shapeArray.length; i++){
			//  sets j as one element behind i
			int j = i - 1;
			//if statements to figure out what were sorting by
			if (sortBy.equalsIgnoreCase("h")) {
				//inner loop to go through values swapping
				while(j >= 0 && shapeArray[j].compareTo(shapeArray[j+1]) < 0) {
					// swapping the elements if above is true
					swapElements(shapeArray, j, j+1);
					//de-incrementing j 
					j--;
				}
				
			// rest of the cases are similar to the above steps
			} else if (sortBy.equalsIgnoreCase("a")) {
				
				while(j >= 0 && ac.compare(shapeArray[j], shapeArray[j+1]) < 0) {
					
					//shapeArray[j+1] = shapeArray[j];
					swapElements(shapeArray, j, j+1);
					j--;
				}
			} else if (sortBy.equalsIgnoreCase("v")) {
				while(j >= 0 && vc.compare(shapeArray[j], shapeArray[j+1]) < 0) {
					
					//shapeArray[j+1] = shapeArray[j];
					swapElements(shapeArray, j, j+1);
					j--;
				}
			}
			
			
			
		}
		// returning the shape array to whoever is calling this method
		return shapeArray;
	}
	/**
	 * small method just for swapping elements
	 * @param array
	 * @param i
	 * @param j
	 */
	private static  void swapElements( Object[] array, int i, int j )
	{
		// swaps elements 
		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
