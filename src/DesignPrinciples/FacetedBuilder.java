package DesignPrinciples;

public class FacetedBuilder {
}

class Person1{

    public String streetAddress, postCode, city;
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        return "Person1{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postCode='" + postCode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }
}

class Person1Builder {
    protected Person1 person = new Person1();

    public Person1AddressBuilder lives(){
        return new Person1AddressBuilder(person);
    }

    public Person1JobBuilder works(){
        return new Person1JobBuilder(person);
    }

    public Person1 build(){
        return person;
    }
}


class Person1AddressBuilder extends Person1Builder{
    public Person1AddressBuilder(Person1 person){
        this.person = person;
    }

    public Person1AddressBuilder at(String streenAddress){
        person.streetAddress = streenAddress;
        return this;
    }

    public Person1AddressBuilder withPostCode(String postCode){
        person.postCode = postCode;
        return this;
    }

    public Person1AddressBuilder in(String city){
        person.city = city;
        return this;
    }
}

class Person1JobBuilder extends Person1Builder{
    public Person1JobBuilder(Person1 person){
        this.person = person;
    }

    public Person1JobBuilder at(String compnayName){
        person.companyName = compnayName;
        return this;
    }

    public Person1JobBuilder asA(String position){
        person.position = position;
        return this;
    }

    public Person1JobBuilder earning(int annualIncome){
        person.annualIncome = annualIncome;
        return this;
    }
}

class Demo5{
    public static void main(String[] args) {
        Person1Builder pb = new Person1Builder();
        Person1 person = pb.lives()
                .at("13 B Street")
                .withPostCode("517456")
           .works().asA("SE")
                .at("PVT")
                .earning(10)
           .lives()
                .in("CHT")
           .build();
        System.out.println(person);
    }
}