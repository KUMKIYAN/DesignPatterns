package designpatterns;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BuilderPattern {
}

class Booking{
    int bookingNumber;
    String name;
    String mobileNumber;
    String typeOfBooking;
    String email;

    public Booking(int bookingNumber, String name, String mobileNumber, String typeOfBooking, String email) {
        this.bookingNumber = bookingNumber;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.typeOfBooking = typeOfBooking;
        this.email = email;
    }
}

interface PersonalNotification{
    void sendNotification(Booking booking);
}

class Security implements PersonalNotification{

    @Override
    public void sendNotification(Booking booking) {
        System.out.println("sending SMS to security Naga");
    }
}

class Member implements PersonalNotification{

    @Override
    public void sendNotification(Booking booking) {
        System.out.println("sending SMS to " + booking.name + " " + booking.mobileNumber);
        System.out.println("sending email to " + booking.email);
    }
}

class Coach implements PersonalNotification{
    @Override
    public void sendNotification(Booking booking) {
        System.out.println("sending SMS to Trainer Jithu");
        System.out.println("sending email to Jithu@yahoo.com");
    }
}

class FacilityManager implements PersonalNotification{
    @Override
    public void sendNotification(Booking booking) {
        System.out.println("sending email to Manager Mokka@yahoo.com");
    }
}


class Notification{
    ArrayList<PersonalNotification> mList = new ArrayList<>();
    Booking booking;

    public void notife(){
        for (PersonalNotification member:mList) {
            member.sendNotification(booking);
        }
    }
}


class NotificationBuilder{
    static Notification buildNotification(Booking booking){
        if(booking.typeOfBooking.equalsIgnoreCase("individual")){
            return individualBooking(booking);
        } else if(booking.typeOfBooking.equalsIgnoreCase("coaching")){
            return coachBooking(booking);
        } else
            return LifeTimeBooking(booking);

    }

    private static Notification LifeTimeBooking(Booking booking) {
        Notification n = new Notification();
        n.mList.add(new Security());
        n.mList.add(new Member());
        n.mList.add(new Coach());
        n.mList.add(new FacilityManager());
        n.booking = booking;
        return n;
    }

    private static Notification coachBooking(Booking booking) {
        Notification n = new Notification();
        n.mList.add(new Security());
        n.mList.add(new Member());
        n.mList.add(new Coach());
        n.booking = booking;
        return n;
    }

    private static Notification individualBooking(Booking booking) {
        Notification n = new Notification();
        n.mList.add(new Security());
        n.mList.add(new Member());
        n.booking = booking;
        return n;
    }
}

class ClientCode{
    public static void main(String[] args) {
        Booking b = new Booking(10,"kiyan","7093691494","individual", "kck@gmail.com");
        Notification n = NotificationBuilder.buildNotification(b);
        n.notife();
        System.out.println("******************************");
        Booking bb = new Booking(10,"kiyandoor","7093691495","coaching", "kcki@gmail.com");
        Notification nn = NotificationBuilder.buildNotification(bb);
        nn.notife();
        System.out.println("******************************");
        Booking bbb = new Booking(10,"kiyandoor","7093691496","LifeTime", "kcke@gmail.com");
        NotificationBuilder.buildNotification(bbb).notife();
        System.out.println("******************************");
    }
}

class Outer5
{
    int a = 10;
    static int b = 200;
    static class Inner5
    {
        static void m1()
        {
            //System.out.println(a); // in-valid
            System.out.println(b); // valid
        }

        void m2()
        {
            //System.out.println(a); // in-valid static class can access only static properties
            System.out.println(b); // valid
        }
    }
    class Inner6
    {
        void m1()
        {
            System.out.println(a); // valid
            System.out.println(b); // valid
        }
    }
    public static void main(String[] args)
    {
        Outer5.Inner5 i = new Outer5.Inner5();
        i.m1();
        i.m2();

        Outer5 o = new Outer5();
        Outer5.Inner6 i1 = o.new Inner6();
        i1.m1();
    }
}