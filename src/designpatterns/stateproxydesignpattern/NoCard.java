package designpatterns.stateproxydesignpattern;

public class NoCard implements ATMState {

    ATMMachine atmMachine;

    public NoCard(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("please enter a PIN");
        atmMachine.setAtmState(atmMachine.getYesCardState());
    }

    @Override
    public void ejectCard() {
        System.out.println("Enter Card First");
    }

    @Override
    public void insertPin(int pinEntered) {
        System.out.println("Enter Card First");
    }

    @Override
    public void requestCash(int cashToWithdraw) {
        System.out.println("Enter Card First");
    }
}
