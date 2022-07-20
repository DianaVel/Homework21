package tbc.java.homework21;

/**
 * Rectangle is the subclass of Figure
 * @author diana
 * @version 1.2.0
 */
public class Rectangle extends Figure {
	private double height;
	private double width;

	private static double defaultWidth = 1;
	private static double defaultHeight = 1;

	/**
	 * Creates instance of Rectangle with default values 1,1;
	 * @throws ValidateException
	 */
	public Rectangle() throws ValidateException {
		this(defaultWidth, defaultHeight);
	}

	/**
	 * Creates instance of Rectangle with received values;
	 * @param width, height - Receives width and height of rectangle.
	 * @throws ValidateException  - In case values are not positive ValidateException is thrown;
	 */

	public Rectangle(double width, double height) throws ValidateException {
		this.height = height;
		this.width = width;
		validate();
	}

	/**
	 * Returns height of rectangle
	 * @return double - Returns height of the rectangle object
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Returns width of rectangle
	 * @return double - Returns width of the rectangle object
	 */

	public double getWidth() {
		return width;
	}

	@Override
	public double getArea() {
		return height * width;
	}

	@Override
	public double getLength() {
		return 2 * (height + width);
	}

	@Override
	public String toString() {
		return "Rectangle [Width : " + this.width + "; Height : " + this.height + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Rectangle rect;
		if (!(obj instanceof Rectangle))
			return false;
		rect = (Rectangle) obj;
		if (this.width == rect.width && this.height == rect.height) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Calculates and returns diagonal of rectangle
	 * @return double - Returns diagonal of rectangle object
	 */
	public double getDiagonal() {
		double diagonal = Math.sqrt(Math.pow(this.height, 2) + Math.pow(this.width, 2));
		return diagonal;
	}

	private boolean validateFigure() {
		return (width > 0 && height > 0);
	}

	public int hashCode() {
		Double val = this.getArea();
		return val.hashCode();
	}

	@Override
	public void validate() throws ValidateException {
		if (!validateFigure())
			throw new ValidateException("Sides can't have negative value ");

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
