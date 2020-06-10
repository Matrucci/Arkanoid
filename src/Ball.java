import biuoop.DrawSurface;
import java.awt.Color;

/************************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class that represents a ball with the ability to move.
 **********************************************************/
public class Ball implements Sprite {
    private Point center; //The center of the ball.
    private int radius; //The radius of the ball.
    private Color color; //The color of the ball.
    private Velocity velocity; //The velocity of the ball.
    private GameEnvironment game; //The game environment.
    private static final int SIDES_OF_RECTANGLE = 4;
    /************************************************
     * A constructor.
     * @param center - The center point of the ball.
     * @param r - The radius of the ball.
     * @param color - The color of the ball.
     ***********************************************/
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
        this.game = null;
    }

    /**********************************************
     * A constructor.
     * @param x - The X value of the center point.
     * @param y - The Y value of the center point.
     * @param radius - The radius of the ball.
     * @param color - The color of the ball.
     **********************************************/
    public Ball(double x, double y, int radius, Color color) {
        center = new Point(x, y);
        this.radius = radius;
        this.color = color;
        this.velocity = new Velocity(0, 0);
        this.game = null;
    }

    /************************************************
     * A constructor.
     * @param center - The center point of the ball.
     * @param r - The radius of the ball.
     * @param color - The color of the ball.
     * @param game - the game environment.
     ***********************************************/
    public Ball(Point center, int r, Color color, GameEnvironment game) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
        this.game = game;
    }

    /**********************************************
     * A constructor.
     * @param x - The X value of the center point.
     * @param y - The Y value of the center point.
     * @param radius - The radius of the ball.
     * @param color - The color of the ball.
     * @param game - the game environment.
     **********************************************/
    public Ball(double x, double y, int radius, Color color, GameEnvironment game) {
        center = new Point(x, y);
        this.radius = radius;
        this.color = color;
        this.velocity = new Velocity(0, 0);
        this.game = game;
    }

    /***********************************************************
     * Returns the X value of the center of the ball.
     * @return - int - returns the X value of the center.
     ***********************************************************/
    public int getX() {
        return (int) this.center.getX();
    }

    /***********************************************************
     * Returns the Y value of the center of the ball.
     * @return - int - returns the Y value of the center.
     ***********************************************************/
    public int getY() {
        return (int) this.center.getY();
    }

    /****************************************************
     * Returns the size (radius) of the ball.
     * @return - int - the size of the ball.
     ****************************************************/
    public int getSize() {
        return this.radius;
    }

    /*******************************************
     * Returns the color of the ball.
     * @return - Color - the color of the ball.
     ******************************************/
    public Color getColor() {
        return this.color;
    }

    /***************************************************************************************
     * Draws a circle (ball) to the drawing surface in the defines size, color and position.
     * @param surface - DrawSurface - the drawing surface.
     ***************************************************************************************/
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
    }

    /*****************************************************
     * Runs all the functions that need to run every tick.
     * (For now only the moveOneStep method).
     *****************************************************/
    @Override
    public void timePassed() {
        moveOneStep();
    }

    /********************************************************************
     * Gets a game object and adds the ball to the drawable objects set.
     * @param g - The game object to which we need to add the ball to.
     ******************************************************************/
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /*****************************************************************************************************
     * Gets a game object and removes the block from the drawable objects set and collidable objects sets.
     * @param g - The game object to which we need to remove the ball from.
     *****************************************************************************************************/
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

    /********************************************
     * Sets a new velocity to the given velocity.
     * @param v - Velocity.
     ********************************************/
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /*****************************************************
     * Sets a new velocity according to the given dx, dy.
     * @param dx - The new X axis velocity.
     * @param dy - The new Y axis velocity.
     ****************************************************/
    public void setVelocity(double dx, double dy) {
        this.velocity.setDx(dx);
        this.velocity.setDy(dy);
    }

    /**********************************************************
     * Returns the velocity of the ball.
     * @return - Velocity - The current velocity of the ball.
     *********************************************************/
    public Velocity getVelocity() {
        return this.velocity;
    }

    /********************************************************************************************
     * Checks to see if there was a collision in order to know if we should change the velocity
     * then applies the new move.
     ******************************************************************************************/
    public void moveOneStep() {
        for (int i = 0; i < SIDES_OF_RECTANGLE; i++) {
            Line trajectory = new Line(this.center, this.getVelocity().applyToPoint(this.center));
            CollisionInfo collision = this.game.getClosestCollision(trajectory);
            if (collision != null) {
                Point collisionPoint = collision.collisionPoint();
                Collidable collisionObject = collision.collisionObject();
                Velocity newVel = collisionObject.hit(this, collisionPoint, this.getVelocity());
                this.setVelocity(newVel);
            } else {
               break;
            }
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }
    /*******************************************************************
     * Changes the direction (velocity) of the ball if hits the border.
     * @param startX - The left edge of the screen.
     * @param startY - The top edge of the screen.
     * @param height - The bottom edge of the screen.
     * @param width - The right edge of the screen.
     ******************************************************************/
    public void moveOneStep(int startX, int startY, int height, int width) {
        if (this.getX() + this.getSize() >= width && this.getVelocity().getDx() > 0) {
            Velocity v = this.getVelocity();
            v.setDx(-(v.getDx()));
            this.setVelocity(v);
        }
        if (this.getX() - this.getSize() <= startX && this.getVelocity().getDx() < 0) {
            Velocity v = this.getVelocity();
            v.setDx(-(v.getDx()));
            this.setVelocity(v);
        }
        if (this.getY() + this.getSize() >= height && this.getVelocity().getDy() > 0) {
            Velocity v = this.getVelocity();
            v.setDy(-(v.getDy()));
            this.setVelocity(v);
        }
        if (this.getY() - this.getSize() <= startY && this.getVelocity().getDy() < 0) {
            Velocity v = this.getVelocity();
            v.setDy(-(v.getDy()));
            this.setVelocity(v);
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }
}