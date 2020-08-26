package Sorting;

import Comparing.BaseAreaCompare;
import Comparing.VolumeCompare;
import Objects.ThreeDGeoShape;

/**
 * bubble sort class that sorts array list
 * @author 797138
 *
 */
public class BubbleSort {

	/**
	 * gets the the below parameters and sorts array and returns array
	 * @param sortBy
	 * @param shapeArray
	 * @return
	 */
	public ThreeDGeoShape[] sort(String sortBy, ThreeDGeoShape[] shapeArray) {
		ThreeDGeoShape temp;
		int result = 0;
		BaseAreaCompare ac = new BaseAreaCompare();
		VolumeCompare vc = new VolumeCompare();

		// for loop that goes through each element 
		for (int i = 0; i < shapeArray.length; i++) {
			//another for loo to itterate second value
			for (int j = 1; j < shapeArray.length - i; j++) {
				ThreeDGeoShape shape1 = shapeArray[j - 1];
				ThreeDGeoShape shape2 = shapeArray[j];
				// if else to see what were comparing by 
				if (sortBy.equalsIgnoreCase("h")) {
					result = shape2.compareTo(shape1);
				} else if (sortBy.equalsIgnoreCase("a")) {
					result = ac.compare(shape2, shape1);
				} else if (sortBy.equalsIgnoreCase("v")) {
					result = vc.compare(shape2, shape1);
				}
				// if greater it makes the following swaps in array
				if (result == 1) {
					temp = shapeArray[j - 1];
					shapeArray[j - 1] = shapeArray[j];
					shapeArray[j] = temp;

				}

			}
		}
		// returns array
		return shapeArray;

	}
}
