package Java8;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

//before lambda expression
interface Interf{
    public void m1();
}
class Demo implements Interf{
    @Override
    public void m1() {
        System.out.println("m1 implementation");
    }
}
class Test{
    public static void main(String[] args) {
        Interf interf = new Demo();
        interf.m1();
    }
}
//After lambda expression
class Test2{
    public static void main(String[] args) {
        Interf interf = () -> System.out.println("m1 implementation");  // this is called procedure
        interf.m1();
    }
}

//before lambda expression
interface Interf1{
    public void add(int a, int b);
}
class Demo1 implements Interf1{
    @Override
    public void add(int a, int b) {
        System.out.println("Sum: " + (a + b));
    }
}
class Test3{
    public static void main(String[] args) {
        Interf1 interf = new Demo1();
        interf.add(10 , 20);
        interf.add(100 , 200);
    }
}

//After lambda expression
class Test4{
    public static void main(String[] args) {
        Interf1 interf = (a , b) -> System.out.println("Sum: " + (a + b));  // this is called procedure
        interf.add(10,40);
        interf.add(100,400);
    }
}

//before lambda expression
interface Interf2{
    public int getLength(String s);
}
class Demo2 implements Interf2{
    @Override
    public int getLength(String s) {
        return s.length();
    }
}
class Test5{
    public static void main(String[] args) {
        Interf2 interf = new Demo2();
        System.out.println(interf.getLength("kiyan"));
        System.out.println(interf.getLength("kumkiyan"));
    }
}
//After lambda expression
class Test6{
    public static void main(String[] args) {
        Interf2 interf = s -> s.length() ;  // this is called procedure
        System.out.println(interf.getLength("kiyan"));
        System.out.println(interf.getLength("kumkiyan1"));
    }
}


//before lambda expression
interface Interf3{
    public int squareIt(int x);
}
class Demo3 implements Interf3{

    @Override
    public int squareIt(int x) {
        return x*x;
    }
}
class Test7{
    public static void main(String[] args) {
        Interf3 interf = new Demo3();
        System.out.println(interf.squareIt(10));
        System.out.println(interf.squareIt(11));
    }
}
//After lambda expression
class Test8{
    public static void main(String[] args) {
        Interf3 interf = x -> x*x ;  // this is called procedure
        System.out.println(interf.squareIt(12));
        System.out.println(interf.squareIt(13));
    }
}

// Before lambda expression: Pre-defined java interface usage example
class RunnableImplementation implements Runnable{
    @Override
    public void run() {
            for(int i = 1; i< 10; i++) {
                    for(int k =0; k< 1000; k++);
                System.out.println("child thread");
            }
    }
    public static void main(String[] args) {
        Runnable r = new RunnableImplementation();
        Thread t = new Thread(r);
        t.start();
        for(int i = 1; i< 10; i++) {
            for(int k =0; k< 1000; k++);
            System.out.println("main thread");
        }
    }
}
// After lambda expression: Pre-defined java interface usage example
class RunnableInterface1{
    public static void main(String[] args) {
        Runnable r = () -> {
            for (int i = 1; i < 10; i++) {
                for (int k = 0; k < 1000; k++) ;
                System.out.println("child thread");
            }
        };

        Thread t = new Thread(r);
        t.start();
        for(int i = 1; i< 10; i++) {
            for(int k =0; k< 1000; k++);
            System.out.println("main thread");
        }
    }
}

// before Lambda expression for sorting
class myComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1> o2)
            return -1;
        else if (o1 < o2)
            return 1;
        else
            return 0;
    }
}

class Test9{
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(5);
        arrayList.add(1);
        arrayList.add(0);
        System.out.println("Before Sorting  : " + arrayList);
        Collections.sort(arrayList);
        System.out.println("Default Sorting : " + arrayList);
        // for descending order.
        // here we depend on implementation class object of comparator
        Collections.sort(arrayList, new myComparator());
        System.out.println("After Sorting : " + arrayList);
    }
}

