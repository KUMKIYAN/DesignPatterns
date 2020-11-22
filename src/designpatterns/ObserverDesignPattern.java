package designpatterns;

import java.util.ArrayList;
import java.util.List;

public class ObserverDesignPattern {
}


interface Subject{    // publisher
   public void register(Observer o);
    public void unRegister(Observer o);
    public void notifyObserver();
}

interface Observer{   //subscriber
    public void update(double ibmPrice, double applPrice, double googPrice);
}


class StockGrabber implements Subject{

    private ArrayList<Observer> observers;
    private double ibmPrice;
    private double applPrice;
    private double googPrice;

    public StockGrabber() {
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unRegister(Observer observer) {
        observers.remove(observers.indexOf(observer) + 1);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(a -> a.update(ibmPrice, applPrice, googPrice));
    }

    public void setIbmPrice(double ibmPrice) {
        this.ibmPrice = ibmPrice;
        notifyObserver();
    }

    public void setApplPrice(double applPrice) {
        this.applPrice = applPrice;
        notifyObserver();
    }

    public void setGoogPrice(double googPrice) {
        this.googPrice = googPrice;
        notifyObserver();
    }
}


class StockObserver implements Observer{

    private double ibmPrice;
    private double applPrice;
    private double googPrice;

    private static int observerIDTracker = 0;

    private int observerID;

    private Subject stockGrabber;

    public StockObserver(Subject stockGrabber){
        this.stockGrabber = stockGrabber;
        this.observerID = ++observerIDTracker;
        System.out.println("New Observer " + this.observerID);
        stockGrabber.register(this);
    }

    @Override
    public void update(double ibmPrice, double applPrice, double googPrice) {
            this.ibmPrice = ibmPrice;
            this.applPrice = applPrice;
            this.googPrice = googPrice;
            printThePrices();
    }

    private void printThePrices() {
        System.out.println(observerID + "\nIBM :" + ibmPrice + "\nApple :" + applPrice + "\nGoogle :" + googPrice);
    }


}

class GrapStock{
    public static void main(String[] args) {
        StockGrabber stockGrabber = new StockGrabber();
        StockObserver stockObserver1 = new StockObserver(stockGrabber);
        stockGrabber.register(stockObserver1);
        stockGrabber.setIbmPrice(197.20);
        stockGrabber.setApplPrice(197.70);
        stockGrabber.setGoogPrice(198.70);

        StockObserver stockObserver2 = new StockObserver(stockGrabber);

        stockGrabber.setIbmPrice(199.20);
        stockGrabber.setApplPrice(197.70);
        stockGrabber.setGoogPrice(200.70);

        stockGrabber.unRegister(stockObserver1);
        System.out.println("************");
        stockGrabber.setGoogPrice(201.70);
        stockGrabber.setGoogPrice(301.70);
    }

}