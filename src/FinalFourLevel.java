import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/************************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class for the fourth level (Final Four).
 **********************************************************/
public class FinalFourLevel implements LevelInformation {
    private int numberOfBalls;
    private List<Velocity> velList;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;
    private static final Color[] COLORS = {Color.GRAY, Color.RED, Color.YELLOW, Color.GREEN, Color.WHITE, Color.MAGENTA,
                                            Color.CYAN};

    /*****************
     * A constructor.
     ****************/
    public FinalFourLevel() {
        this.numberOfBalls = 3;
        this.velList = new ArrayList<>();
        this.paddleSpeed = 5;
        this.paddleWidth = 80;
        this.levelName = "Final Four";
        this.background = new Block(new Rectangle(new Point(0, 0), 800, 600),
                new Color(255, 102, 102));
        this.blocks = new ArrayList<>();
        this.numberOfBlocksToRemove = 112;
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
        for (int i = 0; i < this.numberOfBalls; i++) {
            Velocity vel = Velocity.fromAngleAndSpeed(330 + i * 30, 5);
            this.velList.add(vel);
        }
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
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 16; j++) {
                Rectangle rec = new Rectangle(new Point(30 + j * 46.25, 150 + i * 15), 46.25, 15);
                Block b = new Block(rec, COLORS[i]);
                this.blocks.add(b);
            }
        }
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
