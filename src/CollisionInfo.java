/*****************************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class that holds the needed information about the collision.
 ****************************************************************/
public class CollisionInfo {
    private Collidable cObject;
    private Point cPoint;

    /******************************************
     * A constructor.
     * @param cObject - The collidable object.
     * @param cPoint - The point of collision.
     *****************************************/
    public CollisionInfo(Collidable cObject, Point cPoint) {
        this.cObject = cObject;
        this.cPoint = cPoint;
    }

    /********************************************
     * @return - Point - The point of collision.
     *******************************************/
    public Point collisionPoint() {
        return this.cPoint;
    }

    /*************************************************
     * @return - Collidable - The object of collision.
     *************************************************/
    public Collidable collisionObject() {
        return this.cObject;
    }
}