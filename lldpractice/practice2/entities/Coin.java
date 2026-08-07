package lldpractice.practice2.entities;

public enum Coin {
    PENNY(1),
    NICKEL(5),
    QUARTER(10);

    private Integer value;
    private Coin(Integer value){
        this.value=value;
    }
    public Integer getValue(){
        return value;
    }
}
