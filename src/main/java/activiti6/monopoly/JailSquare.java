package activiti6.monopoly;
/**
 *
 * @author Fredy
 */
import java.awt.Color;

public class JailSquare extends Square {
    public JailSquare() {
        super();
    }

    public JailSquare(String name, int position) {
        super(name, Color.BLUE, position);
    }

    @Override
    public String executeAction(Player player) {
        
        if (!player.isBlocked()) {
            player.setBlocked(true);
            player.setCurrentPosition(12);
            return "Has caído en la cárcel, espera al próximo turno para intentar quedar libre";
        }
        
        return "Para salir de la carcel debes sacar un 5";
    }
}