package activiti6.monopoly;

import javax.swing.SwingUtilities;
/**
 *
 * @author Fredy
 */
public class Monopoly {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MonopolyGui gui = new MonopolyGui();
            gui.setVisible(true); 
        });
    }
}
