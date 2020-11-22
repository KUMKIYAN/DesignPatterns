package designpatterns;

import java.util.Scanner;

public class FactoryDesignPatternV1 {
}


abstract class EnemyShip{
    String name;
    double amtDamage;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getDamage() {
        return amtDamage;
    }
    public void setDamage(double amtDamage) {
        this.amtDamage = amtDamage;
    }
    public void followHeroShip(){
        System.out.println( getName() + " is following the hero");
    }
    public void displayEnemyShip(){
        System.out.println( getName() + " is on the screen");
    }
    public void enemyShipShoots(){
        System.out.println( getName() + " attack and does " + getDamage());
    }
}


class UFOEnemyShip extends EnemyShip{
    public UFOEnemyShip(){
        setName("UFO Enemy Ship");
        setDamage(20.0);
    }
}

class RocketEnemyShip extends EnemyShip{
    public RocketEnemyShip(){
        setName("Rocket Enemy Ship");
        setDamage(10.0);
    }
}

class EnemyShipTesting {
    public static void main(String[] args) {
        EnemyShip ufoShip = new UFOEnemyShip();
        doStuffEnemy(ufoShip);
    }

    private static void doStuffEnemy(EnemyShip anEnemyShip) {
        anEnemyShip.displayEnemyShip();
        anEnemyShip.followHeroShip();
        anEnemyShip.enemyShipShoots();
    }
}

class EnemyShipTesting1 {
    public static void main(String[] args) {

        EnemyShip theEnemy;
        Scanner userInput = new Scanner(System.in);
        String enemyShipOption = "";
        System.out.println("What type of ship ? (U/R)");
        if(userInput.hasNext()){
            enemyShipOption = userInput.nextLine();
        }
        if(enemyShipOption.equals("U")){
            theEnemy = new UFOEnemyShip();
        } else
            if (enemyShipOption.equals("R")){
            theEnemy = new RocketEnemyShip();
        }

    }

    private static void doStuffEnemy(EnemyShip anEnemyShip) {
        anEnemyShip.displayEnemyShip();
        anEnemyShip.followHeroShip();
        anEnemyShip.enemyShipShoots();
    }
}