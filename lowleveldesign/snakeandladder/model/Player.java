package lowleveldesign.snakeandladder.model;

import lombok.ToString;

@ToString
public class Player {
    String name;
    int position;
    public Player() {}
    public Player(String name, int position) {
        this.name = name;
        this.position = position;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

}
