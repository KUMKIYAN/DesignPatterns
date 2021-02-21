package designpatterns.stateproxydesignpattern;

public class HasPIN implements ATMState {

    ATMMachine atmMachine;

    public HasPIN(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("You can't enter second card");
    }

    @Override
    public void ejectCard() {
        System.out.println("care Ejected");
        atmMachine.setAtmState(atmMachine.getNoCardState());
    }

    @Override
    public void insertPin(int pinEntered) {
        System.out.println("Already Entered PIN");
    }

    @Override
    public void requestCash(int cashToWithdraw) {
        if(cashToWithdraw > atmMachine.cashInMachine){
            System.out.println("Dont have that case");
            System.out.println("card Ejected");
            atmMachine.setAtmState(atmMachine.getNoCardState());
        } else {
            System.out.println(cashToWithdraw + "is provided by machine");
            atmMachine.setCashInMachine(atmMachine.cashInMachine - cashToWithdraw);
            System.out.println("card Ejected");
            atmMachine.setAtmState(atmMachine.getNoCardState());

            if(atmMachine.cashInMachine <= 0)
                atmMachine.setAtmState(atmMachine.getNoCardState());
        }

    }
}
