package java9;

import java.util.*;

public class Java9Features {
}

// Try with resources Enhancements
class MyResource implements AutoCloseable{
    public MyResource() {
        System.out.println("Creating Resource......");
    }

    public void doProcess(){
        System.out.println("Resource Processing....");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing the Resource...");
    }
}

class Test66 {
    public static void preJDK7() {
        MyResource r = null;
        try {
            r = new MyResource();
            r.doProcess();
        } catch (Exception e) {
            System.out.println("Exception handling " + e);
        } finally {
            if (r!=null) {
                try {
                    r.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void JDK7() {
        // not here we are not using finally block to close the resource.
        try(MyResource r = new MyResource()) {
            r.doProcess();
        } catch (Exception e) {
            System.out.println("Exception handling " + e);
        }
    }

    public static void JDK9() {
        MyResource r1 = new MyResource();
        MyResource r2 = new MyResource();

        //try(r1) { // we can directly pass reference from JDK 1.9.
        try(MyResource r3 = r1){
            r3.doProcess();
        } catch (Exception e) {
            System.out.println("Exception handling " + e);
        }

        //try(r1,r2) { // we can directly pass reference from JDK 1.9.
        try(MyResource r3 = r1; MyResource r4 = r2){
            r3.doProcess();
            r4.doProcess();
        } catch (Exception e) {
            System.out.println("Exception handling " + e);
        }
    }

    public static void main(String[] args) {
        System.out.println("program execution with Pre JDK7");
        preJDK7();
        System.out.println("program execution with JDK7");
        JDK7();
        System.out.println("program execution with JDK9");
        JDK9();
    }
}

// <> operator Enhancements


class Test67{
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>(){  // here we are creating child class for ArrayList
        };
        System.out.println(al.getClass().getName());

        // in 1.9 we no need to specify String at object creation for anonymous inner class
        // it looks like something below.

        /*
        ArrayList<String> al1 = new ArrayList<>(){
        };
        System.out.println(al1.getClass().getName());
        */

    }
}


class MyGenClass<T>{
    T obj;

    public MyGenClass(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void process(){
        System.out.println("Processing Object ...");
    }
}

class Test68{
    public static void main(String[] args) {
     MyGenClass<String> a = new MyGenClass<String>("Kiyan"){ // from JDK 1.9, no need to specify <String> right side for anonymous inner class. instead specify <>
         public void process(){
             System.out.println("Processing Object ..." + getObj());
         }
        };

        MyGenClass<Integer> a1 = new MyGenClass<Integer>(10){ // from JDK 1.9, no need to specify <Integer> right side for anonymous inner class. instead specify <>
            public void process(){
                System.out.println("Processing Object ..." + getObj());
            }
        };

        a.process();
        a1.process();

    }
}

class Test69{
    public static void main(String[] args) {
     String[] heros = {"Chir", "Balu", "Nag", "Venky"};
        Iterator<String> itr = new Iterator<String>() { // from JDK 1.9, no need to specify <String> right side for anonymous inner class. instead specify <>
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < heros.length;
            }

            @Override
            public String next() {
                if(!hasNext())
                    throw new NoSuchElementException();
                return heros[i++];
            }
        };

        while (itr.hasNext()) {
            String s = itr.next();
            System.out.println(s);
        }

    }
}

class Test70{
    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("A","B");
        List<String> l2 = Arrays.asList("C","D");
        m1(l1,l2);
    }

    private static void m1(List<String>...l) {
        Object[] o = l;
        o[0] = Arrays.asList(1,2);
        String name = (String) l[0].get(0);
        System.out.println(name);
    }
}

class Test71{
    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("A","B");
        List<String> l2 = Arrays.asList("C","D");
        m1(l1,l2);
    }

    //We will get warning from compiler, even though there no chance for heap pollution in the below method.
    @SafeVarargs //remove this. you can notice that m1 give warning in the below line and in the above line.
    private static void m1(List<String>...l) {
        for (List<String> li: l) {
            System.out.println(li);
        }
    }
}


class Test72{

    @SafeVarargs
    public Test72(List<String>...l) {
    }

    @SafeVarargs
    public static void m1(List<String>...l) {
    }

    @SafeVarargs
    public final void m2(List<String>...l) {
    }

    //@SafeVarargs // this is not valid in 1.8 bug vaid in 1.9
    private void m3(List<String>...l) {
    }


}