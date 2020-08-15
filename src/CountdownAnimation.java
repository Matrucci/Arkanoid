import biuoop.DrawSurface;
import biuoop.Sleeper;

/************************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class for the countdown before each level.
 **********************************************************/
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private int timeLeft;

    /******************************************************************************
     * A constructor.
     * @param numOfSeconds - The number of seconds for the screen to be displayed.
     * @param countFrom - Starting count from this to 1.
     * @param gameScreen - All the elements to be shown on the screen.
     ******************************************************************************/
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.timeLeft = countFrom;
    }

    /******************************************
     * Doing one frame of the animation.
     * @param d - The draw surface to draw on.
     ****************************************/
    @Override
    public void doOneFrame(DrawSurface d) {
        Sleeper sleeper = new Sleeper();
        this.gameScreen.drawAllOn(d);
        d.drawText(d.getWidth() / 3 + 70, d.getHeight() / 2 + 100, Integer.toString(this.timeLeft), 200);
        this.timeLeft = this.timeLeft - 1;
        sleeper.sleepFor((long) ((this.numOfSeconds / this.countFrom) * 1000));
        /*
        int millisecondsPerFrame = (int) ((this.numOfSeconds / countFrom) * 1000 / 60);
        long startTime = System.currentTimeMillis(); // timing
        long usedTime = System.currentTimeMillis() - startTime;
        long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
        if (milliSecondLeftToSleep > 0) {
            sleeper.sleepFor(milliSecondLeftToSleep);
        }
         */
        //this.countFrom = this.countFrom - 1;
    }

    /************************************************************************
     * @return - True if we should stop the animation false if we shouldn't.
     ************************************************************************/
    public boolean shouldStop() {
        return (this.timeLeft < 0);
    }
}