// After Lambda expression for sorting

class Test10{
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(5);
        arrayList.add(1);
        arrayList.add(0);
        System.out.println("Before Sorting  : " + arrayList);
        Collections.sort(arrayList);
        System.out.println("Default Sorting : " + arrayList);
        Collections.sort(arrayList, (i, j) ->
                {
                    if (i < j)
                        return 1;
                    else if (i > j)
                            return -1;
                    else
                        return 0;
                });
        System.out.println("After Sorting : " + arrayList);
        Collections.sort(arrayList, (i, j) -> (i > j) ? -1 : (i < j) ? 1 : 0) ;
        System.out.println("After Sorting : " + arrayList);
        Collections.sort(arrayList, (i, j) -> j.compareTo(i)) ;
        System.out.println("After Sorting : " + arrayList);
    }
}

// After Lambda expression tree set sorting
class Test11 {
    public static void main(String[] args) {
     //   TreeSet<Integer> treeSet = new TreeSet<Integer>();

     //   TreeSet<Integer> treeSet = new TreeSet<Integer>((i, j) -> (i > j) ? -1 : (i < j) ? 1 : 0);
     //   TreeSet<Integer> treeSet = new TreeSet<Integer>((i, j) -> j.compareTo(i));
          TreeSet<Integer> treeSet = new TreeSet<Integer>(Comparator.reverseOrder());

     //   TreeSet<Integer> treeSet = new TreeSet<Integer>((i, j) -> i.compareTo(j));
     //   TreeSet<Integer> treeSet = new TreeSet<Integer>(Integer::compareTo);

        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(0);
        System.out.println("Sorting  : " + treeSet);
    }
}


// After Lambda expression tree map sorting
class Test12 {
    public static void main(String[] args) {
        //  TreeMap<Integer,String> treeMap = new TreeMap<Integer, String>();

        // TreeMap<Integer,String> treeMap = new TreeMap<Integer, String>((i, j) -> (i > j) ? -1 : (i < j) ? 1 : 0);
        // TreeMap<Integer,String> treeMap = new TreeMap<Integer, String>((i, j) -> j.compareTo(i));
        TreeMap<Integer,String> treeMap = new TreeMap<Integer, String>(Comparator.reverseOrder());

        treeMap.put(10, "kmr");
        treeMap.put(20, "kcr");
        treeMap.put(5, "kgr");
        treeMap.put(1, "kdr");
        treeMap.put(2, "ksr");
        System.out.println("Sorting  : " + treeMap);
    }
}

class Employee{
    int eno;
    String name;

    public Employee(int eno, String name) {
        this.eno = eno;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eno=" + eno +
                ", name='" + name + '\'' +
                '}';
    }
}

class Test13{
    public static void main(String[] args) {
        ArrayList<Employee> al = new ArrayList<Employee>();
        al.add(new Employee(10, "kiyan10"));
        al.add(new Employee(11, "kiyan11"));
        al.add(new Employee(12, "kiyan12"));
        al.add(new Employee(14, "kiyan14"));
        al.add(new Employee(13, "kiyan13"));

        System.out.println(al);
        //Collections.sort(al,(e1,e2) -> (e1.eno > e2.eno) ? -1 : (e1.eno < e2.eno) ? 1 : 0);
        Collections.sort(al,(e1,e2) -> Integer.compare(e2.eno, e1.eno));
        System.out.println(al);
    }
}

// anonymous inner class before lambda expression
class ThreadDemo{
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    for (int k = 0; k < 200; k++) ;
                    System.out.println("I am new Thread. Not main Thread");
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
        for (int i = 0; i < 10; i++) {
            for (int k=0;k<200;k++) ;
            System.out.println("I am main Thread");
        }
    }
}

