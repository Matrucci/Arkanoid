import java.util.List;

public interface LevelInformation {
    /*********************************************
     * @return - The number of balls in the game.
     ********************************************/
    int numberOfBalls();

    /***************************************************************
     * @return - The initial velocity of each ball
     * Note that initialBallVelocities().size() == numberOfBalls()
     *************************************************************/
    List<Velocity> initialBallVelocities();

    /*************************************
     * @return - The paddle moving speed.
     ************************************/
    int paddleSpeed();

    /*****************************
     * @return - The paddle width.
     *****************************/
    int paddleWidth();

    /***********************************************************************
     * @return - The level name will be displayed at the top of the screen.
     ***********************************************************************/
    String levelName();

    /**************************************************************
     * @return - Returns a sprite with the background of the level.
     *************************************************************/
    Sprite getBackground();

    /*****************************************************************************************
     * The Blocks that make up this level, each block contains its size, color and location.
     * @return - A list with all the blocks.
     ****************************************************************************************/
    List<Block> blocks();

    /*******************************************************
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     * @return - Number of blocks that should be removed.
     *****************************************************/
    int numberOfBlocksToRemove();
}