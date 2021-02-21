package designpatterns.stateproxydesignpattern;

public class NoCash implements ATMState {

    ATMMachine atmMachine;

    public NoCash(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("We Do not have any money. Visit Bank");
    }

    @Override
    public void ejectCard() {
        System.out.println("We Do not have any money. you did not enter the card");
    }

    @Override
    public void insertPin(int pinEntered) {
        System.out.println("We Do not have any money. Visit Bank");
    }

    @Override
    public void requestCash(int cashToWithdraw) {
        System.out.println("We Do not have any money. Visit Bank");
    }
}
