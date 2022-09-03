package Controller;

import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    public HashMap<Order, String> orders = new HashMap<>();
    public ArrayList<Good> goods = new ArrayList<>();

    public void addUncountableGood(String name, String type, int buyPrice, int sellPrice, int count, float amount){
        goods.add(new Good(name, type, buyPrice, sellPrice, count, amount));
    }
}
