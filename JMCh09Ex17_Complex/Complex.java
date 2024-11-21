/**
 * Represents a complex number of the form a + bi. Provides methods for
 * adding, multiplying and calculating the absolute value.
 *
 *  @author  Chaaruhaas Kandregula
 *  @version 10/10/2024
 *  @author  Period: 3
 *  @author  Assignment: JMCh09Ex17_Complex 
 *
 *  @author  Sources: None
 */
public class Complex
{
    /**
     * a is the real component; b is the imaginary component
     */
    private double a;
    private double b;
    
    /**
     * Constructs a new Complex number, x+yi
     * @param x input for real component
     * @param y input for imaginary component
     */

    public Complex(double x, double y) {
        a = x;
        b = y;
    }


    /**
     * Constructs a new Complex, x + 0.0i
     * @param x real component of the Complex 
     */
    public Complex(double x) {
        this(x, 0.0);
    }
    

    /**
     * @return the absolute value of the Complex as a double
     */
    public double abs() {
        return Math.sqrt(this.a * this.a + this.b * this.b);
    }


    /**
     * @param c the Complex to add to the Complex 
     * number this method is being called on
     * @return the Complex, the sum (this)+c
     */
    public Complex add(Complex c) {
        return new Complex(this.a + c.a, this.b + c.b);
    }

    /**
     * @param d the double to add to the real 
     * component of the Complex number
     * @return a new Complex that is the sum of (this)+d
     */
    public Complex add(double d) {
        return new Complex(this.a + d, this.b);
    }

    /**
     * @param c the other factor to multiply this by
     * @return a new Complex object, the product 
     * of this Complex object and c
     */
    public Complex multiply(Complex c) {
        return new Complex((this.a * c.a - this.b * c.b),
        (this.b * c.a + this.a * c.b));
    }

    /**
     * @param d the double to multiply this 
     * Complex object by
     * @return a new Complex object, the 
     * product of d and this object.
     */

    public Complex multiply(double d) {
        return new Complex(this.a * d, this.b * d);
    }

    /**
     * converts a Complex object to a string.
     * @return a string representation of the complex object
     */

    public String toString()
    {
        return a + " + " + b + "i";
    }
}
