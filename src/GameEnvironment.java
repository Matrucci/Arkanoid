import java.util.ArrayList;
import java.util.List;

/*************************************************************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class that holds the information about all the pieces on the board that can be collided with.
 *************************************************************************************************/
public class GameEnvironment {
    private List<Collidable> collidables;

    /*****************
     * A constructor.
     ****************/
    public GameEnvironment() {
        collidables = new ArrayList<>();
    }

    /**************************************************
     * @param c - Adds a collidable to the collection.
     *************************************************/
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /*********************************************************
     * @param c - Removes the collidable from the collection.
     ********************************************************/
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }

    /****************************************************************************************************
     * Returns the information for the closest collision from the start of the line.
     * @param trajectory - The trajectory of the ball (where from the current location to the next one).
     * @return - The collision information (the block of collision and the point of collision).
     ****************************************************************************************************/
    public CollisionInfo getClosestCollision(Line trajectory) {
        Collidable col = null;
        Rectangle recTemp;
        Point temp, colPoint = null;
        double currentDistance, min = Double.POSITIVE_INFINITY;
        for (Collidable c: collidables) {
            recTemp = c.getCollisionRectangle();
            temp = trajectory.closestIntersectionToStartOfLine(recTemp);
            if (temp != null) {
                currentDistance = trajectory.start().distance(temp);
                if (currentDistance < min) {
                    col = c;
                    min = currentDistance;
                    colPoint = temp;
                }
            }
        }
        if (col == null) {
            return null;
        }
        return new CollisionInfo(col, new Point((int) colPoint.getX(), (int) colPoint.getY()));
    }
}