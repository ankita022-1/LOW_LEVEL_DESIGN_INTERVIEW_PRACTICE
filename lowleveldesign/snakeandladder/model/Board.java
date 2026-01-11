package lowleveldesign.snakeandladder.model;

import java.util.Map;

public class Board {
    int size;
    Map<Integer, Integer> map;
    public Board() {}
    public Board(int size, Map<Integer, Integer> map) {
        this.size = size;
        this.map = map;

    }
    //getters and setters
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public Map<Integer, Integer> getMap() {
        return map;
    }
    public void setMap(Map<Integer, Integer> map) {
        this.map = map;
    }
    public int getFinalPosition(int newPosition, Player player) {
        if (map.containsKey(newPosition)) {
            return map.get(newPosition);
        }
        return newPosition;
    }
}
