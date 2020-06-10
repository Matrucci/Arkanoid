import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /******************************************
     * Doing one frame of the animation.
     * @param d - The draw surface to draw on.
     ***************************************
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /************************************************************************
     * @return - True if we should stop the animation false if we shouldn't.
     ************************************************************************/
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
