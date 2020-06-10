/******************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class that represents the velocity.
 *****************************************/
public class Velocity {
    private double dx;
    private double dy;

    /******************************************
     * A constructor.
     * @param dx - The "speed" of the X axis.
     * @param dy - The "speed" of the Y axis.
     *****************************************/
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /****************************************************************
     * A function to build velocity from an angle and speed.
     * @param angle - The angle of movement (0 is up - 90 is right).
     * @param speed - The amount of units we move each frame.
     * @return - Velocity - new velocity.
     ***************************************************************/
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * (Math.sin((Math.PI / 180) * angle));
        double dy = -1 * speed * (Math.cos((Math.PI / 180) * angle));
        return new Velocity(dx, dy);
    }

    /************************************
     * Returns the current X axis speed.
     * @return - double - X axis speed.
     **********************************/
    public double getDx() {
        return dx;
    }

    /************************************************
     * Sets a new X axis speed.
     * @param newDx - double - the new X axis speed.
     ***********************************************/
    public void setDx(double newDx) {
        this.dx = newDx;
    }

    /************************************
     * Returns the current Y axis speed.
     * @return - double - Y axis speed.
     **********************************/
    public double getDy() {
        return dy;
    }

    /************************************************
     * Sets a new Y axis speed.
     * @param newDy - double - the new Y axis speed.
     **********************************************/
    public void setDy(double newDy) {
        this.dy = newDy;
    }

    /**********************************************************
     * Gets the speed size in the current direction.
     * @return - double - the speed in the current direction.
     *********************************************************/
    public double getForce() {
        return Math.sqrt(this.dx * this.dx + this.dy * this.dy);
    }

    /****************************************************************************************
     * Takes a point and returns a new point with a new placement according to the velocity.
     * Adds the X speed and the Y speed to the point's center.
     * @param p - The initial point.
     * @return - A new point with new coordinates.
     ****************************************************************************************/
    public Point applyToPoint(Point p) {
        double x = p.getX();
        double y = p.getY();
        x += this.dx;
        y += this.dy;
        return new Point(x, y);
    }
}