package gameFlow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import player.Player;
/**
 * 
 * @author daniel
 */


public class ChoiceHandler{
    
    public static String husk;
    public static State currentState = State.CLASS_SELECTION;
    public static Player player;
    
    public static void setState(State newState) {
        currentState = newState;
    }
    
    
    public static void unListenButtons(javax.swing.JButton jButton1, javax.swing.JButton jButton2, javax.swing.JButton jButton3,
            javax.swing.JButton jButton4, javax.swing.JButton jButton5){
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
    
    
    public static void classChoser(State state, javax.swing.JTextArea textArea, javax.swing.JLabel jLabel1, Player player,
            javax.swing.JButton jButton1, javax.swing.JButton jButton2, javax.swing.JButton jButton3, javax.swing.JButton jButton4, javax.swing.JButton jButton5) {

        if (state == State.CLASS_SELECTION) {
                jLabel1.setIcon(new javax.swing.ImageIcon(ChoiceHandler.class.getResource("/img/underking.png")));
                textArea.setText("     Thee has venture thyself in a path of no returning. No coming back.\n\n     Hence thee must make thy choice. What is that flesh thou think helds upon your rotting soul?"
                        + "\n\n     Chose wisely. \n\n· Warrior.\n\n· Scholar. \n\n· Devotee. \n\n· Stranded Soul");
               jButton1.setText("Warrior");
               jButton2.setText("Scholar");
               jButton3.setText("Devotee");
               jButton4.setText("Stray");
               jButton5.setText("");
               
            unListenButtons(jButton1, jButton2, jButton3, jButton4, jButton5);
               
            //reenlazar los action listeners
            jButton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setState(State.WARRIOR_SELECT);  // Cambiar al estado de selección de Warrior
                    // Actualiza la UI después de cambiar de estado
                    classChoser(State.WARRIOR_SELECT, textArea, jLabel1, player, jButton1, jButton2, jButton3, jButton4, jButton5);
                }
            });
            jButton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setState(State.SCHOLAR_SELECT);
                    classChoser(State.SCHOLAR_SELECT, textArea, jLabel1, player, jButton1, jButton2, jButton3, jButton4, jButton5);
                }
            });
            jButton3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setState(State.DEVOTEE_SELECT);
                    classChoser(State.DEVOTEE_SELECT, textArea, jLabel1, player, jButton1, jButton2, jButton3, jButton4, jButton5);
                }
            });
            jButton4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setState(State.STRAY_SELECT);
                    classChoser(State.STRAY_SELECT, textArea, jLabel1, player, jButton1, jButton2, jButton3, jButton4, jButton5);
                }
            });
            
        } else if (state == State.WARRIOR_SELECT) {
            jLabel1.setIcon(new javax.swing.ImageIcon(ChoiceHandler.class.getResource("/img/Warrior.png")));
            textArea.setText("     How many foes has thy filuum slashed and prayerers killed?"
                        + "\n\n     Thou art a warrior of Lost Cause, clad in lacklustre armor, as lifeless as thy hollow gaze. The only ember that stirs within thee is the bitter whisper of hopelessness, an echo of an existence best left forgotten."
                        + "\n\n\n     No hope remains for husks such as thee in this forsaken land."
                        + "\n\n\n     Thine is the art of strength and savagery, of crushing bones and slaying with impunity, towering over those beneath thee like a beast of ruin. Is this thy fate?"
                        + "\n\n     Is this thou?");
            jButton1.setText("");
            jButton2.setText("");
            jButton3.setText("This is my husk");
            jButton4.setText("");
            jButton5.setText("Return");
            
            unListenButtons(jButton1, jButton2, jButton3, jButton4, jButton5);
            
                //reenlazamos segun necesario
            jButton3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setState(State.CONFIRM_CLASS);
                    player.setWarrior(player);
                    classChoser(State.CONFIRM_CLASS, textArea, jLabel1, player, jButton1, jButton2, jButton3, jButton4, jButton5);
                }
            });
            
            jButton5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setState(State.CLASS_SELECTION); 
                    classChoser(State.CLASS_SELECTION, textArea, jLabel1, player, jButton1, jButton2, jButton3, jButton4, jButton5);
                }
            });
                
        } else if (state == State.SCHOLAR_SELECT) {
            jLabel1.setIcon(new javax.swing.ImageIcon(ChoiceHandler.class.getResource("/img/Scholar.png")));
            textArea.setText("     No amount of knowledge shall grant thee peace upon these cursed lands."
                        + "\n\n     For there is no bliss to be found here, and knowledge is but a ceaseless abyss. Thine fate has cast thee into solitude, a lone stylite, distant from warmth, far from all but thyself, away from gods above and below."
                        + "\n\n\n     Thy trade is of wit and secrecy, of cloistered wandering, where the path itself is of greater concern than the souls who wander it. And it shows. The unknown, masked beneath the guise of curiosity, thrives in thee."
                        + "\n\n\n     No name is known for any wizard. It seems this Time has long forgotten thy labor, and those who came before thee... Is this thy fate? "
                        + "\n\n     Is this thou?");
            jButton1.setText("");
            jButton2.setText("");
            jButton3.setText("This is my husk");
            jButton4.setText("");
            jButton5.setText("Return");
            
            unListenButtons(jButton1, jButton2, jButton3, jButton4, jButton5);
            
            //acciones realizadas
            jButton3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setState(State.CONFIRM_CLASS);
                    player.setScholar(player);
                    classChoser(State.CONFIRM_CLASS, textArea, jLabel1, player, jButton1, jButton2, jButton3, jButton4, jButton5);
                }
            });            
            jButton5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setState(State.CLASS_SELECTION); 
                    classChoser(State.CLASS_SELECTION, textArea, jLabel1, player, jButton1, jButton2, jButton3, jButton4, jButton5);
                }
            });
        
        }else if (state == State.DEVOTEE_SELECT) {
            jLabel1.setIcon(new javax.swing.ImageIcon(ChoiceHandler.class.getResource("/img/Devotee.png")));
            textArea.setText("     Thy soul, a vessel of blind devotion, wanders in search of a deity, yet thou knowest not if thy god shall heal thee or damn thee."
                        + "\n\n     The faith thou clings to is but a shadow, and its light, if ever it existed, flickers dimly before thee. No answers have come, yet thou dost believe, for belief is all thou hast. In the silence of thy prayers, the unanswered pleas echo as thy sole company."
                        + "\n\n\n     Thy trade is of prayer and penance, of sacrifice and service, in the hope that, one day, the god thou seekest shall reveal their will. But thy faith is frail, and the path is long and treacherous."
                        + "\n\n\n     The infidels thou might persecute, or thee may be the one persecuted—none can know.Is this thy fate?"
                        + "\n\n     Is this thou?");
            jButton1.setText("");
            jButton2.setText("");
            jButton3.setText("This is my husk");
            jButton4.setText("");
            jButton5.setText("Return");
            
            unListenButtons(jButton1, jButton2, jButton3, jButton4, jButton5);
            
            jButton3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setState(State.CONFIRM_CLASS);
                    player.setDevotee(player);
                    classChoser(State.CONFIRM_CLASS, textArea, jLabel1, player, jButton1, jButton2, jButton3, jButton4, jButton5);
                }
            });            
            jButton5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setState(State.CLASS_SELECTION); 
                    classChoser(State.CLASS_SELECTION, textArea, jLabel1, player, jButton1, jButton2, jButton3, jButton4, jButton5);
                }
            });
        
        }else if (state == State.STRAY_SELECT){
            jLabel1.setIcon(new javax.swing.ImageIcon(ChoiceHandler.class.getResource("/img/Stray.png")));
            textArea.setText("     A soul without a master, adrift in the winds of oblivion, bound to no place, to no cause."
                        + "\n\n    Thy heart beats with no purpose, thy mind lost to the endless wandering, a shade that drifts between worlds. Once, thou may have had a name, once perhaps thou belonged to something greater—but now, thou art but a stray, a soul wandering aimlessly in a world of rot and ruin."
                        + "\n\n\n     Thy trade is of survival and surrender, of seeking refuge in forgotten corners, of living in the cracks between life and death. The gods have forgotten thee, and mortals do not even know thee exist."
                        + "\n\n\n     A forsaken soul, not yet claimed by the abyss, but tethered to this forsaken world by the faintest thread of life. Is this thy fate?"
                        + "\n\n     Is this thou?");
            jButton1.setText("");
            jButton2.setText("");
            jButton3.setText("This is my husk");
            jButton4.setText("");
            jButton5.setText("Return");
            
            unListenButtons(jButton1, jButton2, jButton3, jButton4, jButton5);
            
            jButton3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setState(State.CONFIRM_CLASS);
                    player.setStray(player);
                    classChoser(State.CONFIRM_CLASS, textArea, jLabel1, player, jButton1, jButton2, jButton3, jButton4, jButton5);
                }
            });                    
            jButton5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setState(State.CLASS_SELECTION); 
                    classChoser(State.CLASS_SELECTION, textArea, jLabel1, player, jButton1, jButton2, jButton3, jButton4, jButton5);
                }
            });
        
        }else if (state == State.CONFIRM_CLASS){
            
            textArea.setText("     Thy choice shall bind thee to this path forevermore.\n\n\n     Dost thou accept this destiny?");
            jButton1.setText("");
            jButton2.setText("Accept");
            jButton3.setText("");
            jButton4.setText("");
            jButton5.setText("Return");

            unListenButtons(jButton1, jButton2, jButton3, jButton4, jButton5);
            
            jButton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setState(State.CONFIRM_CLASS);
                    classChoser(State.CONFIRM_CLASS, textArea, jLabel1, player, jButton1, jButton2, jButton3, jButton4, jButton5);
                    FirstChapter.firstChapter(State.CHAPTER_ONE_BEGINNING, textArea, jLabel1, player, jButton1, jButton2, jButton3, jButton4, jButton5);
                }
            });
            
            jButton5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setState(State.CLASS_SELECTION); 
                    classChoser(State.CLASS_SELECTION, textArea, jLabel1, player, jButton1, jButton2, jButton3, jButton4, jButton5);
                }
            });       
        }
    }
}
