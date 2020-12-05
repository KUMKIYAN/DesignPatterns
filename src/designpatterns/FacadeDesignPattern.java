package designpatterns;

public class FacadeDesignPattern {
}

class TestBankAccount{
    public static void main(String[] args) {
        BankAccountFacade accessingBankAccount = new BankAccountFacade(12345678,1234);
        accessingBankAccount.withdrawCash(50.0);
        accessingBankAccount.withdrawCash(900.00);
        accessingBankAccount.depositCash(200.00);
    }
}

class WelcomeToBank{
    public WelcomeToBank() {
        System.out.println("Welcome to ABC Bank");
        System.out.println("We are happy to give you your money if we can find it");
    }
}

class AccountNumberCheck{
    private int accountNumber = 12345678;

    public int getAccountNumber(){
        return accountNumber;
    }

    public boolean accountActive(int acctNumToCheck){
        if(acctNumToCheck == getAccountNumber()){
            return true;
        } else{
            return false;
        }
    }
}


class SecurityCodeCheck{
    private int securityCode = 1234;

    public int getSecurityCode() {
        return securityCode;
    }

    public boolean isCodeCorrect(int secCodeToCheck){
        if(secCodeToCheck == getSecurityCode()){
            return true;
        } else{
            return false;
        }
    }

}

class FundsCheck{
    private double cashInAccount = 1000.00;
    public double getCashInAccount(){
        return cashInAccount;
    }

    public void decreaseCashInAccount(double cashWithdrawn){
        cashInAccount -= cashWithdrawn;
    }

    public void increaseCashInAccount(double cashDeposit){
        cashInAccount += cashDeposit;
    }

    public boolean haveEnoughMoney(double cashToWithdrawal){
        if(cashToWithdrawal > getCashInAccount()){
            System.out.println("Error: you don't have enough money");
            System.out.println("Current Balance is"+ getCashInAccount());
            return false;
        } else {
            decreaseCashInAccount(cashToWithdrawal);
            System.out.println("Withdrawal Complete: Current Balance is "+ getCashInAccount());
        }
            return true;
    }

    public void makeDeposit(double cashDeposit){
        increaseCashInAccount(cashDeposit);
        System.out.println("Deposit Complete: Current Balance is " + getCashInAccount());
    }
}

class BankAccountFacade {
    private int accountNumber;
    private int secuirtyCode;

    AccountNumberCheck acctChecker;
    SecurityCodeCheck codeChecker;
    FundsCheck fundsChecker;
    WelcomeToBank bankWelcome;

    public BankAccountFacade(int accountNumber, int secuirtyCode) {
        this.accountNumber = accountNumber;
        this.secuirtyCode = secuirtyCode;

        acctChecker = new AccountNumberCheck();
        codeChecker = new SecurityCodeCheck();
        fundsChecker = new FundsCheck();
        bankWelcome = new WelcomeToBank();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getSecuirtyCode() {
        return secuirtyCode;
    }

    public void withdrawCash(double cashToGet){
        if(acctChecker.accountActive(getAccountNumber()) &&
                codeChecker.isCodeCorrect(getSecuirtyCode()) &&
                    fundsChecker.haveEnoughMoney(cashToGet)){
            System.out.println("Transaction Complete\n");
        } else {
            System.out.println("Transaction Failed\n");
        }
    }

    public void depositCash(double cashToDeposit){
        if(acctChecker.accountActive(getAccountNumber()) &&
                codeChecker.isCodeCorrect(getSecuirtyCode())){
            fundsChecker.makeDeposit(cashToDeposit);
            System.out.println("Transaction Complete");
        }
    }
}
