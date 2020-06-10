import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/*************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class that represents a paddle (the player).
 ************************************************/
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle paddleRec;
    private static final int XSTART = 350;
    private static final int YSTART = 560;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 10;
    private static final int UNITS = 5;
    private static final int SCRREN_WIDTH = 800;
    private static final int SCRREN_HEIGHT = 600;
    private static final int BORDER_SIZE = 30;
    private static final int FIRST_PART = 300;
    private static final int SECOND_PART = 330;
    private static final int FOURTH_PART = 30;
    private static final int FIFTH_PART = 60;

    /***************************************************************
     * A constructor.
     * @param paddleRec - The rectangle that represents the paddle.
     * @param keyboard - The keyboard sensor.
     **************************************************************/
    public Paddle(Rectangle paddleRec, biuoop.KeyboardSensor keyboard) {
        this.paddleRec = paddleRec;
        this.keyboard = keyboard;
    }
    /***************************************************************
     * A constructor.
     * @param keyboard - The keyboard sensor.
     **************************************************************/
    public Paddle(biuoop.KeyboardSensor keyboard) {
        this.paddleRec = new Rectangle(new Point(XSTART, YSTART), WIDTH, HEIGHT);
        this.keyboard = keyboard;
    }

    /***********************************************************************************
     * Moves the paddle 5 pixels to the left (as long as we are still inside the border).
     ***********************************************************************************/
    public void moveLeft() {
        if (this.paddleRec.getUpperLeft().getX() != BORDER_SIZE) {
            this.paddleRec.getUpperLeft().setX(paddleRec.getUpperLeft().getX() - UNITS);
        }
    }

    /***********************************************************************************
     * Moves the paddle 5 pixels to the right (as long as we are still inside the border).
     ***********************************************************************************/
    public void moveRight() {
        double xMax = SCRREN_WIDTH - this.paddleRec.getWidth() - BORDER_SIZE;
        if (this.paddleRec.getUpperLeft().getX() != xMax) {
            this.paddleRec.getUpperLeft().setX(paddleRec.getUpperLeft().getX() + UNITS);
        }
    }

    /****************************************************
     * Draws the paddle to the screen.
     * @param d - The drawsurface to draw the paddle to.
     ***************************************************/
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.ORANGE);
        d.fillRectangle((int) this.paddleRec.getUpperLeft().getX(), (int) this.paddleRec.getUpperLeft().getY(),
                (int) this.paddleRec.getWidth(), (int) this.paddleRec.getHeight());
    }

    /********************************************************************************************
     * Every tick checks if the player tried to move the paddle by pressing the keyboard arrows.
     *******************************************************************************************/
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**************************************************************
     * Returns the rectangle that represents the paddle.
     * @return - Rectangle - The rectangle represents the paddle.
     *************************************************************/
    @Override
    public Rectangle getCollisionRectangle() {
        return this.paddleRec;
    }

    /*****************************************************************************************
     * Checks where the collision point is to know how to change the velocity.
     * @param collisionPoint - The point of collision with the collidable object.
     * @param currentVelocity - The current velocity of the object that hit the collidable.
     * @param hitter - The ball that hit.
     * @return - Velocity - The new velocity after the hit.
     ****************************************************************************************/
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double xUpperLeft = this.paddleRec.getUpperLeft().getX();
        //dividing the paddle to 5 parts, each part returns a different velocity.
        double xPart1 = this.paddleRec.getUpperLeft().getX() + (this.paddleRec.getWidth() / 5);
        double xPart2 = this.paddleRec.getUpperLeft().getX() + 2 * (this.paddleRec.getWidth() / 5);
        double xPart3 = this.paddleRec.getUpperLeft().getX() + 3 * (this.paddleRec.getWidth() / 5);
        double xPart4 = this.paddleRec.getUpperLeft().getX() + 4 * (this.paddleRec.getWidth() / 5);
        double xPart5 = this.paddleRec.getUpperLeft().getX() + 5 * (this.paddleRec.getWidth() / 5);
        double colX = collisionPoint.getX();
        if (collisionPoint.getY() != this.paddleRec.getUpperLeft().getY()) {
            return new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
        }
        if (colX >= xUpperLeft && colX < xPart1) {
            return Velocity.fromAngleAndSpeed(FIRST_PART, currentVelocity.getForce());
        }
        if (colX >= xPart1 && colX < xPart2) {
            return Velocity.fromAngleAndSpeed(SECOND_PART, currentVelocity.getForce());
        }
        if (colX >= xPart2 && colX < xPart3) {
            return new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
        }
        if (colX >= xPart3 && colX < xPart4) {
            return Velocity.fromAngleAndSpeed(FOURTH_PART, currentVelocity.getForce());
        }
        if (colX >= xPart4 && colX <= xPart5) {
            return Velocity.fromAngleAndSpeed(FIFTH_PART, currentVelocity.getForce());
        }
        return currentVelocity;
    }

    /*************************************************************************************************
     * Gets a game object and adds the block to the drawable objects set and collidable objects sets.
     * @param g - The game object to which we need to add the ball to.
     ************************************************************************************************/
    @Override
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}