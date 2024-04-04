/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package activiti6.monopoly;

import java.awt.Color;

/**
 *
 * @author Fredy
 */
public class Square implements ActionHandler {
    private String name;
    private Color color;
    private int position;

    public Square() {
        name = null;
        color = null;
        position = 0;
    }

    public Square(String name, Color color, int position) {
        this.name = name;
        this.color = color;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String executeAction(Player player){
        return "";
    }
}

