package Objects;

/**
 * Creates object of pentagonalprism and extends the abstract 3dshape

 * @author Talha Khamoor
 *
 */
public class PentagonPrism extends ThreeDGeoShape{
	
	//attributes
	private double sideLength;
	private double baseArea;
	private double volume;

	/**
	 * constructor that sets the object
	 * @param shapeName
	 * @param height
	 * @param sideLength
	 */
	public PentagonPrism(String shapeName, double height, double sideLength) {
		super(shapeName, height);
		this.sideLength = sideLength;
		
	}

	/**
	 * calc area of the shape
	 */
	@Override
	public double calBaseArea() {
		baseArea = (5 * (sideLength * sideLength) * Math.tan(54)) / 4;
		return baseArea;
	}

	/**
	 * calc the volume of the shape
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

	/**
	 * to string to print the shape
	 */
	@Override
	public String toString() {
		return "PentagonPrism [sideLength=" + sideLength + ", baseArea=" + calBaseArea() + ", volume=" + calVolume() +  ", height =" + getHeight() + "]";
	}
}
