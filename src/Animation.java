import biuoop.DrawSurface;

/***********************
 * Animation interface.
 **********************/
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