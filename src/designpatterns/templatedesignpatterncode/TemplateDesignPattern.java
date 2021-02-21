package designpatterns.templatedesignpatterncode;

public class TemplateDesignPattern {
}

abstract class Hoagie {

    final void makeSandwich() {
        cutBun();
        if (customerWantsMeat()) {
            addMeat();
        }

        if (customerWantsCheese()) {
            addCheese();
        }

        if (customerWantsVegitables()) {
            addVegitables();
        }

        if (customerWantsCondiments()) {
            addCondiments();
        }

        wrapTheHoagie();
    }

    public void wrapTheHoagie() {
        System.out.println("Wrap the Hoagie");
        System.out.println("********Next Token********");
    }

    public void cutBun() {
        System.out.println("The Hoagie is cut");
    }

    abstract void addMeat();

    abstract void addCheese();

    abstract void addVegitables();

    abstract void addCondiments();

    boolean customerWantsMeat() {
        return true;
    }

    boolean customerWantsCheese() {
        return true;
    }

    boolean customerWantsVegitables() {
        return true;
    }

    boolean customerWantsCondiments() {
        return true;
    }

}


class ItalianHoagie extends Hoagie {
    String[] meatUsed = {"Checken", "Salami", "Capicola Ham"};
    String[] cheeseUsed = {"Provolone"};
    String[] veggiesUsed = {"Lettuce", "Tomatoes", "Onions", "Sweet Pappers"};
    String[] condimentsUsed = {"Oil", "Vinegar"};

    @Override
    void addMeat() {
        System.out.print("Adding the Meat : ");
        for (String meat :
                meatUsed) {
            System.out.print(meat + ",");
        }
        System.out.println();
    }

    @Override
    void addCheese() {
        System.out.print("Adding the Cheese : ");
        for (String cheese :
                cheeseUsed) {
            System.out.print(cheese + ",");
        }
        System.out.println();
    }

    @Override
    void addVegitables() {
        System.out.print("Adding the Vegitables : ");
        for (String vegitable :
                veggiesUsed) {
            System.out.print(vegitable + ",");
        }
        System.out.println();
    }

    @Override
    void addCondiments() {
        System.out.print("Adding the Condiments : ");
        for (String condiment :
                condimentsUsed) {
            System.out.print(condiment + ",");
        }
        System.out.println();
    }
}


class VegHoagie extends Hoagie {

    String[] veggiesUsed = {"Lettuce", "Tomatoes", "Onions", "Sweet Pappers"};
    String[] condimentsUsed = {"Oil", "Vinegar"};


    @Override
    void addMeat() {

    }

    @Override
    void addCheese() {

    }

    @Override
    void addVegitables() {
        System.out.print("Adding the Vegitables : ");
        for (String vegitable :
                veggiesUsed) {
            System.out.print(vegitable + ",");
        }
        System.out.println();
    }

    @Override
    void addCondiments() {
        System.out.print("Adding the Condiments : ");
        for (String condiment :
                condimentsUsed) {
            System.out.print(condiment + ",");
        }
        System.out.println();
    }
}

class TemplateDesignPatternTest {
    public static void main(String[] args) {
        Hoagie cust12Hoagie = new ItalianHoagie();
        cust12Hoagie.makeSandwich();
        Hoagie cust13Hoagie = new VegHoagie();
        cust13Hoagie.makeSandwich();
    }
}