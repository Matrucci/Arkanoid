import biuoop.DrawSurface;

/******************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * An interface for drawable objects.
 *****************************************/
public interface Sprite {
    /*****************************************
     * Draws the sprite to the drawsurface.
     * @param d - The drawsurface to draw to.
     ****************************************/
    void drawOn(DrawSurface d);

    /*********************************************************
     * Notifies the sprite that time has passed (a new tick).
     ********************************************************/
    void timePassed();

    /***************************************************
     * Adds the sprite to the game.
     * @param g - The game object to add the sprite to.
     **************************************************/
    void addToGame(GameLevel g);
}