package Sorting;

import Comparing.BaseAreaCompare;
import Comparing.VolumeCompare;
import Objects.ThreeDGeoShape;

public class ShakerSort {

	public ThreeDGeoShape[] sort(String sortBy, ThreeDGeoShape[] shapeArray) {

		int result = 0;
		BaseAreaCompare ac = new BaseAreaCompare();
		VolumeCompare vc = new VolumeCompare();
		for (int i = 0; i < shapeArray.length / 2; i++) {
			boolean swapped = false;
			for (int j = i; j < shapeArray.length - i - 1; j++) {
				if (sortBy.equalsIgnoreCase("h")) {
					result = shapeArray[j].compareTo(shapeArray[j+1]);
				}else if (sortBy.equalsIgnoreCase("a")) {
					result = ac.compare(shapeArray[j], shapeArray[j+1]);
				}else if (sortBy.equalsIgnoreCase("v")) {
					result = vc.compare(shapeArray[j], shapeArray[j+1]);
				}
				
				if (result == -1) {
					ThreeDGeoShape tmp = shapeArray[j];
					shapeArray[j] = shapeArray[j + 1];
					shapeArray[j+1] = tmp;
					swapped = true;
				}
			}
			for (int j = shapeArray.length - 2 - i; j > i; j--) {
				if (sortBy.equalsIgnoreCase("h")) {
					result = shapeArray[j].compareTo(shapeArray[j+1]);
				}else if (sortBy.equalsIgnoreCase("a")) {
					result = ac.compare(shapeArray[j], shapeArray[j+1]);
				}else if (sortBy.equalsIgnoreCase("v")) {
					result = vc.compare(shapeArray[j], shapeArray[j+1]);
				}
				if (result == 1) {
					ThreeDGeoShape tmp = shapeArray[j];
					shapeArray[j] = shapeArray[j-1];
					shapeArray[j-1] = tmp;
					swapped = true;
				}
			}
			if(!swapped) break;
		}
		return shapeArray;
	}

}
