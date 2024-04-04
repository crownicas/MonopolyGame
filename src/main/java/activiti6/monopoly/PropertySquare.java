/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package activiti6.monopoly;
import java.io.Serializable;

/**
 *
 * @author Fredy
 */
import java.awt.Color;
import java.util.Scanner;
public class PropertySquare extends Square implements Serializable{
    private static final int PROPERTY_PRICE = 20;
    private static final int TAX_PRICE = 40;

    private boolean isBought;
    private boolean wantToBuy;
    private Player owner;

    public PropertySquare(){
        super();
        isBought = false;
        wantToBuy = false;
        owner = null;
    }

    public PropertySquare(String name, int position) {
        super(name, Color.RED, position);
        isBought = false;
        owner = null;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    public Player getOwner() {
        return owner;
    }

    public boolean isWantToBuy() {
        return wantToBuy;
    }

    public void setWantToBuy(boolean wantToBuy) {
        this.wantToBuy = wantToBuy;
    }
    
    public int getPrice() {
        return PropertySquare.PROPERTY_PRICE;
    }

    @Override
    public String executeAction(Player player){
        if (!isBought) {
            return "bough_action";
        } else {
            return payTax(player);
        }
    }

    public String buyProperty(Player player){
        String message = "";
        
        if (!isBought && player.getMegaMoney() >= PROPERTY_PRICE && owner == null){
            player.setMegaMoney(player.getMegaMoney() - PROPERTY_PRICE);
            isBought = true;
            owner = player;
            message = "Has comprado la propiedad por " + String.valueOf(PROPERTY_PRICE) + " Mm.";
        } else if (player.getMegaMoney() < PROPERTY_PRICE){
            message = "No tienes suficiente MM para comprar la propiedad.";
        }
        
        return message;
    }

    public String payTax(Player player){
        if(isBought && !owner.equals(player)) {
            player.setMegaMoney(player.getMegaMoney() - TAX_PRICE);
            owner.setMegaMoney(owner.getMegaMoney() + TAX_PRICE);
            
            return "Pagas impuesto de la propiedad 40 Mm.";
        }
        
        return "";
    }
}
