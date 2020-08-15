import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/************************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * The third level of the game (Green 3).
 **********************************************************/
public class GreenLevel implements LevelInformation {
    private int numberOfBalls;
    private List<Velocity> velList;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;
    //CONTANTS
    private static final Color[] COLORS = {Color.GRAY, Color.RED, Color.cyan,
                                            Color.darkGray, Color.BLUE, Color.MAGENTA};
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BORDER_SIZE = 30;
    private static final int BLOCK_HEIGHT = 25;
    private static final int BLOCK_WIDTH = 45;
    private static final int ROWS = 6;
    private static final int BLOCKS_IN_ROW = 12;

    /****************
     * A constructor.
     ****************/
    public GreenLevel() {
        this.numberOfBalls = 2;
        this.velList = new ArrayList<>();
        for (int i = 0; i < this.numberOfBalls; i++) {
            //Velocity vel = new Velocity(Math.pow(-1, i) * 3, 3);
            Velocity vel = Velocity.fromAngleAndSpeed(330 + 60 * i, 5);
            this.velList.add(vel);
        }
        this.paddleSpeed = 5;
        this.paddleWidth = 80;
        this.levelName = "Green 3";
        this.background = new Block(new Rectangle(new Point(0, 0), 800, 600),
                new Color(102, 255, 102));
        this.blocks = new ArrayList<>();
        this.numberOfBlocksToRemove = 57;
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
        int xStart = WIDTH - (BLOCK_WIDTH * BLOCKS_IN_ROW) - BORDER_SIZE;
        int yStart = HEIGHT / 5; //Starting from the first fifth of the screen.
        for (int i = 0; i < ROWS; i++) {
            for (int j = i; j < BLOCKS_IN_ROW; j++) {
                Block b = new Block(new Rectangle(
                        new Point(xStart + BLOCK_WIDTH * j, yStart + BLOCK_HEIGHT * i), BLOCK_WIDTH, BLOCK_HEIGHT),
                        COLORS[i]);
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
