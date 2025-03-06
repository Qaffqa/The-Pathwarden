package gameFlow;

import player.Player;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 *
 * @author daniel
 */
public class OptionsHandler {
    
    public static State currentState;
    public static Player player;

    public static void setState(State newState) {
        currentState = newState;
    }
    
    public static void menuChoser(State state, JButton jButton6, JButton jButton7, JButton jButton8, JButton jButton9, JTextArea jTextArea2){
        if (currentState == State.STATUS) {
            jTextArea2.setText("This are your player's stats");
        }
    }
}
