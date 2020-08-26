package Objects;

/**
 * Creates object of octagon and extends the abstract 3dshape

 * @author Talha Khamoor
 *
 */
public class OctagonPrism extends ThreeDGeoShape{
	
	//attributes
	private double sideLength;
	private double baseArea;
	private double volume;

	/**
	 * constructor method that makes the object
	 * @param shapeName
	 * @param height
	 * @param sideLength
	 */
	public OctagonPrism(String shapeName, double height, double sideLength) {
		super(shapeName, height);
		this.sideLength = sideLength;
		
	}

	/**
	 * calc area of the shape
	 */
	@Override
	public double calBaseArea() {
		baseArea = 2 * (1 + Math.sqrt(2)) * (sideLength * sideLength);
		return baseArea;
	}

	/**
	 * tostring method to print
	 */
	@Override
	public String toString() {
		return "OctagonPrism [sideLength=" + sideLength + ", baseArea=" + calBaseArea() + ", volume=" + calVolume() + ", height =" + getHeight() + "]";
	}

	/**
	 * calculating the volume of shape
	 */
	@Override
	public double calVolume() {
		volume = calBaseArea() * getHeight();
		return volume;
	}

	/**
	 * returning the side length
	 * @return
	 */
	public double getSideLength() {
		return sideLength;
	}

	/**
	 * setting the side length
	 * @param sideLength
	 */
	public void setSideLength(double sideLength) {
		this.sideLength = sideLength;
	}
}
