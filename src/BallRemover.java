/****************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class to remove balls once they hit the bottom.
 ***************************************************/
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /*************************************
     * A constructor.
     * @param gameLevel - The game object.
     * @param removedBalls - The counter.
     ************************************/
    public BallRemover(GameLevel gameLevel, Counter removedBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = removedBalls;
    }
    /*******************************************************
     * Balls that hit the bottom are removed from the game.
     * @param beingHit - The object that's being hit
     * @param hitter - The ball that's doing the hitting.
     *******************************************************/
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        this.remainingBalls.decrease(1);
    }
}
