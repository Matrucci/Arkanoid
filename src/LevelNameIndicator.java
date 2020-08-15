import biuoop.DrawSurface;
import java.awt.Color;

/************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class that holds and writes the level name.
 **********************************************/
public class LevelNameIndicator implements Sprite {
    private String name;
    private static final int NAME_SIZE = 15;

    /*************************************
     * A constructor.
     * @param name - The score counter.
     ************************************/
    public LevelNameIndicator(String name) {
        this.name = name;
    }

    /*****************************************
     * Draws the sprite to the drawsurface.
     * @param d - The drawsurface to draw to.
     ***************************************
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(600, NAME_SIZE, "Level name: " + this.name, NAME_SIZE);
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
