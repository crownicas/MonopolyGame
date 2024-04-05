package activiti6.monopoly;

import javax.swing.SwingUtilities;
/**
 *
 * @author Fredy
 */
public class Monopoly {
    
    public static void main(String[] args) {
        
        // It sets up the graphical user interface (GUI) using SwingUtilities.invokeLater.
        SwingUtilities.invokeLater(() -> {
            MonopolyGui gui = new MonopolyGui();
            gui.setVisible(true); 
        });
    }
}