// anonymous inner class replaced with lambda expression
class ThreadDemo1{
    public static void main(String[] args) {
        Runnable r = () -> {
            for (int i = 0; i < 10; i++) {
                for (int k = 0; k < 200; k++) ;
                System.out.println("I am new Thread. Not main Thread");
            }
        };

        Thread t = new Thread(r);
        t.start();
        for (int i = 0; i < 10; i++) {
            for (int k=0;k<200;k++) ;
            System.out.println("I am the main Thread");
        }
    }
}

// we can replace lambda expression directly in the constructor as well
// This is one of the ultimate use of lambda expression. This is called - passing procedure as argument.
class ThreadDemo2{
    public static void main(String[] args) {

        Thread t = new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        for (int k = 0; k < 200; k++) ;
                        System.out.println("I am a Thread. Not main Thread");
                    }
                }
        );
        t.start();
        for (int i = 0; i < 10; i++) {
            for (int k=0;k<200;k++) ;
            System.out.println("I am the main Thread");
        }
    }
}


// Anonymous inner class extends concrete class.
// Where as lambda expression can't do this implementation
class Test14{
    void m1(){
        System.out.println("i am m1 method");
    }

    void m2(){
    Test14 t = new Test14() {
        void m2() {
            System.out.println("I am m2 method");
            }
        };
    t.m2();
    t.m1();
    }

    public static void main(String[] args) {
        Test14 t = new Test14();
        t.m1();
        t.m2();
    }
}

// anonymous inner class extends abstract class
// Where as lambda expression can't do this implementation
abstract class Test15 {
    abstract void m1();

}
class Test21 {
    void m2() {
        Test15 t = new Test15() {
            void m3() {
                System.out.println("i am m3 method");
            }
            @Override
            void m1() {
                System.out.println(" i am m1 implementation");
                m3();
            }

        };
        t.m1();
    }

    public static void main(String[] args) {
        Test21 test = new Test21();
        test.m2();
    }
}

interface Interf4{
    void m1();
    void m2();
    void m3();

}

// anonymous inner class that implements interface that has more than 1 abstract methods
// Where as lambda expression can't do this implementation
class Test16{

    void m4()
    {
        Interf4 i = new Interf4() {
        @Override
        public void m1() {
            System.out.println("m1 method");
        }

        @Override
        public void m2() {
            System.out.println("m2 method");
        }

        @Override
        public void m3() {
            System.out.println("m3 method");
        }
    };
        i.m3();
        i.m2();
        i.m1();
    }
    public static void main(String[] args) {
            Test16 t = new Test16();
            t.m4();
    }
}


interface Interf5{
    void m1();
}
// anonymous inner class that implements interface that has one abstract method
// Where as lambda expression can do this. Refer next example
class Test17{
    void m2(){
    Interf5 i = new Interf5() {
        @Override
        public void m1() {
            System.out.println("i am m1 method");
        }
     };
        i.m1();
    }

}

// anonymous inner class that implements interface that has one abstract method
// Where as Anonymous inner class can't do this implementation
class Test18{
    Interf5 i = () -> {};
}

interface Interf6{
    void m1();
}

class Test19{
    int x = 100;
    public void m2() {
        Interf6 i = new Interf6() {
            int x = 200;
            @Override
            public void m1() {
                System.out.println(this.x);  //  Here this refers to inner class peroperty
                System.out.println(Test19.this.x);
            }
        };
        i.m1();
    }
    public static void main(String[] args) {
        Test19 t = new Test19();
        t.m2();
    }
}

class Test20{
    int x = 100;
    public void m2() {
        Interf6 i = () -> {
                int x = 200;
                System.out.println(this.x);  // here lambda expression this refers to outer class peroperty
            };
        i.m1();
    }
    public static void main(String[] args) {
        Test20 t = new Test20();
        t.m2();
    }
}

interface interf7{
    void m1();
}

