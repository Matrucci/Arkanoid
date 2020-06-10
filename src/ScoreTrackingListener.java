/*******************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class to keep track of the score.
 ******************************************/
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /*******************************************
     * A constructor.
     * @param scoreCounter - The score counter.
     ******************************************/
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /******************************************************
     * At the moment of hit, adding 5 points.
     * @param beingHit - The object that's being hit
     * @param hitter - The ball that's doing the hitting.
     *****************************************************/
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}