import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/************************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class that runs classes that are animations.
 **********************************************************/
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /***************
     * Constructor.
     **************/
    public AnimationRunner() {
        this.gui = new GUI("Arkanoid", 800, 600);
        this.framesPerSecond = 60;
        this.sleeper = new Sleeper();
    }

    /********************
     * @return - the GUI.
     ********************/
    public GUI getGui() {
        return this.gui;
    }

    /**************************************************************************************
     * Runs the animation given frame by frame until the animation class tells it to stop.
     * @param animation - The animation to run
     *************************************************************************************/
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = this.gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}