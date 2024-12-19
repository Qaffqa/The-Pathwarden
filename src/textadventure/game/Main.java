package textadventure.game;

/**
 * The Main class contains the entry point for the game. 
 * It initializes a new Game object and starts the game by calling 
 * its start method.
 * 
 * <p>When run, this class will launch the text adventure game and allow 
 * the player to interact with it through commands.</p>
 * 
 * @author qaffqa
 */
public class Main {

    /**
     * The main method is the entry point for the program.
     * It creates a Game object and starts the game by calling the
     * start method.
     * 
     * @param args Command line arguments (not used in this game).
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.start();

    }
}