class Test22{
    int x =10;
    void test(){
        int y = 20;
        interf7 i = () -> {
            System.out.println(x);  // inside a lambda expression we can call class variables
            System.out.println(y);  // inside a lambda expression we can call method variables
        };
        i.m1();
    }
    public static void main(String[] args) {
        Test22 t = new Test22();
        t.test(); //  lambda expression is executing here.
    }
}

class Test23{
    int x =10;
    void test(){
        int y = 20;
        int z = 30;
        interf7 i = () -> {
            System.out.println(x);  // inside a lambda expression we can call class variables
            System.out.println(y);  // inside a lambda expression we can call method variables
            // System.out.println(y++);
            // when w try to change the method variables in lambda expression compiler will give error
            // becase inside lambda expression they are treated as final. once you used in the lamda expression
            // we can't modify it outside of this lamda express.
        };
        i.m1();
        System.out.println(y);
        System.out.println(++z);
        //since we not uses z inside lamda expression. we can modify it outside
    }
    public static void main(String[] args) {
        Test23 t = new Test23();
        t.test(); //  lambda expression is executing here.
    }
}



// Predicate Example
class Test24{
    public static void main(String[] args) {
        Predicate<Integer> isGreaterThan10 = (t) -> t > 10;
        System.out.println(isGreaterThan10.test(20));
        System.out.println(isGreaterThan10.test(9));
    }
}

class Test25{
    public static void main(String[] args) {
        Predicate<Collection> isEmpty = (t) -> t.isEmpty();
        ArrayList l1 = new ArrayList();
        l1.add("10");
        System.out.println(isEmpty.test(l1));
        System.out.println(isEmpty.test(new ArrayList()));
    }
}

//predicate joining methods
class Test26{
    public static void main(String[] args) {

        int x[] = {0,5,10,15,20};
        Predicate<Integer> isGreaterThan10 = i -> i>10;
        Predicate<Integer> isEvenNumber = i -> i%2==0;
        System.out.print("Greter than 10 are : ");
        m1(isGreaterThan10, x);
        System.out.print("Greter even number are : ");
        m1(isEvenNumber, x);
        System.out.print("Not Greter than 10 are : ");
        m1(isGreaterThan10.negate(), x);
        System.out.print("Greter than 10 and Even numbers are : ");
        m1(isGreaterThan10.and(isEvenNumber), x);
        System.out.print("Greter than 10 or Even numbers are : ");
        m1(isGreaterThan10.or(isEvenNumber), x);
    }
    private static void m1(Predicate<Integer> predicate, int[] numbers) {
        for (int number: numbers) {
            if(predicate.test(number)){
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }
}

//predicate joining methods
class Test27{
    public static void main(String[] args) {
        String[] names = {"Ravi", "Rajesh", "Kumar", "Sudha"};
        Predicate<String> nameStarsWithR = i -> i.startsWith("R");
        System.out.print("Names start with R are :");
        m1(nameStarsWithR, names);
        System.out.print("Names not start with R are :");
        m1(nameStarsWithR.negate(), names);
    }
    private static void m1(Predicate<String> predicate, String[] names) {
        for (String name: names) {
            if(predicate.test(name)){
                System.out.print(name + ", ");
            }
        }
        System.out.println();
    }
}

class Test28{
    public static void main(String[] args) {
        String[] names = {null, "", null, "Ravi", "Rajesh", "Kumar", "Sudha", null, "", "", null};
        Predicate<String> validNames = i -> i!= null && i.length() != 0;
        ArrayList<String> al = new ArrayList<>();
        System.out.println("Names before removing null and empty Strings are : ");
        System.out.println(names);
        System.out.println("Names after removing null and empty Strings are : ");
        m1((i) -> i!= null && i.length() != 0, names); // passing procedure as argument to method.
        for(String name: names){
            if(validNames.test(name)){
                al.add(name);
            }
        }
        System.out.println(al);
    }
    private static void m1(Predicate<String> predicate, String[] names) {
        for (String name: names) {
            if(predicate.test(name)){
                System.out.print(name + ", ");
            }
        }
        System.out.println();
    }
}

class User{
    String name;
    String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}

class Test29{
    public static void main(String[] args) {
        Predicate<User> userAuthenticate = u -> u.name.equals("kiyan") && u.password.equals("kumar");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter User name : ");
        String name = scanner.next();
        System.out.println("Enter Password  : ");
        String password = scanner.next();
        User u1 = new User(name, password);
        if(userAuthenticate.test(u1))
            System.out.println("Welcome");
        else
            System.out.println("Not a Valid Username and Password");
    }
}

class SoftWareEngineers{
    String name;
    int age;
    boolean hasGF;

    public SoftWareEngineers(String name, int age, boolean hasGF) {
        this.name = name;
        this.age = age;
        this.hasGF = hasGF;
    }
}

class Test30{
    public static void main(String[] args) {
        SoftWareEngineers[] ses = {
                new SoftWareEngineers("kumar", 30, false),
                new SoftWareEngineers("Suesh", 25, true),
                new SoftWareEngineers("Venkat", 10, false),
                new SoftWareEngineers("Srinivas", 18, false)
        };
        System.out.println("The Allowed numbers inside Pub are :");
        allow(a -> a.age > 18 && a.hasGF, ses );
        System.out.println("The not Allowed numbers inside Pub are :");
        allow(a -> a.age < 18 || !a.hasGF, ses );
    }

    static void allow(Predicate<SoftWareEngineers> allowable, SoftWareEngineers[] ses){
        for (SoftWareEngineers se: ses) {
            if(allowable.test(se))
                System.out.println(se.name);
        }
    }
}

class Employe{
    String name;
    String designation;
    int salary;
    String city;

    public Employe(String name, String designation, int salary, String city) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Employe e = (Employe) obj;
        if(name.equals(e.name) && designation.equals(e.designation) && salary == e.salary && city.equals(e.city)){
            return true;
        }
        else
            return false;
    }
}

class Test31{

