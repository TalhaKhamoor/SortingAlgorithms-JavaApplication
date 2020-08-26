package Objects;

/**
 * 
 * @author Talha Khamoor
 * 
 * Creates object of cone and extends the abstract 3dshape
 *
 */
public class Cone extends ThreeDGeoShape {
	
	//attributes
	private double radius;
	private double baseArea;
	private double volume;
	
	/**
	 * constructor method
	 * @param shapeName
	 * @param height
	 * @param radius
	 */
	public Cone(String shapeName, double height, double radius) {
		super(shapeName, height);
		this.setRadius(radius);
	}

	/**
	 * calculating the area
	 */
	@Override
	public double calBaseArea() {
		baseArea = Math.PI * (radius * radius);
		return baseArea;
	}

	/**
	 * tostring method to print
	 */
	@Override
	public String toString() {
		return "Cone [radius=" + radius + ", baseArea=" + calBaseArea() + ", volume=" + calVolume() + ", height =" + getHeight() + "]";
	}

	/**
	 * calculating the volume
	 */
	@Override
	public double calVolume() {
		volume = ( Math.PI * (radius * radius) * getHeight())/3;
		return volume;
	}

	/**
	 * returning radius 
	 * @return
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * setting radius
	 * @param radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
}
