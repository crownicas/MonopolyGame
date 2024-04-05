package activiti6.monopoly;
/**
 *
 * @author Fredy
 */
import java.awt.Color;
import java.io.Serializable;

public class Player implements Serializable{
    private static final int INIT_MEGA_MONEY = 100;
    private String name;
    private int megaMoney, currentPosition;
    private boolean blocked;
    private Color pieceColor;

    public Player(){
        megaMoney = INIT_MEGA_MONEY;
        name = null;
        currentPosition = 0;
        blocked = false;
    }

    public Player(String name, Color color){
        this.name = name;
        this.pieceColor = color;
        this.megaMoney = INIT_MEGA_MONEY;
        this.currentPosition = 0;
        this.blocked = false;
    }

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public int getMegaMoney() {return megaMoney;}

    public void setMegaMoney(int megaMoney){this.megaMoney = megaMoney;}

    public int getCurrentPosition(){return currentPosition;}

    public void setCurrentPosition(int currentPosition){this.currentPosition = currentPosition;}

    public boolean isBlocked(){return blocked;}

    public void setBlocked(boolean blocked){this.blocked = blocked;}

    // This method adds the specified amount of money to the player's account
    public void addAmount(int amount){
        setMegaMoney(getMegaMoney() + amount);
        System.out.println("Se ha agregado " + amount + " a tu cuenta. Tienes en total " + getMegaMoney());
    }
    // This method subtracts the specified amount of money from the player's account.
    public void subtractAmount(int amount){
        setMegaMoney(getMegaMoney() - amount);
        System.out.println("Se ha restado " + amount + " de su cuenta.  Tienes en total " + getMegaMoney());
    }
    
    public Color getPieceColor() {
        return this.pieceColor;
    }
    // This method returns the name of the piece color.
    public String getPieceColorName() {
        if (pieceColor.equals(Color.RED)) {
            return "red";
        } else if (pieceColor.equals(Color.GREEN)) {
            return "green";
        }
        else {
            return "unknown";
        }
    }
    
    @Override
    public String toString() {
    return "name: " + name +
           "megaMoney: " + megaMoney +
           "currentPosition: " + currentPosition +
           "blocked: " + blocked +
           "pieceColor: " + pieceColor.toString();
    }
}
