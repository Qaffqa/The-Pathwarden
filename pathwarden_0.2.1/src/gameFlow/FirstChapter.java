package gameFlow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import player.Player;

/**
 *
 * @author daniel
 */
public class FirstChapter extends ChoiceHandler{
    
    public static void unListenButtons(javax.swing.JButton jButton1, javax.swing.JButton jButton2, javax.swing.JButton jButton3, javax.swing.JButton jButton4, javax.swing.JButton jButton5){
        for (java.awt.event.ActionListener al : jButton1.getActionListeners()) {
            jButton1.removeActionListener(al);
        }
        for (java.awt.event.ActionListener al : jButton2.getActionListeners()) {
            jButton2.removeActionListener(al);
        }
        for (java.awt.event.ActionListener al : jButton3.getActionListeners()) {
            jButton3.removeActionListener(al);
        }
        for (java.awt.event.ActionListener al : jButton4.getActionListeners()) {
            jButton4.removeActionListener(al);
        }
        for (java.awt.event.ActionListener al : jButton5.getActionListeners()) {
            jButton5.removeActionListener(al);
        }
    }
    
    public static State currentState = State.CLASS_SELECTION;

    public static void setState(State newState) {
        currentState = newState;
    }

    public static void firstChapter(State state, javax.swing.JTextArea textArea, javax.swing.JLabel jLabel1, Player player,
            javax.swing.JButton jButton1, javax.swing.JButton jButton2, javax.swing.JButton jButton3, javax.swing.JButton jButton4, javax.swing.JButton jButton5) {

        if (state == State.CHAPTER_ONE_BEGINNING) {
            jLabel1.setIcon(new javax.swing.ImageIcon(ChoiceHandler.class.getResource("/img/underking.png")));
            textArea.setText("     The very");
            jButton1.setText("Norte");
            jButton2.setText("Sur");
            jButton3.setText("Este");
            jButton4.setText("Oeste");
            jButton5.setText("");
            
            unListenButtons(jButton1, jButton2, jButton3, jButton4, jButton5);
            
            //reenlazar los action listeners
            jButton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setState(State.CHAPTER_ONE_BEGINNING);
                    // Actualiza la UI después de cambiar de estado
                    
                }
            });
            jButton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setState(State.CHAPTER_ONE_BEGINNING);
                }
            });
            jButton3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setState(State.CHAPTER_ONE_BEGINNING);
                }
            });
            jButton4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setState(State.CHAPTER_ONE_BEGINNING);
                   
                }
            });
            jButton5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setState(State.CHAPTER_ONE_BEGINNING);
                }
            });
        }
    }
}
