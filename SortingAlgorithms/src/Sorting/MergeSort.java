package Sorting;

import Comparing.BaseAreaCompare;
import Comparing.VolumeCompare;
import Objects.ThreeDGeoShape;

/**
 * Merge sort class that sorts the array list 
 * @author 797138
 *
 */
public class MergeSort {

	/**
	 * with these parameters it sorts the array and returns the array
	 * @param sortBy
	 * @param shapeArray
	 * @param length
	 * @return
	 */
	public ThreeDGeoShape[] sort(String sortBy, ThreeDGeoShape[] shapeArray, int length) {
		
		// if statement to see if length or array is less than two only then it returns
		if (length < 2) {
			return shapeArray;
		}
			// recursion part
			int middle = length /2;
			
			// creating two arrays 
			ThreeDGeoShape leftArray[] = new ThreeDGeoShape[middle];
			ThreeDGeoShape rightArray[] = new ThreeDGeoShape[length - middle];
			
			// for loop to load each array
			for (int i=0; i < middle; i++) {
				leftArray[i] = shapeArray[i];
			}
			for (int i= middle; i < length; i++) {
				rightArray[i - middle] = shapeArray[i];
			}
			
			//sort each smaller array
			sort(sortBy, leftArray, middle);
			sort(sortBy, rightArray, length - middle);
			
			// merges array ... only happens when array is less then size of two
			shapeArray = merge(sortBy, shapeArray, leftArray, rightArray, middle, length - middle);
		
		
		return shapeArray;
	}

	/**
	 * Takes in the following parameters and merges two arrays together in proper order
	 * @param sortBy
	 * @param shapeArray
	 * @param leftArray
	 * @param rightArray
	 * @param left
	 * @param right
	 * @return
	 */
	private ThreeDGeoShape[] merge(String sortBy, ThreeDGeoShape[] shapeArray,ThreeDGeoShape[] leftArray, ThreeDGeoShape[] rightArray, int left, int right) {
		
		// attributes
		int i = 0;
		int j = 0;
		int k = 0 ;
		int result = 0;
		BaseAreaCompare ac = new BaseAreaCompare();
		VolumeCompare vc = new VolumeCompare();
		
		// while loop that goes through each element in both arrays
		while( i < left && j < right) {
			
			// if statements to figure out what were sorting by
			if (sortBy.equalsIgnoreCase("h")) {
				result = leftArray[i].compareTo(rightArray[j]);
			}else if (sortBy.equalsIgnoreCase("a")) {
				result = ac.compare(leftArray[i], rightArray[j]);
			}else if (sortBy.equalsIgnoreCase("v")) {
				result = vc.compare(leftArray[i], rightArray[j]);
			}
			
			// if else satementto sort array
			if (result == 1) {
				shapeArray[k] = leftArray[i];
				i++;
			}else {
				shapeArray[k] = rightArray[j];
				j++;
			}
			k++;
		}
		
		//just incase we have any unsorted items
		while (j < right) {
			shapeArray[k] = rightArray[j];
			j++;
			k++;
		}
		while (i < left) {
			shapeArray[k] = leftArray[i];
			i++;
			k++;
		}
		
		return shapeArray;
		
		
	}

}


