import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/*********************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class to represent a block (a collidable rectangle).
 *******************************************************/
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rect;
    private Color color;
    private static final int CHANGE_SIGN = -1;
    private List<HitListener> hitListeners;

    /****************************************************************************
     * A constructor (gives the block a default black color if nothing was set).
     * @param rectangle - The rectangle that represent the block on the screen.
     ***************************************************************************/
    public Block(Rectangle rectangle) {
        this.rect = rectangle;
        this.color = Color.GRAY;
        this.hitListeners = new ArrayList<>();
    }


    /***************************************************************************
     * A constructor.
     * @param rectangle - The rectangle that represent the block on the screen.
     * @param color - The color of the block.
     **************************************************************************/
    public Block(Rectangle rectangle, Color color) {
        this.rect = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }


    /************************************************
     * Sets a new color to the block.
     * @param newColor - The new color of the block.
     ************************************************/
    public void setColor(Color newColor) {
        this.color = newColor;
    }

    /*************************************************************
     * Returns the rectangle that represents the specific block.
     * @return - The rectangle that represents the block.
     ***********************************************************/
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**************************************************************************
     * Checks where the collision point is to know how to change the velocity.
     * @param collisionPoint - The point where the object hit the block.
     * @param currentVelocity - The current velocity of the object.
     * @param hitter - The ball that hit.
     * @return - Velocity - The new velocity after the hit.
     ************************************************************************/
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //Builds points to the corners.
        Point upperLeft = new Point(this.rect.getUpperLeft().getX(), this.rect.getUpperLeft().getY());
        Point upperRight = new Point(this.rect.getUpperLeft().getX() + this.rect.getWidth(),
                this.rect.getUpperLeft().getY());
        Point lowerLeft = new Point(this.rect.getUpperLeft().getX(),
                this.rect.getUpperLeft().getY() + this.rect.getHeight());
        Point lowerRight = new Point(this.rect.getUpperLeft().getX() + this.rect.getWidth(),
                this.rect.getUpperLeft().getY() + this.rect.getHeight());
        //Gets the X and Y values of the velocity.
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        //Checks if the object hit one of the corners.
        if ((collisionPoint.equals(upperLeft) && dx > 0 && dy > 0)
            || (collisionPoint.equals(upperRight) && dx < 0 && dy > 0)
            || (collisionPoint.equals(lowerLeft) && dx > 0 && dy < 0)
            || (collisionPoint.equals(lowerRight) && dx < 0 && dy < 0)) {
            this.notifyHit(hitter);
            return new Velocity(CHANGE_SIGN * dx, CHANGE_SIGN * dy);
        }
        //Checks if the object hit the left or right edges.
        if ((int) collisionPoint.getX() >= (int) upperRight.getX()
                || (int) collisionPoint.getX() <= (int) upperLeft.getX()) {
            dx = CHANGE_SIGN * dx;
        }
        //Checks if the object hit the top or bottom edges.
        if ((int) collisionPoint.getY() <= (int) upperLeft.getY()
                || (int) collisionPoint.getY() >= (int) lowerLeft.getY()) {
            dy = CHANGE_SIGN * dy;
        }
        this.notifyHit(hitter);
        return new Velocity(dx, dy);
    }

    /*******************************************************************************************
     * Draws a rectangle (block) to the drawing surface in the defines size, color and position.
     * @param surface - DrawSurface - the drawing surface.
     *******************************************************************************************/
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
    }

    /*****************************************************
     * Runs all the functions that need to run every tick.
     * (nothing for now).
     *****************************************************/
    @Override
    public void timePassed() {

    }

    /*************************************************************************************************
     * Gets a game object and adds the block to the drawable objects set and collidable objects sets.
     * @param g - The game object to which we need to add the ball to.
     *************************************************************************************************/
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /*****************************************************************************************************
     * Gets a game object and removes the block from the drawable objects set and collidable objects sets.
     * @param gameLevel - The game object to which we need to remove the ball from.
     *****************************************************************************************************/
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    /**************************************************
     * @param hl - Add hl as a listener to hit events.
     ************************************************
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /******************************************************************
     * @param hl - Remove hl from the list of listeners to hit events.
     *****************************************************************
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /***************************************************************
     * This method notifies all listeners that a hit has occurred.
     * @param hitter - The ball that hit.
     ***************************************************************/
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
