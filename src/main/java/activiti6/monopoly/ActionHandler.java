package activiti6.monopoly;
/**
 *
 * @author Fredy
 */

/* 
Interface for defining an action handler.
It contains a method 'executeAction' that takes a Player object as a parameter 
and returns a String 
*/
public interface ActionHandler {
    public String executeAction(Player player);
}