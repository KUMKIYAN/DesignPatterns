package designprinciples;


public class FactoryMethods {
}


class Point {
    private double x, y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point newCartesianPoint(double x, double y) {
        return new Point(x, y);
    }

    public static Point newPolorPoint(double rho, double theta) {
        return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
    }
}

// we do not follow the above factor methods. the program will look like as follow:

// and we need maintain document what each variable refers here.

enum CoordinateSystem {
    CARTESIAN, POLAR
}

class Point1 {

    private double x, y;

    public Point1(double x, double y, CoordinateSystem cs) {
        switch (cs) {
            case CARTESIAN:
                this.x = x;
                this.y = y;
                break;
            case POLAR:
                this.x = x * Math.cos(y);
                this.y = x * Math.sin(y);
        }

    }
}


// the best practice to create factory method is group all the factory methos inside a class


class Point3{
    double x, y;

    private Point3(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static class PointFactory{
        public static Point3 newCartesianPoint(double x, double y) {
            return new Point3(x, y);
        }

        public static Point3 newPolorPoint(double rho, double theta) {
            return new Point3(rho * Math.cos(theta), rho * Math.sin(theta));
        }
    }
}

class TestFactoy{
    public static void main(String[] args) {
        Point3 pf = Point3.PointFactory.newCartesianPoint(2,3);
        System.out.println(pf);
    }
}
// ---------------------------------------------- Abstract Factory methods--------------------------------------------------

interface HotDrink{
    void consume();
}

class Tea implements HotDrink{
    @Override
    public void consume() {
        System.out.println("The Tea is Delicious");
    }
}

class Coffee implements HotDrink{
    @Override
    public void consume() {
        System.out.println("The Coffee is Delicious");
    }
}

interface HotDrinkFactory{
    HotDrink prepare(int amount);
}

class TeaFactory implements HotDrinkFactory{
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Put the tea bag, boil water pour "
                + amount + "ml, add lemon, enjoy..!");
        return new Tea();
    }
}

class CoffeeFactory implements HotDrinkFactory{
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Put the Coffee Beans and Grain, boil water pour "
                + amount + "ml, add lemon, enjoy..!");
        return new Coffee();
    }
}


class HotDrinkMachine {

    HotDrinkFactory hotDrinkFactory;

    public HotDrinkMachine(HotDrinkFactory hotDrinkFactory) throws Exception {
        this.hotDrinkFactory = hotDrinkFactory;
    }

    public HotDrink makeDrink() throws Exception {
        return  hotDrinkFactory.prepare(10);
    }
}

class Demo2{
    public static void main(String[] args) throws Exception{
        HotDrinkMachine machine = new HotDrinkMachine(new TeaFactory());
        HotDrink drink = machine.makeDrink();
        drink.consume();
    }
}