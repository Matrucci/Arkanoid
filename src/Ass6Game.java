import java.util.ArrayList;
import java.util.List;

/***************************************************************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * Main class that runs the game according to the given levels.
 **************************************************************/
public class Ass6Game {
    /************************************************************
     * Runs all levels given in args by order.
     * If nothing is given in args, runs all 4 levels by order.
     * @param args - The levels to run by order.
     ************************************************************/
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        AnimationRunner ar = new AnimationRunner();
        GameFlow gf = new GameFlow(ar, ar.getGui().getKeyboardSensor());
        //If nothing in given in args runs all levels by order.
        if (args.length == 0 || args[0].equals("${args}")) {
            levels.add(new DirectHitLevel());
            levels.add(new WideEasyLevel());
            levels.add(new GreenLevel());
            levels.add(new FinalFourLevel());
            gf.runLevels(levels);
        } else { //If args isn't empty, runs all levels by the given order.
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "1":
                        levels.add(new DirectHitLevel());
                        break;
                    case "2":
                        levels.add(new WideEasyLevel());
                        break;
                    case "3":
                        levels.add(new GreenLevel());
                        break;
                    case "4":
                        levels.add(new FinalFourLevel());
                        break;
                    default:
                        break;
                }
            }
            gf.runLevels(levels);
        }
    }
}
