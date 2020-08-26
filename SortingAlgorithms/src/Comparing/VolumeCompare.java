package Comparing;

import java.util.Comparator;

import Objects.ThreeDGeoShape;

/**
 * 
 * @author Talha Khamoor
 * This class compares two shapes by their volume and returns the an int value
 * depending on which one is greater
 */
public class VolumeCompare implements Comparator<ThreeDGeoShape>{

	/**
	 * this method compares two objects by volume
	 */
	@Override
	public int compare(ThreeDGeoShape shape1, ThreeDGeoShape shape2) {
		//if statement doing the actual comparison
		if (shape1.calVolume() > shape2.calVolume()) {
			return 1;
		}else if (shape1.calVolume() < shape2.calVolume()) {
			return -1;
		}else {
			return 0;
		}
		
	}
}
