package Objects;

/**
 * Creates object of triangular prism and extends the abstract 3dshape

 * @author Talha Khamoor
 *
 */
public class TrianglePrism extends ThreeDGeoShape{
	
	//attributes
	private double sideLength;
	private double baseArea;
	private double volume;

	/**
	 * 
	 * @param shapeName
	 * @param height
	 * @param sideLength
	 */
	public TrianglePrism(String shapeName, double height, double sideLength) {
		super(shapeName, height);
		this.sideLength = sideLength;
		
	}

	/**
	 * calculating the area of the shape
	 */
	@Override
	public double calBaseArea() {
		baseArea = ((sideLength*sideLength) * Math.sqrt(3)) / 4;
		return baseArea;
	}

	/**
	 * calculating the volume for the shape
	 */
	@Override
	public double calVolume() {
		volume = calBaseArea() * getHeight();
		return volume;
	}

	/**
	 * returns the side length of shape
	 * @return
	 */
	public double getSideLength() {
		return sideLength;
	}

	/**
	 * sets the side length of shape
	 * @param sideLength
	 */
	public void setSideLength(double sideLength) {
		this.sideLength = sideLength;
	}

	/**
	 * tostring method that prints the shape
	 */
	@Override
	public String toString() {
		return "TrianglePrism [sideLength=" + sideLength + ", baseArea=" + calBaseArea() + ", volume=" + calVolume() + ", height =" + getHeight() + "]";
	}
	
	
}
