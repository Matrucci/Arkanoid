import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/************************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A decorator for all animations that are stoppable by key.
 **********************************************************/
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;
    private boolean running;

    /*************************************************************
     * A constructor.
     * @param sensor - The keyboard sensor.
     * @param key - The key we need to press to exit the screen.
     * @param animation - The animation we need to run.
     ************************************************************/
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.isAlreadyPressed = true;
        this.running = true;
    }

    /******************************************
     * Doing one frame of the animation.
     * @param d - The draw surface to draw on.
     ****************************************/
    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.sensor.isPressed(this.key) && !this.isAlreadyPressed) {
            this.running = false;
        }
        if (!this.sensor.isPressed(this.key)) {
            this.isAlreadyPressed = false;
        }
        this.animation.doOneFrame(d);
    }

    /************************************************************************
     * @return - True if we should stop the animation false if we shouldn't.
     ************************************************************************/
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}
