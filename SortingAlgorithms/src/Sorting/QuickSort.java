package Sorting;

import Comparing.BaseAreaCompare;
import Comparing.VolumeCompare;
import Objects.ThreeDGeoShape;

/**
 * This class sorts the array via quicksort
 * @author 797138
 *
 */
public class QuickSort {

	/**
	 * sort method gets called recursively, does sorting
	 * @param sortBy
	 * @param shapeArray
	 * @param begin
	 * @param end
	 * @return
	 */
	public ThreeDGeoShape[] sort(String sortBy, ThreeDGeoShape[] shapeArray, int begin, int end) {
		
		//stops the
		if (begin < end) {
			int partitionIndex = partition(sortBy, shapeArray, begin, end);

			sort(sortBy, shapeArray, begin, partitionIndex - 1);
			sort(sortBy, shapeArray, partitionIndex + 1, end);
		}
		return shapeArray;
	}

	private int partition(String sortBy, ThreeDGeoShape[] shapeArray, int begin, int end) {

		ThreeDGeoShape pivot = shapeArray[end];
		int i = (begin - 1);
		int result = 0;
		BaseAreaCompare ac = new BaseAreaCompare();
		VolumeCompare vc = new VolumeCompare();

		for (int j = begin; j < end; j++) {

			if (sortBy.equalsIgnoreCase("h")) {
				result = pivot.compareTo(shapeArray[j]);
			} else if (sortBy.equalsIgnoreCase("a")) {
				result = ac.compare(pivot, shapeArray[j]);
			} else if (sortBy.equalsIgnoreCase("v")) {
				result = vc.compare(pivot, shapeArray[j]);
			}
			
			if (result == -1) {
				i++;

				ThreeDGeoShape swapTemp = shapeArray[i];
				shapeArray[i] = shapeArray[j];
				shapeArray[j] = swapTemp;
			}
		}

		ThreeDGeoShape swapTemp = shapeArray[i + 1];
		shapeArray[i + 1] = shapeArray[end];
		shapeArray[end] = swapTemp;

		return i + 1;
	}

}
