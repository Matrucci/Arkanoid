import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/************************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class for the end screen (You Win/Game Over).
 **********************************************************/
public class EndScreen implements Animation {
    private boolean isWin;
    private boolean running;
    private int score;
    private KeyboardSensor keyboard;

    /*********************************************
     * A constructor.
     * @param isWin - If the player won or lost.
     * @param score - The score the player got.
     * @param keyboard - The keyboard sensor.
     ********************************************/
    public EndScreen(boolean isWin, int score, KeyboardSensor keyboard) {
        this.isWin = isWin;
        this.running = true;
        this.score = score;
        this.keyboard = keyboard;
    }

    /******************************************
     * Doing one frame of the animation.
     * @param d - The draw surface to draw on.
     ***************************************
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.isWin) {
            d.drawText(200, d.getHeight() / 2, "You Win! Your score is " + this.score, 32);
        } else {
            d.drawText(200, d.getHeight() / 2, "Game Over! Your score is " + this.score, 32);
        }
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.running = false;
        }
    }

    /************************************************************************
     * @return - True if we should stop the animation false if we shouldn't.
     ************************************************************************/
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}
