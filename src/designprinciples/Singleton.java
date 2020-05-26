package designprinciples;

import java.io.*;
import java.util.HashMap;

public class Singleton {
}

class BasicSingleton implements Serializable{


    private BasicSingleton() {
    }

    private static final  BasicSingleton INSTANCE = new BasicSingleton();

    public static BasicSingleton getInstance(){
        return INSTANCE;
    }

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    protected Object readResolve(){
        return INSTANCE;
    }

}

class Demo45{

    static void saveToFile(BasicSingleton basicSingleton, String fileName) throws Exception{
        try(FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
                oos.writeObject(basicSingleton);
        }
    }

    static BasicSingleton readFromFile(String fileName) throws Exception{
        try(FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis)){
           return (BasicSingleton) ois.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        BasicSingleton bs = BasicSingleton.getInstance();
        bs.setValue(100);
        System.out.println(bs.getValue());
        bs.setValue(200);
        System.out.println(bs.getValue());

        bs.setValue(10);
        String fileName = "kiyan.txt";
        saveToFile(bs, fileName);
        System.out.println(readFromFile(fileName).getValue());

        BasicSingleton bs2 = readFromFile(fileName);  //creating a new objec for singleton class
        System.out.println(bs == bs2);
        bs2.setValue(20);
        System.out.println(bs.getValue());
        System.out.println(bs2.getValue());
    }
}

class StaticBlockSingleton{

    private static StaticBlockSingleton instance ;

    static {
        try{
            instance = new StaticBlockSingleton();
        }catch (Exception e){
            System.err.println("Failed to create Singleton");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(StaticBlockSingleton.getInstance());
    }
}


class LazySingleton{
    private static LazySingleton instance;

    private LazySingleton(){
        System.out.println("initializing a lazy singleton");
    }

    // Lazy singleton approach
    public static LazySingleton getInstance(){
        if(instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    // Lazy singleton approach with synchronized
    public static synchronized LazySingleton getInstance1(){
        if(instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    // double-checked locking
    public static LazySingleton getInstance2(){
        if(instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null)
                    instance = new LazySingleton();
            }
        }
        return instance;
    }

}

class InnerStaticSingleton{
    InnerStaticSingleton(){

    }
    private static class Inner{
        private static final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();
    }

    public InnerStaticSingleton getInstance(){
        return Inner.INSTANCE;
    }
}

enum EnumBasedSingleton{
    INSTANCE;
    private int value;
    EnumBasedSingleton(){
        value = 40;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class Demo46{

    static void saveToFile(EnumBasedSingleton enumBasedSingleton, String fileName) throws Exception{
        try(FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(enumBasedSingleton);
        }
    }

    static EnumBasedSingleton readFromFile(String fileName) throws Exception{
        try(FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            return (EnumBasedSingleton) ois.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        EnumBasedSingleton singleton = EnumBasedSingleton.INSTANCE;
       // singleton.setValue(111);
        String fileName = "kiyan.txt";
        saveToFile(singleton, fileName);
        EnumBasedSingleton singleton1 = readFromFile(fileName);
        System.out.println(singleton1.getValue());
    }

}

class CEO{
    static String name;
    static int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        CEO.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        CEO.age = age;
    }

    public static void main(String[] args) {
        CEO ceo = new CEO();
        ceo.setName("kiyan");
        ceo.setAge(45);

        CEO ceo2 = new CEO();
        System.out.println(ceo2.getAge());
        System.out.println(ceo2.getName());
    }
}

enum SubSystem{
    COLORPRINTER,
    BASICPRINTER,
    PRINTERXERROX;
}

class Printer1{
    static int instanceCount;
    private Printer1() {
        ++instanceCount;
        System.out.println("A printer of " + instanceCount + " instances created so far. ");
    }
    private static HashMap<SubSystem, Printer1> instances = new HashMap<>();

    public static Printer1 get(SubSystem ss){
        if (instances.containsKey(ss))
            return instances.get(ss);

        Printer1 instance = new Printer1();
        instances.put(ss, instance);
        return instance;
    }
}

class Multiton{ // There will be cap on number of objects created in multiton approach. here we can create maximum of 3 three objects only.
    public static void main(String[] args) {
        Printer1 color = Printer1.get(SubSystem.COLORPRINTER);
        Printer1 color1 = Printer1.get(SubSystem.COLORPRINTER);
        Printer1 color2 = Printer1.get(SubSystem.COLORPRINTER);
        Printer1 basic = Printer1.get(SubSystem.BASICPRINTER);
        Printer1 basic1 = Printer1.get(SubSystem.BASICPRINTER);
        Printer1 basic2 = Printer1.get(SubSystem.BASICPRINTER);
        Printer1 withXerox = Printer1.get(SubSystem.PRINTERXERROX);
        Printer1 withXerox1 = Printer1.get(SubSystem.PRINTERXERROX);
        Printer1 withXerox2 = Printer1.get(SubSystem.PRINTERXERROX);

    }
}
