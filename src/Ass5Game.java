import java.util.ArrayList;
import java.util.List;

/******************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * The main call that runs the game.
 *****************************************/
public class Ass5Game {
    /***********************************
     * The main function. runs the game.
     * @param args - ignored.
     ***********************************/
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        AnimationRunner ar = new AnimationRunner();
        GameFlow gf = new GameFlow(ar, ar.getGui().getKeyboardSensor());
        //levels.add(new DirectHitLevel());
        //levels.add(new WideEasyLevel());
        //levels.add(new GreenLevel());
        //levels.add(new FinalFourLevel());
        gf.runLevels(levels);
        /*
        DirectHitLevel firstLevel = new DirectHitLevel();
        WideEasyLevel secondLevel = new WideEasyLevel();
        GreenLevel thirdLevel = new GreenLevel();
        FinalFourLevel fourthLevel = new FinalFourLevel();
        GameLevel gameLevel = new GameLevel(firstLevel);
        gameLevel.initialize();
        gameLevel.run();

         */
    }
}
