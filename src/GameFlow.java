import biuoop.KeyboardSensor;

import java.util.List;

/************************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A class that runs all levels in order according to a list.
 **********************************************************/
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;

    /*************************************
     * A constructor.
     * @param ar - The animation runner.
     * @param ks - The keyboard sensor.
     ***********************************/
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
    }

    /*************************************
     * Runs all levels by the given order.
     * @param levels - The list of levels.
     *************************************/
    public void runLevels(List<LevelInformation> levels) {
        int currentScore = 0;
        boolean isWin = true;
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, currentScore);

            level.initialize();

            while (level.getRemainingBlocks() != 0 && level.getRemainingBalls() != 0) { //The player clear the level.
                level.run();
            }

            if (level.getRemainingBalls() == 0) { //The player lost.
                isWin = false;
                currentScore = level.getScore();
                this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, keyboardSensor.SPACE_KEY,
                        new EndScreen(isWin, currentScore, this.keyboardSensor)));
                this.animationRunner.getGui().close();
                break;
            }
            currentScore = level.getScore();
        }
        //The player won.
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, keyboardSensor.SPACE_KEY,
                new EndScreen(isWin, currentScore, this.keyboardSensor)));
        this.animationRunner.getGui().close();
    }
}