    public static void main(String[] args) {
        ArrayList<Employe> list = new ArrayList();
        populate(list);
       // System.out.println(list);
        System.out.println("Managers");
        Predicate<Employe> managers = e -> e.designation.equals("MGR");
        display(managers,list);
        System.out.println("Banglore Employees");
        Predicate<Employe> bangloreCity = e -> e.city.equals("BLR");
        display(bangloreCity,list);
        System.out.println("Eligible for Bonus");
        Predicate<Employe> bonusEligible = e -> e.salary < 12;
        display(bonusEligible,list);
        System.out.println("No Bonus Employees");
        display(managers.and(bangloreCity),list);
        System.out.println("Less Salary  or managers Employee Details");
        display(managers.or(bonusEligible),list);
        System.out.println("Not managers Employee Details");
        display(managers.negate(),list);
    }

    private static void display(Predicate<Employe> managers, ArrayList<Employe> list) {
        for (Employe e : list) {
            if(managers.test(e))
                System.out.println(e);
        }
        System.out.println(("****************************************************************"));
    }

    private static void populate(ArrayList<Employe> list) {
        list.add(new Employe("kiyan", "SE", 10, "HYD"));
        list.add(new Employe("Bala", "MGR", 20, "BLR"));
        list.add(new Employe("Naveen", "SSE", 15, "BLR"));
        list.add(new Employe("Sai", "MGR", 25, "BLR"));
    }

}

class Test33{

