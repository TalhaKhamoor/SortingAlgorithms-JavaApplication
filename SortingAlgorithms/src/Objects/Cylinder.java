package Objects;

/**
 * This method Creates object of cylinder and extends the abstract 3dshape

 * @author Talha Khamoor
 *
 */
public class Cylinder extends ThreeDGeoShape{

	//attributes
	private double radius;
	private double baseArea;
	private double volume;
	
	/**
	 * constructor class that creates the cylinder object
	 * @param shapeName
	 * @param height
	 * @param radius
	 */
	public Cylinder(String shapeName, double height, double radius) {
		super(shapeName, height);
		this.radius=(radius);
	}

	/**
	 * calc the area of the shape
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
		return "Cylinder [radius=" + radius + ", baseArea=" + calBaseArea() + ", volume=" + calVolume() +  ", height =" + getHeight() +  "]";
	}

	/**
	 * calc volume of shape
	 */
	@Override
	public double calVolume() {
		
		volume = Math.PI * (radius * radius) * getHeight();
		return volume;
	}

	/**
	 * returning the radius
	 * @return
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * setting the radius
	 * @param radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

}
