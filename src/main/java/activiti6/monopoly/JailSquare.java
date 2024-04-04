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
public class JailSquare extends Square implements Serializable {
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