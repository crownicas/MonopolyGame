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
public class SpecialSquare extends Square {
    private static final int BANK_TAX = 10;

    public SpecialSquare() {
        super();
    }
    
    public SpecialSquare(String name, int position) {
        super(name, Color.YELLOW, position);
    }
    
    @Override
    public String executeAction(Player player){
        player.setMegaMoney(player.getMegaMoney() - BANK_TAX);
        return "Se ha pagado un impuesto a la banca de 10 MM";
    }
}

