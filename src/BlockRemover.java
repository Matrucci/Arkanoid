/****************************************************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 ***************************************************************************************/
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /***************************************
     * A constructor.
     * @param gameLevel - The game object.
     * @param removedBlocks - The counter.
     ***************************************/
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }

    /******************************************************
     * Blocks that are hit should be removed.
     * @param beingHit - The object that's being hit
     * @param hitter - The ball that's doing the hitting.
     *****************************************************/
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.gameLevel);
        beingHit.removeHitListener(this);
        this.remainingBlocks.decrease(1);
    }
}