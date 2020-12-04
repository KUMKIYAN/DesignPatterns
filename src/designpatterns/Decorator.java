package designpatterns;

public class Decorator {
}

interface Pizza{
    String getDescription();
    double getCost();
}

class PlainPizza implements Pizza{

    public PlainPizza() {
        System.out.println("Adding Dough");
    }

    @Override
    public String getDescription() {
        return "Thin Dough";
    }

    @Override
    public double getCost() {
        return 4.00;
    }
}

abstract class ToppingDecorator implements Pizza{
    protected Pizza tempPiza;

    public ToppingDecorator(Pizza newPizza) {
        this.tempPiza = newPizza;
    }

    public String getDescription() {
        return tempPiza.getDescription();
    }

    public double getCost() {
        return tempPiza.getCost();
    }
}

class Mozzarella extends ToppingDecorator{

    public Mozzarella(Pizza newPizza) {
        super(newPizza);
        System.out.println("Adding Moz");
    }

    public String getDescription() {
        return tempPiza.getDescription() + ",Mozzarella";
    }

    public double getCost() {
        return tempPiza.getCost() + .50;
    }
}

class TomatoSauce extends ToppingDecorator{

    public TomatoSauce(Pizza newPizza) {
        super(newPizza);
        System.out.println("Adding Sauce");
    }

    public String getDescription() {
        return tempPiza.getDescription() + ",Tomato Sauce";
    }

    public double getCost() {
        return tempPiza.getCost() + .35;
    }
}

class PizzaShop{
    public static void main(String[] args) {
        Pizza basicPizza = new PlainPizza();
        System.out.println("Ingredients :" + basicPizza.getDescription());
        System.out.println("Price " + basicPizza.getCost());

        Pizza mozzarellaPizza = new Mozzarella(new PlainPizza());
        System.out.println("Ingredients :" + mozzarellaPizza.getDescription());
        System.out.println("Price " + mozzarellaPizza.getCost());

        Pizza tomatoSaucePizza = new TomatoSauce(new PlainPizza());
        System.out.println("Ingredients :" + tomatoSaucePizza.getDescription());
        System.out.println("Price " + tomatoSaucePizza.getCost());

        Pizza tomatoSauceMozzarellaPizza = new TomatoSauce(new Mozzarella(new PlainPizza()));
        System.out.println("Ingredients :" + tomatoSauceMozzarellaPizza.getDescription());
        System.out.println("Price " + tomatoSauceMozzarellaPizza.getCost());
    }


}