    public static void main(String[] args) {
        Predicate<String> p = Predicate.isEqual("KUMKIYAN");
        System.out.println(p.test("KIYAN"));
        System.out.println(p.test("KUMAR"));
        System.out.println(p.test("KUMKIYAN"));

        Predicate<Employe> canBeCEO = Predicate.isEqual(new Employe("Sai", "MGR", 30, "BLR"));
        Employe e3 = new Employe("Naveen", "SSE", 15, "BLR");
        Employe e4 = new Employe("Sai", "MGR", 30, "BLR");
        System.out.println(canBeCEO.test(e3));
        System.out.println(canBeCEO.test(e4));
        // becuase the abject is created with new method it is treated as different object.
        // in order to get true in the above line just override equal method in Employ class
    }

}

/*interface Predicate1<T> {
    boolean test(T);
}


interface Function<T, R> {
    R apply (T);
}*/

class Test34{
    public static void main(String[] args) {
        Function<String, Integer> function = s -> s.length();
        System.out.println(function.apply("kiyandoor"));

        Function<Integer, Integer> squreIT = i -> i*i;
        System.out.println(squreIT.apply(10));
        System.out.println(squreIT.apply(5));

        Function<String, String> replace = i -> i.replaceAll(" ", "");
        System.out.println(replace.apply("kiyandoor kumar"));
        System.out.println(replace.apply("Dharmendra Surendra"));

        Function<String, Integer> noOfSpaces = i -> i.length() - i.replaceAll(" ", "").length();
        System.out.println(noOfSpaces.apply("kiyandoor  kumar"));
        System.out.println(noOfSpaces.apply("Dharmendra                   Surendra"));

    }
}

class Student{

    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

class Test35{
    public static void main(String[] args) {

        Function<Student, String> getGrade = s -> {
            if(s.marks > 35)
                return "Pass";
            else
                return  "fail";
        };

        Predicate<Student> canGoToTextClass = s -> s.marks > 35;

        List<Student> students = new ArrayList<>();
        students.add(new Student("Kumar", 50));
        students.add(new Student("Kishore", 89));
        students.add(new Student("Bala", 85));
        students.add(new Student("Sudha", 5));

        System.out.println("Pass Studhets: %%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        students.stream().filter(canGoToTextClass).forEach(a -> System.out.println(
                a.name + " marks are " + a.marks + " and Grade is :" + getGrade.apply(a)
        ));

        System.out.println("Fail Studhets: %%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        students.stream().filter(canGoToTextClass.negate()).forEach(a -> System.out.println(
                a.name + " marks are " + a.marks + " and Grade is :" + getGrade.apply(a)
        ));

        Function<List<Student>, Integer> getMarks = s -> {
                Integer total = 0;
            for (Student s1:
                 s) {
                total = total + s1.marks;
            }

            return total;
        };

        System.out.println("Total makrs of class is :" + getMarks.apply(students));

    }
}


class Test36{

    public static void main(String[] args) {

        ArrayList<Employe> list = new ArrayList<>();
        list.add(new Employe("kiyan", "SE", 10, "HYD"));
        list.add(new Employe("Bala", "MGR", 20, "BLR"));
        list.add(new Employe("Naveen", "SSE", 15, "BLR"));
        list.add(new Employe("Sai", "MGR", 25, "BLR"));

        List<Employe>  list2 = new ArrayList<Employe>();

        Predicate<Employe> eligibleForBonus = a -> a.salary < 12;

        Function<Employe, Employe> doIncreament = a -> {
            a.salary = a.salary + 2;
            list2.add(a);
            return a;
        };

        System.out.println("Before Increemnt  :");
        System.out.println(list);
        list.stream().filter(eligibleForBonus).map(doIncreament).collect(Collectors.toList());
        System.out.println("After Increemnt   :");
        System.out.println(list);
        System.out.println(list2);
    }

}

/*
Function Chaining : f1 & f2
1. f1.andThen(f2) // f1 will be applied followed by f2
2. f1.compose(f2) // f2 will be applied followed by f1
*/

class Test37{
    public static void main(String[] args) {

        Function<String, String> f1 = String::toUpperCase;
        Function<String, String> f2 = s -> s.substring(0,8);
        System.out.println(f1.apply("kiyandoor"));
        System.out.println(f2.apply("kiyandoor"));

        System.out.println(f1.andThen(f2).apply("kumarkiyandoor"));
        // first f1 works on top of it f2 works

        System.out.println(f1.compose(f2).apply("kumarkiyandoor"));
        // first f2 works first on top of it f1 works
    }
}

