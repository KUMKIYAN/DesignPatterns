package designpatterns.stateproxydesignpattern;

public class ATMMachine implements ProxyDP{
    ATMState hasCard;
    ATMState noCard;
    ATMState hasCorrectPIN;
    ATMState atmOutOfMoney;

    ATMState atmState;

    int cashInMachine = 2000;
    boolean correctPinEntered = false;

    public ATMMachine() {
        hasCard = new HasCard(this);
        noCard = new NoCard(this);
        hasCorrectPIN = new HasPIN(this);
        atmOutOfMoney = new NoCash(this);

        atmState = noCard;

        if(cashInMachine < 0){
            atmState = atmOutOfMoney;
        }
    }

    void setAtmState(ATMState newATMState){
        atmState = newATMState;
    }

    void setCashInMachine(int newCashInMachine){
        cashInMachine = newCashInMachine;
    }

    public void insertCard(){
        atmState.insertCard();
    }

    public void ejectCard(){
        atmState.ejectCard();
    }


    public void insertPin(int pinEntered){
        atmState.insertPin(pinEntered);
    }

    public void requestCash(int cashToWithdraw){
        atmState.requestCash(cashToWithdraw);
    }


    public ATMState getYesCardState(){
        return hasCard;
    }

    public ATMState getNoCardState(){
        return noCard;
    }

    public ATMState getHasPin(){
        return hasCard;
    }

    @Override
    public ATMState getATMData() {
        return atmState;
    }

    @Override
    public int getCashInMachine() {
        return cashInMachine;
    }
}
