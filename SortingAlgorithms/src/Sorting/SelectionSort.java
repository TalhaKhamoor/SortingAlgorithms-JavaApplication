package Sorting;

import Comparing.BaseAreaCompare;
import Comparing.VolumeCompare;
import Objects.ThreeDGeoShape;

public class SelectionSort {

	public ThreeDGeoShape[] sort(String sortBy, ThreeDGeoShape[] shapeArray) {

		BaseAreaCompare ac = new BaseAreaCompare();
		VolumeCompare vc = new VolumeCompare();
		int result = 0 ;
		for (int i = 0; i < shapeArray.length - 1; i++) {
			int max = i;
			for (int j = i + 1; j < shapeArray.length; j++) {
				ThreeDGeoShape shape1 = shapeArray[max];
				ThreeDGeoShape shape2 = shapeArray[j];
				if (sortBy.equalsIgnoreCase("h")) {
					result = shape2.compareTo(shape1);
				} else if (sortBy.equalsIgnoreCase("a")) {
					result = ac.compare(shape2, shape1);
				} else if (sortBy.equalsIgnoreCase("v")) {
					result = vc.compare(shape2, shape1);
				}
				if (result == 1) {
					max = j;
				}
			}
			ThreeDGeoShape temp = shapeArray[max];
			shapeArray[max] = shapeArray[i];
			shapeArray[i] = temp;
		}

		return shapeArray;
	}

}
