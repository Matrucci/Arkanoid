import java.util.List;

/*************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class that represents a line using 2 points.
 ************************************************/
public class Line {
    private Point p1;
    private Point p2;

    /************************************************
     * A constructor.
     * @param start - The starting point of the line.
     * @param end - The ending point of the line.
     ***********************************************/
    public Line(Point start, Point end) {
        p1 = new Point(start.getX(), start.getY());
        p2 = new Point(end.getX(), end.getY());
    }

    /**********************************************
     * A constructor.
     * @param x1 - The X value of the first point.
     * @param y1 - The Y value of the first point.
     * @param x2 - The X value of the second point.
     * @param y2 - The Y value of the second point.
     ***********************************************/
    public Line(double x1, double y1, double x2, double y2) {
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);
    }

    /************************************************
     * Returns the first point.
     * @return - Point - the first point of the line.
     ************************************************/
    public Point getP1() {
        return p1;
    }

    /******************************************************
     * Sets a point as the new starting point for the line.
     * @param newPoint1 - a new point to be set as the start.
     ******************************************************/
    public void setP1(Point newPoint1) {
        this.p1 = newPoint1;
    }

    /**************************************************
     * Returns the second point.
     * @return - Point - the second point of the line.
     *************************************************/
    public Point getP2() {
        return p2;
    }

    /*********************************************************
     * Sets a point as the new ending point for the line.
     * @param newPoint2 - - a new point to be set as the end.
     *********************************************************/
    public void setP2(Point newPoint2) {
        this.p2 = newPoint2;
    }


    /*********************************************
     * Calculates the length of the line.
     * @return - double - the length of the line
     ********************************************/
    public double length() {
        return (this.p1).distance(this.p2);
    }

    /********************************************
     * Returns the middle point of the line.
     * @return - Point - the middle of the line.
     *******************************************/
    public Point middle() {
        double xMid = (this.p1.getX() + this.p2.getX()) / 2;
        double yMid = (this.p1.getY() + this.p2.getY()) / 2;
        return new Point(xMid, yMid);
    }

    /*************************************************************
     * Returns the starting point of the line.
     * @return - Point - returns the starting point of the line.
     ***********************************************************/
    public Point start() {
        return this.p1;
    }

    /**********************************************************
     * Returns the ending point of the line.
     * @return - Point - returns the ending point of the line.
     **********************************************************/
    public Point end() {
        return this.p2;
    }

    /**************************************************************************************************
     * Checks if the 2 lines are intersecting (in their range).
     * @param other - The line to check if it's intersecting with the first one (line.isIntersecting).
     * @return - true if intersecting in their range and false if not.
     *************************************************************************************************/
    public boolean isIntersecting(Line other) {
        if (other == null) {
            return false;
        }
        if (this.equals(other)) {
            return false;
        }
        //Getting the minimum points and the maximum points of the lines.
        double maxX1 = Math.max(this.p1.getX(), this.p2.getX());
        double minX1 = Math.min(this.p1.getX(), this.p2.getX());

        double maxX2 = Math.max(other.p1.getX(), other.p2.getX());
        double minX2 = Math.min(other.p1.getX(), other.p2.getX());

        double maxY1 = Math.max(this.p1.getY(), this.p2.getY());
        double minY1 = Math.min(this.p1.getY(), this.p2.getY());

        double maxY2 = Math.max(other.p1.getY(), other.p2.getY());
        double minY2 = Math.min(other.p1.getY(), other.p2.getY());

        //If the line is a point or parallel to the Y axis.
        if (this.p1.getX() == this.p2.getX()) {
            return (!(minY1 > maxY2) && !(maxY1 < minY2) && !(minX1 > maxX2) && !(minX1 < minX2));
        }
        if (other.p1.getX() == other.p2.getX()) {
            return (!(minY2 > maxY1) && !(maxY2 < minY1) && !(minX2 > maxX1) && !(minX2 < minX1));
        }

        //Getting the incline.
        double m1 = (this.p1.getY() - this.p2.getY()) / (this.p1.getX() - this.p2.getX());
        double m2 = (other.p1.getY() - other.p2.getY()) / (other.p1.getX() - other.p2.getX());

        //If the lines are parallel to one another.
        if (m1 == m2) {
            return (minX1 == maxX2 || maxX1 == minX2 || minY1 == maxY2 || maxY1 == minY2);
        } else {
            //this
            if (m1 == 0) {
                double yIntersection = this.p1.getY();
                if (yIntersection > Math.max(other.p1.getY(), other.p2.getY())
                    || yIntersection < Math.min(other.p1.getY(), other.p2.getY())) {
                    return false;
                }
                double xIntersection = (yIntersection + m2 * other.p1.getX() - other.p1.getY()) / m2;
                if (xIntersection > Math.max(this.p1.getX(), this.p2.getX())
                    || xIntersection > Math.max(other.p1.getX(), other.p2.getX())
                    || xIntersection < Math.min(this.p1.getX(), this.p2.getX())
                    || xIntersection < Math.min(other.p1.getX(), other.p2.getX())) {
                    return false;
                }
                return true;
            }
            //other
            if (m2 == 0) {
                double yIntersection = other.p1.getY();
                if (yIntersection > Math.max(this.p1.getY(), this.p2.getY())
                        || yIntersection < Math.min(this.p1.getY(), this.p2.getY())) {
                    return false;
                }
                double xIntersection = (yIntersection + m1 * this.p1.getX() - this.p1.getY()) / m1;
                if (xIntersection > Math.max(this.p1.getX(), this.p2.getX())
                        || xIntersection > Math.max(other.p1.getX(), other.p2.getX())
                        || xIntersection < Math.min(this.p1.getX(), this.p2.getX())
                        || xIntersection < Math.min(other.p1.getX(), other.p2.getX())) {
                    return false;
                }
                return true;
            }
            //Calculating the point of intersection.
            double xIntersection = ((m1 * this.p1.getX()) - (m2 * other.p1.getX()) + other.p1.getY() - this.p1.getY())
                    / (m1 - m2);
            double yIntersection = (m1 * xIntersection) - (m1 * this.p1.getX()) + this.p1.getY();
            xIntersection = (int) xIntersection;
            yIntersection = (int) yIntersection;
            //Checking if the point is on both lines.
            if (xIntersection > maxX1 || xIntersection < minX1 || xIntersection >  maxX2 || xIntersection < minX2) {
                return false;
            }
            if (yIntersection > maxY1 || yIntersection < minY1 || yIntersection > maxY2 || yIntersection < minY2) {
                return false;
            }
            return true;
        }
    }

    /**
     * Returns the point of the intersection of the 2 lines (if there's no intersection, returns null).
     * @param other - The second line to check the intersection with.
     * @return - Point - The point of intersection between the 2 lines.
     */
    public Point intersectionWith(Line other) {
        if (other == null) {
            return null;
        }
        if (this.isIntersecting(other)) {
            //If the line is a point or parallel to the Y axis
            if (this.p1.getX() == this.p2.getX()) {
                double m2 = (other.p1.getY() - other.p2.getY()) / (other.p1.getX() - other.p2.getX());
                double xIntersection = this.p1.getX();
                double yIntersection = (m2 * xIntersection) - (m2 * other.p1.getX()) + other.p1.getY();
                if (yIntersection < Math.min(this.p1.getY(), this.p2.getY())
                        || yIntersection > Math.max(this.p1.getY(), this.p2.getY())) {
                    return null;
                }
                return new Point((int) xIntersection, (int) yIntersection);
            }
            if (other.p1.getX() == other.p2.getX()) {
                double m1 = (this.p1.getY() - this.p2.getY()) / (this.p1.getX() - this.p2.getX());
                double xIntersection = other.p1.getX();
                double yIntersection = (m1 * xIntersection) - (m1 * this.p1.getX()) + this.p1.getY();
                if (yIntersection < Math.min(other.p1.getY(), other.p2.getY())
                    || yIntersection > Math.max(other.p1.getY(), other.p2.getY())) {
                    return null;
                }
                return new Point((int) xIntersection, (int) yIntersection);
            }
            //Getting the incline
            double m1 = (this.p1.getY() - this.p2.getY()) / (this.p1.getX() - this.p2.getX());
            double m2 = (other.p1.getY() - other.p2.getY()) / (other.p1.getX() - other.p2.getX());
            //If the lines are parallel, checking if they collide.
            if (m1 == m2) {
                if (this.p1.equals(other.p1) || this.p1.equals(other.p2)) {
                    return (new Point((int) this.p1.getX(), (int) this.p1.getY()));
                } else if (this.p2.equals(other.p1) || this.p2.equals(other.p2)) {
                    return (new Point((int) this.p2.getX(), (int) this.p2.getY()));
                }
            }
            if (m1 == 0) {
                double yIntersection = this.p1.getY();
                double xIntersection = (yIntersection + m2 * other.p1.getX() - other.p1.getY()) / m2;
                return new Point((int) xIntersection, (int) yIntersection);
            }
            if (m2 == 0) {
                double yIntersection = other.p1.getY();
                double xIntersection = (yIntersection + m1 * this.p1.getX() - this.p1.getY()) / m1;
                return new Point((int) xIntersection, (int) yIntersection);
            }
            //Getting the intersection point.
            double xIntersection = ((m1 * this.p1.getX()) - (m2 * other.p1.getX()) + other.p1.getY() - this.p1.getY())
                    / (m1 - m2);
            double yIntersection = (m1 * xIntersection) - (m1 * this.p1.getX()) + this.p1.getY();


            if (yIntersection < Math.min(other.p1.getY(), other.p2.getY())
                    || yIntersection > Math.max(other.p1.getY(), other.p2.getY())
                    || yIntersection < Math.min(this.p1.getY(), this.p2.getY())
                    || yIntersection > Math.max(this.p1.getY(), this.p2.getY())) {
                return null;
            }
            if (xIntersection < Math.min(other.p1.getX(), other.p2.getX())
                    || xIntersection > Math.max(other.p1.getX(), other.p2.getX())
                    || xIntersection < Math.min(this.p1.getX(), this.p2.getX())
                    || xIntersection > Math.max(this.p1.getX(), this.p2.getX())) {
                return null;
            }

            return new Point((int) xIntersection, (int) yIntersection);
        }
        return null;
    }

    /**
     * Checks if the 2 lines are equal.
     * @param other - The line to compare to.
     * @return - boolean - true if equal, false if not.
     */
    public boolean equals(Line other) {
        return ((this.p1.getX() == other.p1.getX()) && (this.p1.getY() == other.p1.getY())
                && (this.p2.getX() == other.p2.getX()) && (this.p2.getY() == other.p2.getY()))
                || ((this.p1.getX() == other.p2.getX()) && (this.p1.getY() == other.p2.getY())
                && (this.p2.getX() == other.p1.getX()) && (this.p2.getY() == other.p1.getY()));
    }

    /**
     * Returns the closest point to the start of the line.
     * @param point1 - Point - the first point to check.
     * @param point2 - Point - the second point to check.
     * @return - Point - the closest point to the start of the line.
     */
    public Point closerToStart(Point point1, Point point2) {
        if (point1 == null && point2 == null) {
            return null;
        }
        if (point1 == null) {
            return new Point(point2.getX(), point2.getY());
        }
        if (point2 == null) {
            return new Point(point1.getX(), point1.getY());
        }
        double p1ToStart = this.start().distance(point1);
        double p2ToStart = this.start().distance(point2);
        if (p1ToStart <= p2ToStart) {
            return new Point(point1.getX(), point1.getY());
        } else {
            return new Point(point2.getX(), point2.getY());
        }
    }

    /**
     * Returns the closest point of intersection between the rectangle and the line.
     * @param rect - The given rectangle to check the intersections with.
     * @return - Point - the closest to the start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> intersectionPoints = rect.intersectionPoints(this);
        if (!intersectionPoints.isEmpty()) {
            double min = intersectionPoints.get(0).distance(this.start());
            int i = 0;
            for (Point p: intersectionPoints) {
                if (p.distance(this.start()) < min) {
                    min  = p.distance(this.start());
                    i = intersectionPoints.indexOf(p);
                }
            }
            return intersectionPoints.get(i);
        }
        return null;
    }
}
