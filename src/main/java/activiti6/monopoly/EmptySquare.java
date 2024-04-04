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
public class EmptySquare extends Square implements ActionHandler, Serializable{
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