class Test38{
    public static void main(String[] args) {

        Function<Integer, Integer> f1 = i -> i + i;
        Function<Integer, Integer> f2 = i -> i * i;

        System.out.println(f1.andThen(f2).apply(2));
        // first f1 works on top of it f2 works

        System.out.println(f1.compose(f2).apply(2));
        // first f2 works first on top of it f1 works

        /*16
        8*/

    }
}


class Test39{
    public static void main(String[] args) {

        Function<String, String> toLowerCase = String::toLowerCase;
        Function<String, String> subString = s -> s.substring(0,5);

        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter User name : ");
        String name = scanner.next();
        System.out.println("Enter Password  : ");
        String password = scanner.next();
        if(toLowerCase.andThen(subString).apply(name).equals("kiyan") && password.equals("se"))
            System.out.println("Welcome");
        else
            System.out.println("Not a Valid Username and Password");
    }
}


class Test40{

    /*Static method identity
    It is Factory method. - indentity() -> Returns a function that always return its input argument*/

    public static void main(String[] args) {

        Function<Employe, Employe> returnSameThing = Function.identity();
        System.out.println(returnSameThing.apply(new Employe("kiyan", "se", 10, "HYD")));
    }
}


class Test41{


    public static void main(String[] args) {

        Consumer<String> c = System.out::println;
        c.accept("Kiyandoor");
        c.accept("Kumar");
    }
}


class Test42 {
    public static void main(String[] args) {
        ArrayList<Employe> list = new ArrayList();
        populate(list);
        Consumer<Employe> printEmployees = e -> {
            System.out.println("Employee Details : ");
            System.out.println(e.name);
            System.out.println(e.designation);
            System.out.println(e.salary);
            System.out.println(e.city);
        };
        for (Employe e : list)
            printEmployees.accept(e);
    }
    private static void populate(ArrayList<Employe> list) {
        list.add(new Employe("kiyan", "SE", 10, "HYD"));
        list.add(new Employe("Bala", "MGR", 20, "BLR"));
        list.add(new Employe("Naveen", "SSE", 15, "BLR"));
        list.add(new Employe("Sai", "MGR", 25, "BLR"));
    }
}

class Test43{
    public static void main(String[] args) {

        Predicate<Student> canGoToTextClass = s -> s.marks > 35;

        Function<Student, String> getResutls = s -> {
           if(canGoToTextClass.test(s))
               return "Pass";
           else
               return "fail";
        };

        Consumer<Student> display = e -> {
            System.out.println(e.name);
            System.out.println(e.marks);
            System.out.println(getResutls.apply(e));
        };

        List<Student> students = new ArrayList<>();
        students.add(new Student("Kumar", 50));
        students.add(new Student("Kishore", 89));
        students.add(new Student("Bala", 85));
        students.add(new Student("Sudha", 5));

        students.forEach(display);
    }
}

class Movie{
    String name;
    String status;

    public Movie(String name, String status) {
        this.name = name;
        this.status = status;
    }
}

class Test44{

   // Consumer has one default method "andThen" which returns another consumer used for chaining of consumers

    public static void main(String[] args) {

        Consumer<Movie> postRelease = m -> System.out.println("Movie " + m.name + " is redy to release");
        Consumer<Movie> released = m -> System.out.println("Movie " + m.name + " is just release and its result is " + m.status);
        Consumer<Movie> store = m -> System.out.println("Movie " + m.name + " information stored in DB");

        Consumer<Movie> status = postRelease.andThen(released).andThen(store);

        Movie m1 = new Movie("bahubali", "hit");
        status.accept(m1);

        Movie m2 = new Movie("spider", "flop");
        status.accept(m2);


    }
}










