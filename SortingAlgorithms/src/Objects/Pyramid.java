package Objects;

/**
 * Creates object of pyramid and extends the abstract 3dshape

 * @author Talha Khamoor
 *
 */
public class Pyramid extends ThreeDGeoShape{
	
	//attributes
	private double sideLength;
	private double baseArea;
	private double volume;

	/**
	 * constructor that creates the pyramid
	 * @param shapeName
	 * @param height
	 * @param sideLength
	 */
	public Pyramid(String shapeName, double height, double sideLength) {
		super(shapeName, height);
		this.sideLength = sideLength;
		
	}

	/**
	 * calc the area of of the shape
	 */
	@Override
	public double calBaseArea() {
		baseArea = (sideLength * sideLength);
		return baseArea;
	}

	/**
	 * calc the volume of the shape
	 */
	@Override
	public double calVolume() {
		volume = ((sideLength * sideLength) * getHeight()) /3;
		return volume;
	}

	/**
	 * returning the the length 
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
	 * tostring method that prints the shape
	 */
	@Override
	public String toString() {
		return "Pyramid [sideLength=" + sideLength + ", baseArea=" + calBaseArea() + ", volume=" + calVolume() + ", height =" + getHeight() + "]";
	}
	
	
}