package designpatterns;

public class ChainOfResponsibility {
}

interface Chain{
    public void setNextChain(Chain nextChain);
    public void calculate(Numbers request);
}

class Numbers{
    private int number1;
    private int number2;
    private String calculationWanted;

    public Numbers(int number1, int number2, String calculationWanted) {
        this.number1 = number1;
        this.number2 = number2;
        this.calculationWanted = calculationWanted;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public String getCalculationWanted() {
        return calculationWanted;
    }
}

class AddNumbers implements Chain{
    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public void calculate(Numbers request) {
        if(request.getCalculationWanted() == "add"){
            System.out.println(request.getNumber1() + " + " + request.getNumber2() + " = " + (request.getNumber1() + request.getNumber2()));
        } else{
            nextInChain.calculate(request);
        }
    }
}

class SubtractionNumbers implements Chain{
    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public void calculate(Numbers request) {
        if(request.getCalculationWanted() == "sub"){
            System.out.println(request.getNumber1() + " - " + request.getNumber2() + " = " + (request.getNumber1()-request.getNumber2()));
        } else{
            nextInChain.calculate(request);
        }
    }
}

class MultiplyNumbers implements Chain{
    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public void calculate(Numbers request) {
        if(request.getCalculationWanted() == "mul"){
            System.out.println(request.getNumber1() + "*" + request.getNumber2() + " = " + (request.getNumber1() * request.getNumber2()));
        } else{
            nextInChain.calculate(request);
        }
    }
}

class DivideNumbers implements Chain{
    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public void calculate(Numbers request) {
        if(request.getCalculationWanted() == "div"){
            System.out.println(request.getNumber1() + " / " + request.getNumber2() + " = " + (request.getNumber1() / request.getNumber2()));
        } else{
            System.out.println("Choose right option like => add, sub, mul or div");
        }
    }
}

class TestChain{
    public static void main(String[] args) {
        Chain chainCalc1 = new AddNumbers();
        Chain chainCalc2 = new SubtractionNumbers();
        Chain chainCalc3 = new MultiplyNumbers();
        Chain chainCalc4 = new DivideNumbers();

        chainCalc1.setNextChain(chainCalc2);
        chainCalc2.setNextChain(chainCalc3);
        chainCalc3.setNextChain(chainCalc4);

        chainCalc1.calculate(new Numbers(20,10,"div"));

    }
}