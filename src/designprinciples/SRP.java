package designprinciples;

import java.util.ArrayList;
import java.util.List;


//Single Responsible Principle
class Menu {
    private final List<String> items = new ArrayList<>();
    private static int counter;

    public void addItem(String item){
        items.add(++counter + ". " + item);
    }

    public void removeItem(int index){
        items.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), items);
    }
}

class Hotel{
    public static void main(String[] args) {
        Menu breakFast = new Menu();
        breakFast.addItem("idly");
        breakFast.addItem("dhosa");
        breakFast.addItem("egg dhosa");
        breakFast.addItem("vada");
        breakFast.addItem("bonda");
        System.out.println(breakFast);

    }
}


//The menu class here has limited(desired) responsibilities (single responsible principle).  adding any other method make it break this principle
