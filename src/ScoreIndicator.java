import biuoop.DrawSurface;
import java.awt.Color;

/*********************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class to display the score on the screen.
 ********************************************/
public class ScoreIndicator implements Sprite {
    private Counter score;
    private static final int SCORE_SIZE = 15;
    private static final int WINDOW_LENGTH = 800;

    /*************************************
     * A constructor.
     * @param score - The score counter.
     ************************************/
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    /*****************************************
     * Draws the sprite to the drawsurface.
     * @param d - The drawsurface to draw to.
     ***************************************
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, WINDOW_LENGTH, SCORE_SIZE);
        d.setColor(Color.BLACK);
        d.drawText(400, SCORE_SIZE, "Score: " + this.score.getValue(), SCORE_SIZE);
    }

    /*********************************************************
     * Notifies the sprite that time has passed (a new tick).
     ********************************************************/
    @Override
    public void timePassed() {

    }

    /****************************************************
     * Adds the sprite to the game.
     *
     * @param g - The game object to add the sprite to.
     ***************************************************/
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
