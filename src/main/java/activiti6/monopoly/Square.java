package activiti6.monopoly;

import java.awt.Color;
import java.io.Serializable;
/**
 *
 * @author Fredy
 */
public class Square implements ActionHandler, Serializable {
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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name: ").append(this.name).append("\n");
        sb.append("color: ").append(this.color.toString()).append("\n");
        sb.append("position: ").append(this.position).append("\n");
        return sb.toString();
    }
}

