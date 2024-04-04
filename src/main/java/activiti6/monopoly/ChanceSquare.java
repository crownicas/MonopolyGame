/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package activiti6.monopoly;

/**
 *
 * @author Fredy
 */
import java.awt.Color;
import java.util.Random;
import java.io.Serializable;

public class ChanceSquare extends Square implements Serializable {
    private static final int BEAUTY_CONTEST = 20;
    private static final int BIRTHDAY = 10;
    private static final int TRAFFIC_TICKET = 10;

    public ChanceSquare() {
        super();
    }

    public ChanceSquare(String name, int position) {
        super(name, Color.decode("#800080"), position);
    }

    @Override
    public String executeAction(Player player) {
        return specialCard(player);
    }

    public String specialCard(Player player) {
        int randomValue = new Random().nextInt(3) + 1;
        String message = "";
        switch (randomValue) {
            case 1:
                player.setMegaMoney(player.getMegaMoney() + BEAUTY_CONTEST);
                message = "Has ganado un premio en el concurso de belleza. Recibe 20 Mm.";
                break;
            case 2:                
                player.setMegaMoney(player.getMegaMoney() + BIRTHDAY);
                message = "Hoy es tu cumpleaños. Recibe 10 Mm de tu contrincante.";
                break;
            case 3:
                player.setMegaMoney(player.getMegaMoney() - TRAFFIC_TICKET);
                message = "Recibes una multa de tráfico. Paga 10 Mm.";
                break;
        }
        
        return message;
    }
}
