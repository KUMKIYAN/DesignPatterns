package designprinciples;

import java.io.Serializable;

public class ProtoType {
}

class Person2 implements Serializable {
    String name;
    Address address;

    public Person2(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

class Address{
    int doorNo;
    String street;
    String city;

    public Address(int doorNo, String street, String city) {
        this.doorNo = doorNo;
        this.street = street;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "doorNo='" + doorNo + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

class Demo44{
    public static void main(String[] args) {
        Person2 kumar = new Person2("kumar", new Address(13, "BhaskarPet", "skht"));
        Person2 sudha = new Person2("kumar", new Address(13, "BhaskarPet", "skht"));
        // import org.apache.commons.lang3.SerializationUtils;
        // Person2 sudha = SerializationUtils.roundtrip(kumar);
        sudha.name = "sudha";
        sudha.address.doorNo = 14;
        System.out.println(kumar);
        System.out.println(sudha);
    }
}
