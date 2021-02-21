package designpatterns.stateproxydesignpattern;

public class TestStateDesignPattern {
    public static void main(String[] args) {
        ATMMachine atmMachine = new ATMMachine();
        atmMachine.insertCard();
        atmMachine.ejectCard();
        atmMachine.insertCard();
        atmMachine.insertPin(1234);
        atmMachine.requestCash(200);
        atmMachine.insertCard();
        atmMachine.insertPin(7890);

        ProxyDP realATMMachine = new ATMMachine();
        ProxyDP atmProxy = new ATMProxy();

        System.out.println("\n Current ATM State " + atmProxy.getATMData());
        System.out.println("\n Cash in ATM Machine $" + atmProxy.getCashInMachine());

    }
}
