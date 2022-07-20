package tbc.java.homework21;

import java.util.Locale;

/**
 * Figure is an abstract class implementing comparable interface. 
 * @author diana 
 * @version 1.2.0
 *
 */

public abstract class Figure implements Comparable<Figure>, SumInterface {

	@Override
	public double getSum(String type, Figure figure1, Figure figure2) {
		if(type.toLowerCase().equals("perimeter")){
			return figure1.getLength()+figure2.getLength();
		}else if(type.toLowerCase().equals("Area")){
			return figure1.getArea()+figure2.getArea();
		}else{
			return -1;
		}
	}

	/**
 * Abstract method - calculates and returns area of figure object
 * @return Area of figure - double
 */
	public abstract  double getArea ();
	
/**
 * Abstract method	- calculates and returns perimeter of figure object
 * @return Length of the figure border - double
 */
	public abstract double getLength();

/**
 * Abstract method, checks figure validation. 
 * @throws ValidateException
 */
	public abstract void validate() throws ValidateException;
	
/**
 * @param fig
 * @return int
 * 			0 - in case of got object is equal to current one; 
 * 			1 - in case of got object is smaller than current one
 *			-1 - in case of got object is bigger than current one
 *
 */
	public int compareTo(Figure fig) {
		if(this.getLength()== fig.getLength()) {
			return 0;
		}else if(this.getLength()>fig.getLength()) {
			return 1;
		}else {
			return -1;
		}
	}
	
}