package activiti6.monopoly;
/**
 *
 * @author Fredy
 */
import java.awt.Color;

public class PropertySquare extends Square {
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
    public String executeAction(Player player) {
        if (!isBought) {
            return "bough_action";
        } else {
            return payTax(player);
        }
    }
    
    
    // The player tries to purchase a property
    public String buyProperty(Player player) {
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
    // The player pays a tax
    public String payTax(Player player) {
        if(isBought && !owner.equals(player)) {
            player.setMegaMoney(player.getMegaMoney() - TAX_PRICE);
            owner.setMegaMoney(owner.getMegaMoney() + TAX_PRICE);
            
            return "Pagas impuesto de la propiedad 40 Mm.";
        }
        
        return "";
    }
    
     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name: ").append(this.getName()).append("\n");
        sb.append("color: ").append(this.getColor().toString()).append("\n");
        sb.append("position: ").append(this.getPosition()).append("\n");
        sb.append("isBought: ").append(this.isBought).append("\n");
        sb.append("wantToBuy: ").append(this.wantToBuy).append("\n");
        sb.append("owner: ").append(this.owner).append("\n");
        return sb.toString();
    }  
}
