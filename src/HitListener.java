/*************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * HitListener Interface.
 *************************/
public interface HitListener {
    /*************************************************************
     * This method is called whenever the beingHit object is hit.
     * @param beingHit - The object that's being hit
     * @param hitter - The ball that's doing the hitting.
     **************************************************************/
    void hitEvent(Block beingHit, Ball hitter);
}