package designpatterns;

public class AbstractFactoryPattern {
}

class TestAbstractFactoryPattern {
    public static void main(String[] args) {
        EnemyShipBuilding makeUFO = new UFOEnemyShipBuilding();
        EnemyShipe theGrunt = makeUFO.orderTheShip("ufo");
        System.out.println(theGrunt + "\n");
        EnemyShipe theBoss = makeUFO.orderTheShip("ufo boss");
        System.out.println(theBoss + "\n");
    }
}

// order mechanism
abstract class EnemyShipBuilding {
    protected abstract EnemyShipe makeEnemyShip(String typeOfShip);
    public EnemyShipe orderTheShip(String typeOfShip) {
        EnemyShipe theEnemyShip = makeEnemyShip(typeOfShip);
        theEnemyShip.makeShip();
        theEnemyShip.displayEnemyShip();
        theEnemyShip.followHeroShip();
        theEnemyShip.enemyShipShoots();
        return theEnemyShip;
    }
}

class UFOEnemyShipBuilding extends EnemyShipBuilding{
    @Override
    protected EnemyShipe makeEnemyShip(String typeOfShip) {
        EnemyShipe enemyShipe = null;
        if(typeOfShip.equals("ufo")){
            EnemyShipFactory shipPartsFactory = new UFOEnemyShipFactory();
            enemyShipe = new UFOEnemyShipe(shipPartsFactory);
            enemyShipe.setName("UFO Grunt Ship");
        } else {
            if(typeOfShip.equals("ufo boss")){
                EnemyShipFactory shipPartsFactory = new UFOBossEnemyShipFactory();
                enemyShipe = new UFOBossEnemyShipe(shipPartsFactory);
                enemyShipe.setName("UFO BOSS Ship");
            }
        }
        return enemyShipe;
    }
}

abstract class EnemyShipe{
    private String name;
    ESWeapon weapon;
    ESEngine engine;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract void makeShip();

    public void displayEnemyShip(){
        System.out.println( "on the screen");
    }

    public void followHeroShip(){
        System.out.println("following hero");
    }

    public void enemyShipShoots(){
        System.out.println("shooting the hero");
    }

    @Override
    public String toString() {
        return "EnemyShip{" +
                "name='" + name + '\'' +
                ", weapon=" + weapon +
                ", engine=" + engine +
                '}';
    }
}

interface EnemyShipFactory{
    public ESWeapon addGun();
    public ESEngine addESEngine();
}

class UFOEnemyShipFactory implements EnemyShipFactory{
    @Override
    public ESWeapon addGun() {
        return new ESUFOGun();
    }

    @Override
    public ESEngine addESEngine() {
        return new ESUFOEngine();
    }
}

class UFOBossEnemyShipFactory implements EnemyShipFactory{
    @Override
    public ESWeapon addGun() {
        return new ESUFOBossGun();
    }

    @Override
    public ESEngine addESEngine() {
        return new ESUFOBossEngine();
    }
}

class UFOEnemyShipe extends EnemyShipe{
    EnemyShipFactory shipFactory;

    public UFOEnemyShipe(EnemyShipFactory shipFactory) {
        this.shipFactory = shipFactory;
    }

    @Override
    void makeShip() {
        System.out.println("making the ship " + getName());
        weapon = shipFactory.addGun();
        engine = shipFactory.addESEngine();
    }
}

class UFOBossEnemyShipe extends EnemyShipe{
    EnemyShipFactory shipFactory;

    public UFOBossEnemyShipe(EnemyShipFactory shipFactory) {
        this.shipFactory = shipFactory;
    }

    @Override
    void makeShip() {
        System.out.println("making the ship " + getName());
        weapon = shipFactory.addGun();
        engine = shipFactory.addESEngine();
    }
}

interface ESWeapon{
     String toString();
}

interface ESEngine{
     String toString();
}

class ESUFOGun implements ESWeapon{
    public String toString(){
        return  "Damage";
    }
}

class ESUFOEngine implements ESEngine{
    public String toString(){
        return "100 mph";
    }
}

class ESUFOBossGun implements ESWeapon{
    public String toString(){
        return  "Boss Damage";
    }
}

class ESUFOBossEngine implements ESEngine{
    public String toString(){
        return "Boss 200 mph";
    }
}
