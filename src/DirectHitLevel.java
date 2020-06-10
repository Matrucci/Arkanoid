import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class DirectHitLevel implements LevelInformation {
    private int numberOfBalls;
    private List<Velocity> velList;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;

    public DirectHitLevel() {
        this.numberOfBalls = 1;
        this.velList = new ArrayList<>();
        Velocity vel1 = new Velocity(0, 5);
        this.velList.add(vel1);
        this.paddleSpeed = 3;
        this.paddleWidth = 80;
        this.levelName = "Direct Hit";
        this.background = null;
        this.blocks = new ArrayList<>();
        Block onlyBlock = new Block(new Rectangle(new Point(230, 200), 80, 15), Color.BLACK);
        this.blocks.add(onlyBlock);
        this.numberOfBlocksToRemove = 1;
    }
    /*********************************************
     * @return - The number of balls in the game.
     ********************************************/
    @Override
    public int numberOfBalls() {
        return this.numberOfBalls;
    }

    /***************************************************************
     * @return - The initial velocity of each ball
     * Note that initialBallVelocities().size() == numberOfBalls()
     *************************************************************/
    @Override
    public List<Velocity> initialBallVelocities() {
        return this.velList;
    }

    /*************************************
     * @return - The paddle moving speed.
     ************************************/
    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    /*****************************
     * @return - The paddle width.
     *****************************/
    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }

    /***********************************************************************
     * @return - The level name will be displayed at the top of the screen.
     ***********************************************************************/
    @Override
    public String levelName() {
        return this.levelName;
    }

    /**************************************************************
     * @return - Returns a sprite with the background of the level.
     *************************************************************/
    @Override
    public Sprite getBackground() {
        return null;
    }

    /*****************************************************************************************
     * The Blocks that make up this level, each block contains its size, color and location.
     * @return - A list with all the blocks.
     ****************************************************************************************/
    @Override
    public List<Block> blocks() {
        return this.blocks;
    }

    /*******************************************************
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     * @return - Number of blocks that should be removed.
     *****************************************************/
    @Override
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }
}
