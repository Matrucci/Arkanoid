import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/************************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class for the second level (Wide Easy).
 **********************************************************/
public class WideEasyLevel implements LevelInformation {
    private int numberOfBalls;
    private List<Velocity> velList;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;
    private static final Color[] COLORS = {Color.RED, Color.RED, Color.ORANGE, Color.ORANGE, Color.YELLOW, Color.YELLOW,
                                            Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.BLUE, Color.BLUE,
                                            Color.MAGENTA, Color.MAGENTA, Color.CYAN, Color.CYAN};

    /*****************
     * A constructor.
     ****************/
    public WideEasyLevel() {
        this.numberOfBalls = 10;
        this.velList = new ArrayList<>();
        for (int i = 0; i < this.numberOfBalls; i++) {
            //We want to balls to have different velocities where they will appear in a circle.
            Velocity vel;
            if (i >= 5) {
                vel = Velocity.fromAngleAndSpeed(310 + (i + 1) * 10, 5);
            } else {
                vel = Velocity.fromAngleAndSpeed(310 + i * 10, 5);
            }
            this.velList.add(vel);
        }
        this.paddleSpeed = 5;
        this.paddleWidth = 670;
        this.levelName = "Wide Easy";
        //Just a plain white background.
        this.background = new Block(new Rectangle(new Point(0, 0), 800, 600), Color.WHITE);
        this.blocks = new ArrayList<>();
        this.numberOfBlocksToRemove = 16;
        for (int i = 0; i < this.numberOfBlocksToRemove; i++) {
            Rectangle rec = new Rectangle(new Point(30 + (46.25 * i), 270), 46.25, 15);
            Block block = new Block(rec, COLORS[i]);
            this.blocks.add(block);
        }
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
        return this.background;
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
