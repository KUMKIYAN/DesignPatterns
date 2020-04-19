package DesignPrinciples;

import javax.print.Doc;

public class ISP {
}

class Document{

}

interface Machine{
    void printer(Document d);
    void fax(Document d) throws Exception;
    void xerox(Document d);
}

class MultiFunctionalPrinter implements Machine{

    @Override
    public void printer(Document d) {
        System.out.println(d);
    }

    @Override
    public void fax(Document d) {
        System.out.println(d);
    }

    @Override
    public void xerox(Document d) {
        System.out.println(d);
    }
}


class OldFunctionPrinter implements Machine{

    // here we need only printer but due to Machine interface we need go for adopter class / throw Exception
    // throw Exception approach we need to have throws in method definition of class and interface

    @Override
    public void printer(Document d) {

    }

    @Override
    public void fax(Document d) throws Exception {
            throw new Exception();
    }

    @Override
    public void xerox(Document d) {

    }
}

// the pattern as per interface segregation approach is :

interface Printer{ void print(Document d);}
interface Scanner{ void scan(Document d);}

interface MultiFunctionalDevice extends Printer,Scanner{}


class JustAPrinter implements Printer{
    @Override
    public void print(Document d) {
        System.out.println(d);
    }
}

class Photocopier1 implements MultiFunctionalDevice
{
    //INTERFACE SEGREGATION PRINCIPLE

    private Printer printer;
    private Scanner scanner;

    public Photocopier1(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void print(Document d){
        printer.print(d);
    }

    @Override
    public void scan(Document d) {
        scanner.scan(d);
    }
}