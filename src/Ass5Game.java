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
        GameLevel gameLevel = new GameLevel();
        gameLevel.initialize();
        gameLevel.run();
    }
}
