import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.awt.Color;

/************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class that sets up the game and builds it.
 ***********************************************/
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter blockCounter;
    private Counter ballCounter;
    private Counter scoreCounter;
    private BlockRemover blockRemover;
    private BallRemover ballRemover;
    private ScoreTrackingListener scoreTrackingListener;
    private ScoreIndicator scoreIndicator;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    //CONSTANTS
    private static final Color[] COLORS = {Color.GRAY, Color.RED, Color.cyan, Color.GREEN, Color.BLUE, Color.MAGENTA};
    private static final int START_POINT = 0;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BORDER_SIZE = 30;
    private static final int BORDER_START_HEIGHT = HEIGHT - BORDER_SIZE;
    private static final int BORDER_START_WIDTH = WIDTH - BORDER_SIZE;
    private static final int BLOCK_HEIGHT = 25;
    private static final int BLOCK_WIDTH = 45;
    private static final int ROWS = 6;
    private static final int BLOCKS_IN_ROW = 12;
    private static final int BALL_SIZE = 4;
    private static final int NUMBER_OFF_BALLS = 3;
    //Arbitrary starting points.
    private static final int BALL_XSTART = 250; //370
    private static final int BALL_YSTART = 250; //300
    //Starting velocity.
    private static final int DX = 3;
    private static final int DY = 4;
    private static final int FRAMES_PER_SECOND = 60;
    private static final int MS_PER_FRAME = 1000;

    /****************
     * A constructor.
     ***************/
    public GameLevel() {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.blockCounter = new Counter();
        this.ballCounter = new Counter();
        this.scoreCounter = new Counter();
        this.blockRemover = new BlockRemover(this, blockCounter);
        this.ballRemover = new BallRemover(this, ballCounter);
        this.scoreTrackingListener = new ScoreTrackingListener(this.scoreCounter);
        this.scoreIndicator = new ScoreIndicator(this.scoreCounter);
        //this.gui = new GUI("Arkanoid", WIDTH, HEIGHT);
        this.running = true;
        this.runner = new AnimationRunner();
        this.keyboard = this.runner.getGui().getKeyboardSensor();
    }

    /************************************************
     * @param c - The collidable to add to the list.
     **********************************************/
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /******************************************************
     * @param s - The drawable (Sprite) to add to the list.
     ******************************************************/
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**************************************************
     * @param c - Remove the collidable from the game.
     ************************************************/
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**********************************************
     * @param s - Remove the sprite from the game.
     *********************************************/
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /******************************
     * Creating the screen borders.
     ******************************/
    public void createBorders() {
        Block bTop = new Block(new Rectangle(new Point(START_POINT, START_POINT), WIDTH, BORDER_SIZE + 15),
                Color.BLACK);
        Block bLeft = new Block(new Rectangle(new Point(START_POINT, START_POINT), BORDER_SIZE, HEIGHT), Color.BLACK);
        Block bBot = new Block(new Rectangle(new Point(START_POINT, 600), WIDTH, 0),
                Color.BLACK);
        Block bRight = new Block(new Rectangle(new Point(BORDER_START_WIDTH, START_POINT), BORDER_SIZE, HEIGHT),
                Color.BLACK);
        bTop.addToGame(this);
        bLeft.addToGame(this);
        bBot.addToGame(this);
        bRight.addToGame(this);
        bBot.addHitListener(this.ballRemover);
    }

    /********************************************
     * Create the blocks in the desired pattern.
     ********************************************/
    public void createBlocks() {
        int xStart = WIDTH - (BLOCK_WIDTH * BLOCKS_IN_ROW) - BORDER_SIZE;
        int yStart = HEIGHT / 5; //Starting from the first fifth of the screen.
        for (int i = 0; i < ROWS; i++) {
            for (int j = i; j < BLOCKS_IN_ROW; j++) {
                Block b = new Block(new Rectangle(
                        new Point(xStart + BLOCK_WIDTH * j, yStart + BLOCK_HEIGHT * i), BLOCK_WIDTH, BLOCK_HEIGHT),
                        COLORS[i]);
                b.addToGame(this);
                b.addHitListener(this.blockRemover);
                b.addHitListener(this.scoreTrackingListener);
                this.blockCounter.increase(1);
            }
        }
    }

    /*********************************************
     * Creating and adding the balls to the game.
     ********************************************/
    public void createBalls() {
        for (int i = 0; i < NUMBER_OFF_BALLS; i++) {
            Ball ball = new Ball(BALL_XSTART, BALL_YSTART, BALL_SIZE, Color.WHITE, this.environment);
            ball.setVelocity(DX + i, DY + i);
            ball.addToGame(this);
            ballCounter.increase(1);
        }
    }

    /***********************
     * Creating the paddle.
     ***********************/
    public void createPaddle() {
        Paddle paddle = new Paddle(this.runner.getGui().getKeyboardSensor());
        paddle.addToGame(this);
    }

    /************************************************
     * @return - The Counter that counts the blocks.
     ***********************************************/
    public Counter getBlockCounter() {
        return blockCounter;
    }

    /******************************************************************************
     * Initialize a new game: create the Blocks and Ball and add them to the game.
     *****************************************************************************/
    public void initialize() {
        //Borders to the screen.
        createBorders();
        //Creates the blocks in the desired pattern and adds them to the game.
        createBlocks();
        //Create the ball and adds it to the game.
        createBalls();
        //Creating the paddle.
        createPaddle();
        this.scoreIndicator.addToGame(this);

    }


    /******************************************
     * Doing one frame of the animation.
     * @param d - The draw surface to draw on.
     ***************************************
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(START_POINT, START_POINT, WIDTH, HEIGHT);
        this.sprites.drawAllOn(d);
        //gui.show(d);
        //this.runner.getGui().show(d);
        if (this.blockCounter.getValue() == 0) {
            this.scoreCounter.increase(100);
            this.runner.getGui().close();
            //this.gui.close();
            this.running = false;
        }
        if (this.ballCounter.getValue() == 0) {
            //this.gui.close();
            this.runner.getGui().close();
            this.running = false;
        }
        this.sprites.notifyAllTimePassed();
        if (this.keyboard.isPressed("p") || this.keyboard.isPressed("פ") || this.keyboard.isPressed("P")) {
            this.runner.run(new PauseScreen(this.keyboard));
        }
    }

    /************************************************************************
     * @return - True if we should stop the animation false if we shouldn't.
     ************************************************************************/
    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /****************
     * Runs the game.
     ***************/
    public void run() {
        this.runner.run(new CountdownAnimation(3, 3, this.sprites));
        this.running = true;
        this.runner.run(this);
        /*
        Sleeper sleeper = new Sleeper();
        //Sets the number of frames.
        int framesPerSecond = FRAMES_PER_SECOND;
        int millisecondsPerFrame = MS_PER_FRAME / framesPerSecond;
        while (true) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = this.gui.getDrawSurface();
            this.doOneFrame(d);
            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
         */
    }
}