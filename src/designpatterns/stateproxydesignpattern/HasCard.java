package designpatterns.stateproxydesignpattern;

public class HasCard implements ATMState {

    ATMMachine atmMachine;

    public HasCard(ATMMachine newATMMachine) {
        atmMachine = newATMMachine;
    }

    @Override
    public void insertCard() {
        System.out.println(" you can't enter more than one card");
    }

    @Override
    public void ejectCard() {
        System.out.println("card Ejected");
        atmMachine.setAtmState(atmMachine.getNoCardState());
    }

    @Override
    public void insertPin(int pinEntered) {
        if(pinEntered == 1234){
            System.out.println("correct pin");
            atmMachine.correctPinEntered = true;
            atmMachine.setAtmState(atmMachine.getHasPin());
        } else {
            System.out.println("Wrong PIN");
            atmMachine.correctPinEntered = false;
            System.out.println("Card Ejected");
            atmMachine.setAtmState(atmMachine.getNoCardState());
        }
    }

    @Override
    public void requestCash(int cashToWithdraw) {
        System.out.println("Enter the PIN first");
    }
}

