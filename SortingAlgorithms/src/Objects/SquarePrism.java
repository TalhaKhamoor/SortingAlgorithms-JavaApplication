package Objects;

/**
 * Creates object of square prism and extends the abstract 3dshape

 * @author Talha Khamoor
 *
 */
public class SquarePrism extends ThreeDGeoShape{
	
	//attributes
	private double sideLength;
	private double baseArea;
	private double volume;

	/**
	 * constructor creates the square prism object 
	 * @param shapeName
	 * @param height
	 * @param sideLength
	 */
	public SquarePrism(String shapeName, double height, double sideLength) {
		super(shapeName, height);
		this.sideLength = sideLength;
		
	}

	/**
	 * calculating the base area of the shape
	 */
	@Override
	public double calBaseArea() {
		baseArea = sideLength * sideLength;
		return baseArea;
	}

	/**
	 * calculating the volume of the shape
	 */
	@Override
	public double calVolume() {
		volume = (sideLength * sideLength) * getHeight();
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
	 * to string to print the shape
	 */
	@Override
	public String toString() {
		return "SquarePrism [sideLength=" + sideLength + ", baseArea=" + calBaseArea() + ", volume=" + calVolume() + ", height =" + getHeight() + "]";
	}
	
	
}
