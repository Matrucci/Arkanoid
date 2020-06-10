import java.util.ArrayList;
import java.util.List;

/******************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class that represents a rectangle.
 *****************************************/
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**************************************************************
     * A constructor.
     * @param upperLeft - The upper left point of the rectangle.
     * @param width - The width of the rectangle.
     * @param height - The height of the rectangle.
     ***************************************************************/
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /***************************************************************************
     * Checks all the intersection points with the rectangle with a given line.
     * @param line - The line to check the intersections with the rectangle.
     * @return - A list of points containing all intersection points.
     **************************************************************************/
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersections = new ArrayList<>();
        double xUL = this.getUpperLeft().getX();
        double yUL = this.getUpperLeft().getY();
        //Creating lines to all rectangle borders.
        Line top = new Line(xUL, yUL, xUL + this.getWidth(), yUL);
        Line bot = new Line(xUL, yUL + this.getHeight(), xUL + this.getWidth(), yUL + this.getHeight());
        Line left = new Line(xUL, yUL, xUL, yUL + this.getHeight());
        Line right = new Line(xUL + this.getWidth(),  yUL, xUL + this.getWidth(), yUL + this.getHeight());
        //Checks the intersections
        Point withTop = line.intersectionWith(top);
        Point withBot = line.intersectionWith(bot);
        Point withLeft = line.intersectionWith(left);
        Point withRight = line.intersectionWith(right);
        if (withTop != null) {
            intersections.add(withTop);
        }
        if (withBot != null) {
            intersections.add(withBot);
        }
        if (withLeft != null) {
            intersections.add(withLeft);
        }
        if (withRight != null) {
            intersections.add(withRight);
        }
        return intersections;
    }

    /************************************************
     * @return - double - The width of the rectangle.
     ***********************************************/
    public double getWidth() {
        return this.width;
    }

    /**************************************************
     * @return - double - The height of the rectangle.
     *************************************************/
    public double getHeight() {
        return this.height;
    }

    /***********************************************************
     * @return - Point - The upper left corner of the rectangle.
     ***********************************************************/
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}