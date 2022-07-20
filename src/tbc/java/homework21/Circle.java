package tbc.java.homework21;

import java.util.Comparator;

/**
 * Circle is the subclass of Figure
 * @author diana
 * @version 1.2.0
 * 
 */
public class Circle extends Figure {
	private double radius;

	private static double defaultRadius = 1;

	/**
	 * Creates Circle instance with the default radius - 1
	 * @throws ValidateException
	 */
	public Circle() throws ValidateException {
		this(defaultRadius);
	}

	/**
	 * Creates Circle instance with the received values
	 * @param radius
	 * @throws ValidateException - Throws exception when radius is negative
	 */
	public Circle(double radius) throws ValidateException {
		this.radius = radius;
		validate();
	}

	/**
	 * Returns radius of circle
	 * @return double - radius of Circle
	 */
	public double getRadius() {
		return radius;
	}

	@Override
	public double getLength() {
		return 2 * Math.PI * radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public String toString() {
		return "Circle [Radius : " + this.radius + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Circle cr;
		if (!(obj instanceof Circle))
			return false;
		cr = (Circle) obj;
		return this.radius == cr.radius;
	}

	@Override
	public int hashCode() {
		Double val = this.radius;
		return val.hashCode();
	}

	@Override
	public void validate() throws ValidateException {
		if (!(radius > 0)) {
			throw new ValidateException("Sides can't have negative value ");
		}
	}

	/**
	 * @deprecated as of release 1.2.0, replaced by {@link #getLength()}
	 * Will be removed after the release of 1.3.0;
	 * @param f - Figure class instance
	 * @return double - returns length of the figure border
	 */
	@Deprecated
	public static double getLengthStatic(Figure f){
		return f.getLength();
	}

}