package Comparing;

import java.util.Comparator;

import Objects.ThreeDGeoShape;

/**
 * 
 * @author Talha Khamoor
 * This class compares shapes based off their area and returns a
 * number based on which one is greater
 */
public class BaseAreaCompare implements Comparator<ThreeDGeoShape>{

	/**
	 * compare method that compares two shapes by their area
	 */
	public int compare(ThreeDGeoShape shape1, ThreeDGeoShape shape2) {
		// if statement actually doing the comparison
		if (shape1.calBaseArea() > shape2.calBaseArea()) {
			return 1;
		}else if (shape1.calBaseArea() < shape2.calBaseArea()) {
			return -1;
		}else {
			return 0;
		}
		
	}
}