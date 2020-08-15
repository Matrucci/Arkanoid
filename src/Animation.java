import biuoop.DrawSurface;

/********************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * Animation interface.
 *******************************************/
public interface Animation {
    /******************************************
     * Doing one frame of the animation.
     * @param d - The draw surface to draw on.
     ****************************************/
    void doOneFrame(DrawSurface d);

    /************************************************************************
     * @return - True if we should stop the animation false if we shouldn't.
     ************************************************************************/
    boolean shouldStop();
}