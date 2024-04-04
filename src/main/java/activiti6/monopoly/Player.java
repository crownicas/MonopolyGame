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

    public void addAmount(int amount){
        setMegaMoney(getMegaMoney() + amount);
        System.out.println("Se ha agregado " + amount + " a tu cuenta. Tienes en total " + getMegaMoney());
    }

    public void subtractAmount(int amount){
        setMegaMoney(getMegaMoney() - amount);
        System.out.println("Se ha restado " + amount + " de su cuenta.  Tienes en total " + getMegaMoney());
    }
    
    public Color getPieceColor() {
        return this.pieceColor;
    }
    
    @Override
    public String toString() {
    return "Jugador: " + name +
           "\nDinero: " + megaMoney +
           "\nPosición actual: " + currentPosition +
           "\nBloqueado: " + blocked +
           "\nColor de ficha: " + pieceColor.toString();
    }
}
