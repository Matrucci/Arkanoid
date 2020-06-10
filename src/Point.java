/**********************************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class that represents a point on the screen using X and Y values.
 *********************************************************************/
public class Point {
    private double x;
    private double y;

    /**************************************************
     * A constructor.
     * @param x - a point on the screen on the X axis.
     * @param y - a point on the screen on the Y axis.
     *************************************************/
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /*************************************************************
     * Calculates the distance between 2 points.
     * @param other - another point to calculate the distance to.
     * @return - returns the distance between 2 points (double).
     ***********************************************************/
    public double distance(Point other) {
        if (other == null) {
            return -1;
        }
        return Math.sqrt(((this.x - other.x) * (this.x - other.x)) + ((this.y - other.y) * (this.y - other.y)));
    }

    /**************************************************************************
     * Checks if 2 points are equal (both x and y are the same for both points.
     * @param other - a point to compare to.
     * @return - true if equal, false if not.
     **************************************************************************/
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        return ((this.x == other.x) && (this.y == other.y));
    }

    /**********************************************
     * Returns the X of the point.
     * @return - double - the X value of the point.
     *********************************************/
    public double getX() {
        return this.x;
    }

    /**********************************************
     * Returns the Y of the point.
     * @return - double - the Y value of the point.
     **********************************************/
    public double getY() {
        return this.y;
    }

    /**************************************
     * Sets a new X value to the point.
     * @param newX - new X value to be set.
     **************************************/
    public void setX(double newX) {
        this.x = newX;
    }

    /**************************************
     * Sets a new Y value to the point.
     * @param newY - new Y value to be set.
     **************************************/
    public void setY(double newY) {
        this.y = newY;
    }
}
