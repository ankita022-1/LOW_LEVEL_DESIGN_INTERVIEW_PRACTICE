package lldpractice.VendingMachine.entities;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    Map<String, Item> stock=new HashMap<>();
    Map<String, Integer> quantity= new HashMap<>();

    //add item and quantity
    public void addInInventory(String code, Item item, Integer count){
       stock.put(code, item);
        quantity.put(code, count);

    }
    //return quantity
    public Integer getQuantity(String code){
        return quantity.get(code);
    }
    //return item
    public Item getItem(String code){
        return stock.get(code);
    }

}
