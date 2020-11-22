package designpatterns;

public class StratergyDesignPattern {
}

class Animal{
    private String name;
    private String says;
    public Flys flying;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSays() {
        return says;
    }

    public void setSays(String says) {
        this.says = says;
    }

    public String tryToFly(){
        return flying.fly();
    }

    public void setFlying(Flys flying) {
        this.flying = flying;
    }
}


class Dog extends Animal{
    Dog(){
        setSays("bow bow");
        flying = new CanFly();
    }
}

class Bird extends Animal{
    Bird(){
        setSays("ku ku");
        flying = new ItFlys();
    }
}

interface Flys{
    String fly();
}

class ItFlys implements Flys{
    @Override
    public String fly() {
        return "I fly";
    }
}

class CanFly implements Flys{
    @Override
    public String fly() {
        return "I can't fly";
    }
}

class TestStratergy{
    public static void main(String[] args) {
        Animal dicky = new Dog();
        System.out.println("dicky says -" + dicky.tryToFly());

        Animal kat = new Bird();
        System.out.println("cat says -" + kat.tryToFly());

        dicky.setFlying(new ItFlys());
        System.out.println("now dick says -" + dicky.tryToFly());
    }
}