/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package activiti6.monopoly;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author Fredy
 */
public class StartSquare extends Square implements Serializable {
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
