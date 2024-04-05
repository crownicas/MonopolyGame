package activiti6.monopoly;
/**
 *
 * @author Fredy
 */
import java.awt.Color;

public class EmptySquare extends Square implements ActionHandler{
    public EmptySquare() {
        super();
    }

    public EmptySquare(String name, int position) {
        super(name, Color.WHITE, position);
    }

    @Override
    public String executeAction(Player player) {
        return "Suerte en la proxima tirada.";
    }
}