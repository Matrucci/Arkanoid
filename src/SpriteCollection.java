import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/************************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class that holds all the drawable objects on the board.
 ***********************************************************/
public class SpriteCollection {
    private List<Sprite> sprites;

    /***************
     * Constructor.
     **************/
    public SpriteCollection() {
        this.sprites = new ArrayList<>();
    }

    /****************************************************
     * Adds a sprite to the collection.
     * @param s - a new Sprite to add to the collection.
     ****************************************************/
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /***********************************************
     * @param s - Removes the sprite from the list.
     **********************************************/
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }

    /*****************************************************************
     * Use the method "timePassed" on every object in the collection.
     ****************************************************************/
    public void notifyAllTimePassed() {
        List<Sprite> updatedSprites = new ArrayList<Sprite>(this.sprites);
        for (Sprite s: updatedSprites) {
            s.timePassed();
        }
    }
    /*****************************************
     * Draws all sprites to the surface.
     * @param d - the DrawSurface to draw on.
     *****************************************/
    public void drawAllOn(DrawSurface d) {
        for (Sprite s: sprites) {
            s.drawOn(d);
        }
    }
}