class Test60{
    public static void main(String[] args) {
        Integer i = 10;  //auto-boxing. compiler will change it to Integer.valueOf(10).
        System.out.println(i);
        Integer k = new Integer(20);
        int j = k;  // auto-unboxing. compiler will change it to k.intValue();
    }
}

class Test61 {
    public static void main(String[] args) {
        ArrayList<Employe> list = new ArrayList();
        populate(list);
        ObjIntConsumer<Employe> printEmployees = (e,d )-> {
            System.out.println("Employee Details : ");
            System.out.println(e.name);
            System.out.println(e.designation);
            System.out.println(e.salary * d);
            System.out.println(e.city);
        };
        for (Employe e : list)
            printEmployees.accept(e,  2);
    }
    private static void populate(ArrayList<Employe> list) {
        list.add(new Employe("kiyan", "SE", 10, "HYD"));
        list.add(new Employe("Bala", "MGR", 20, "BLR"));
        list.add(new Employe("Naveen", "SSE", 15, "BLR"));
        list.add(new Employe("Sai", "MGR", 25, "BLR"));
    }
}

class Test62{
    public static void main(String[] args) {
        IntSupplier getRandomNumber = () -> (int) (Math.random() * 10);
        StringBuilder otp = new StringBuilder();
        for(int i =0; i < 6 ; i++)
            otp.append(getRandomNumber.getAsInt());
        System.out.println(otp);
    }
}


class Test63{
    public static void main(String[] args) {
        UnaryOperator<Integer> squreIt = i -> i * i;
        System.out.println(squreIt.apply(10));

        IntUnaryOperator squareInt = i -> i * i;  // takes int premitive data type and return type is premitive type only.
        System.out.println(squareInt.applyAsInt(20));
    }
}

class Test64{
    public static void main(String[] args) {
        BinaryOperator<String> name = (i, j) -> i + j;
        System.out.println(name.apply("kiyandoor", " kumar"));

        IntBinaryOperator sumup = Integer::sum;
        System.out.println(sumup.applyAsInt(10,20));
    }
}

// Runnable interface with implementing interface method.
class RunnableImplementation1 implements Runnable{
    @Override
    public void run() {
        for(int i = 1; i< 10; i++) {
            for(int k =0; k< 1000; k++);
            System.out.println("child thread");
        }
    }

    public void myrun() {
        for(int i = 1; i< 10; i++) {
            for(int k =0; k< 1000; k++);
            System.out.println("child thread");
        }
    }

    public static void main(String[] args) {
        Runnable r = new RunnableImplementation1();
        Thread t = new Thread(r);
        t.start();
        for(int i = 1; i< 10; i++) {
            for(int k =0; k< 1000; k++);
            System.out.println("main thread");
        }
    }
}
// Runnable interface with lambda expression
class RunnableInterface2{
    public static void main(String[] args) {
        Runnable r = () -> {
            for (int i = 1; i < 10; i++) {
                for (int k = 0; k < 1000; k++) ;
                System.out.println("child thread");
            }
        };
        Thread t = new Thread(r);
        t.start();
        for(int i = 1; i< 10; i++) {
            for(int k =0; k< 1000; k++);
            System.out.println("main thread");
        }
    }
}

// Runnable interface with method expression. if argument and my requirement matches then go for method reference
class RunnableInterface3{
    public static void main(String[] args) {
        Runnable r = new RunnableImplementation1()::myrun;
        Thread t = new Thread(r);
        t.start();
        for(int i = 1; i< 10; i++) {
            for(int k =0; k< 1000; k++);
            System.out.println("main thread");
        }
    }
}

interface interf8{
    Sample get();
}

interface interf9{
    Sample get(int i);
}

class Sample{
    int k;
    Sample(){
        System.out.println("no arg constructor");
    }

    Sample(int k){
        System.out.println("1 - arg constructor");
        this.k = k;
    }
}

class Test65{
    public static void main(String[] args) {
        interf8 i = Sample::new;
        i.get();
        interf9 i2 = Sample::new;
        i2.get(6);
    }
}
