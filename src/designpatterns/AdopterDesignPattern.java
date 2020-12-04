package designpatterns;

import java.util.Random;

public class AdopterDesignPattern {
}

interface EnemyAttacker{
    void fireWeapon();
    void driveForward();
    void assignDriver(String name);
}

class EnemyTank implements EnemyAttacker{
    Random generator = new Random();

    @Override
    public void fireWeapon() {
        int attackDamage = generator.nextInt(10) + 1;
        System.out.println("Enemy tank does " + attackDamage + " Damage");
    }

    @Override
    public void driveForward() {
        int movement = generator.nextInt(5) + 1;
        System.out.println("Enemy tank moves " + movement + " spaces");
    }

    @Override
    public void assignDriver(String driverName) {
        System.out.println(driverName + " is driving the tank");
    }
}

class EnemyRobot{
    Random generator = new Random();

    public void smashWithHands(){
        int attackDamage = generator.nextInt(10) + 1;
        System.out.println("Enemy Robot Causes " + attackDamage + " Damage with its Hands");
    }

    public void walkForward(){
        int attackDamage = generator.nextInt(5) + 1;
        System.out.println("Enemy Robot Walks Forward " + attackDamage + " Spaces");
    }

    public void reactToHuman(String driverName){
        System.out.println("Enemy Robot Tramps on " + driverName);
    }
}

class EnemyRobotAdopter implements EnemyAttacker{

    EnemyRobot theRobot;

    public EnemyRobotAdopter(EnemyRobot theRobot) {
        this.theRobot = theRobot;
    }

    @Override
    public void fireWeapon() {
        theRobot.smashWithHands();
    }

    @Override
    public void driveForward() {
        theRobot.walkForward();
    }

    @Override
    public void assignDriver(String name) {
        theRobot.reactToHuman(name);
    }
}


class TestEnemyAttackers{
    public static void main(String[] args) {
        EnemyTank rx7Tank  = new EnemyTank();
        EnemyRobot fredTheRobot = new EnemyRobot();
        EnemyAttacker robotAdopter = new EnemyRobotAdopter(fredTheRobot);

        System.out.println("The Robot");
        fredTheRobot.reactToHuman("kiyan");
        fredTheRobot.smashWithHands();
        fredTheRobot.walkForward();

        System.out.println("The Tank");
        rx7Tank.assignDriver("Sudha");
        rx7Tank.fireWeapon();
        rx7Tank.driveForward();

        System.out.println("The Robot with Adopter");
        robotAdopter.assignDriver("Ravi");
        robotAdopter.fireWeapon();
        robotAdopter.driveForward();
    }
}



