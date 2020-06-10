/**************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * HitNotifier interface.
 *************************/
public interface HitNotifier {

    /**************************************************
     * @param hl - Add hl as a listener to hit events.
     *************************************************/
    void addHitListener(HitListener hl);

    /******************************************************************
     * @param hl - Remove hl from the list of listeners to hit events.
     ******************************************************************/
    void removeHitListener(HitListener hl);
}