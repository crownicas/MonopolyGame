package activiti6.monopoly;
/**
 *
 * @author Fredy
 */
import java.awt.Color;

public class StartSquare extends Square {
    public static final int PASS_BY_START_SQUARE = 20;

    public StartSquare(){
        super();
    }

    public StartSquare(String name, int position) {
        super(name, Color.BLACK, position);
    }

    @Override
    public String executeAction(Player player) {
        return "";
    }
}
