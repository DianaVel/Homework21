package tbc.java.homework21;

import java.util.Iterator;

/**
 * Triangle is the subclass of Figure
 * @author diana
 * @version 1.2.0
 */
public class Triangle extends Figure {
	private double a;
	private double b;
	private double c;

	private double alpha;
	private double beta;
	private double gama;

	private static double defaultA = 2;
	private static double defaultB = 3;
	private static double defaultC = 4;

	private double heightB;

	/**
	 * Creates instance of Triangle with default values 2,3,4;
	 * @throws ValidateException
	 */
	public Triangle() throws ValidateException {
		this(defaultA, defaultB, defaultC);
	}

	/**
	 * Creates instance of Triangle with received values;
	 * @throws ValidateException - In case values are not positive values or triangle principles aren't met.
	 */
	public Triangle(double a, double b, double c) throws ValidateException {
		this.a = a;
		this.b = b;
		this.c = c;
		validate();

		alpha = Math.acos((b * b + c * c - a * a) / (2 * b * c)) * 180 / Math.PI;
		beta = Math.acos((a * a + c * c - b * b) / (2 * a * c)) * 180 / Math.PI;
		gama = 180 - alpha - beta;
	}

	/**
	 * Returns one side of triangle
	 * @return double - one side of triangle
	 */
	public double getA() {
		return a;
	}

	/**
	 * Returns second side of triangle
	 * @return double - second side of triangle
	 */

	public double getB() {
		return b;
	}

	/**
	 * Returns third side of triangle
	 * @return double - third side of triangle
	 */

	public double getC() {
		return c;
	}

	@Override
	public double getLength() {
		return this.a + this.b + this.c;
	}

	@Override
	public String toString() {
		return "Triangle [Side A : " + this.a + "; Side B : " + this.b + "; Side C : " + this.c + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Triangle tr;
		if (!(obj instanceof Triangle))
			return false;
		tr = (Triangle) obj;
		if (tr.getLength() != this.getLength())
			return false;
		return true;
	}

	/**
	 * Checks and returns triangle type.
	 * @return int - triangle type : 0 - if Right-angled;  1- if Obtuse-angled; -1 if Acute-angled
	 */
	public int getTriangleType() {
		double biggestAngle = Math.max(alpha, Math.max(beta, gama));
		if (biggestAngle > 90) {
			return 1;
		} else if (biggestAngle < 90) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public double getArea() {
		double s = (a + b + c) / 2;
		double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
		heightB = 2 * area / b;
		return area;
	}

	private boolean checkNegative() {
		return (a > 0 && b > 0 && c > 0);
	}

	private boolean checkSides() {
		return (a + b > c && a + c > b && b + c > a);
	}

	@Override
	public void validate() throws ValidateException {
		if (!checkNegative())
			throw new ValidateException("Sides can't have negative value ");
		if (!checkSides())
			throw new ValidateException("Two sides sum should be bigger than third side");
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