/******************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * An interface for collidable objects.
 *****************************************/
public interface Collidable {
    /*********************************************************************
     * @return - Rectangle - gets the rectangle of the collidable objects.
     ********************************************************************/
    Rectangle getCollisionRectangle();
    /*******************************************************************************************
     * Returns a new velocity based on the point in which the object hit the collidable object.
     * @param collisionPoint - The point of collision with the collidable object.
     * @param currentVelocity - The current velocity of the object that hit the collidable.
     * @param hitter - The ball that hit.
     * @return - Velocity - The new velocity of the object after the hit with the collidable.
     ******************************************************************************************/
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}