package lowleveldesign.snakeandladder.model;

public class Dice {
    int min;
    int max;
    public Dice(int min, int max) {
        this.min = min;
        this.max = max;
    }
    public int getMin() {
        return min;

    }
    public void setMin(int min) {
        this.min = min;
    }
    public int getMax() {
        return max;
    }
    public void setMax(int max) {
        this.max = max;
    }
    public int roll(){
        return (int)(Math.random()*(max-min+1)+min);
    }
}
