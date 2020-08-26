package Objects;

/**
 * Creates abstract of shape object and extends the abstract 3dshape
 * @author Talha Khamoor
 *
 */
public abstract class ThreeDGeoShape implements Comparable<ThreeDGeoShape>{
	
	//attributes
	private double height;
	private String shapeName;
	
	/**
	 * constructor creates the shape object 
	 * @param shapeName
	 * @param height
	 */
	public ThreeDGeoShape(String shapeName, double height) {
		this.shapeName = shapeName;
		this.height = height;
	}
	
	/**
	 * returns shape name
	 * @return
	 */
	public String getShapeName() {
		return shapeName;
	}
	
	/**
	 * sets the shape name
	 * @param shapeName
	 */
	public void setShapeName(String shapeName) {
		this.shapeName = shapeName;
	}
	
	/**
	 * returns the height of shape
	 * @return
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * sets the height of the shape
	 * @param height
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * toString method to print the shape... not really used 
	 */
	@Override
	public String toString() {
		return "ThreeDGeoShape [height=" + height + ", shapeName=" + shapeName + "]";
	}

	/**
	 * abstract method that calcs area
	 * @return
	 */
	public abstract double calBaseArea();
	
	/**
	 * abstract method that clas volume
	 * @return
	 */
	public abstract double calVolume();
	
	/**
	 * compare to method to compare two objects by their height
	 */
	@Override
	public int compareTo(ThreeDGeoShape that) {
		
		if (this.height > that.height) {
			return 1;
		}else if (this.height < that.height) {
			return -1;
		}else {
			return 0;
		}
	}
}
