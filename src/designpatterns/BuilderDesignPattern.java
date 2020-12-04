package designpatterns;

import java.util.List;

public class BuilderDesignPattern {


}

class BankAccount{
    private int id;
    private String email;
    private String firstName;
    private List<String> middleNames;
    private String lastName;
    private int houseNumber;
    private String street;
    private String zipcode;
    private String city;

    public BankAccount(int id, String email, String firstName, List<String> middleNames, String lastName, int houseNumber, String street, String zipcode, String city) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.middleNames = middleNames;
        this.lastName = lastName;
        this.houseNumber = houseNumber;
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
    }
}

class Test{
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1,"kck@gmail.com","kiyan", null,"kum",50,"baskarpet", "500049","Hyd");

        Name name = new Name.Builder().firstName("kiyan").lastName("kumar").middleName(null).build();
        Address address = new Address.Builder().city("chennai").street("17").houseNumber(18).build();
        Account account1 = new Account.Builder().address(address).Name(name).email("kiyan@gmail.com").id(1).build();

        System.out.println(account);
        System.out.println(account1);
        System.out.println(account1.getAddress().getCity());
    }
}

class Account{
    private final int id;
    private final String email;
    private final Name name;
    private final Address address;

    private Account(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.name = builder.name;
        this.address = builder.address;
    }

    public static class Builder{
        private int id;
        private String email;
        private Address address;
        private Name name;

        public Builder id(final int id){
            this.id = id;
            return this;
        }

        public Builder email(final String email){
            this.email = email;
            return this;
        }

        public Builder address(final Address address){
            this.address = address;
            return this;
        }

        public Builder Name(final Name name){
            this.name = name;
            return this;
        }

        public Account build(){
            return new Account(this);
        }
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}

class Name{
    private final String firstName;
    private final List<String> middleNames;
    private final String lastName;

    private Name(Builder builder) {
        this.firstName = builder.firstName;
        this.middleNames = builder.middleName;
        this.lastName = builder.lastName;
    }

    public static class Builder{

        private String firstName;
        private String lastName;
        private List<String> middleName;

        public Builder firstName(final String firstName){
                this.firstName = firstName;
                return this;
            }

        public Builder lastName(final String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder middleName(final List<String> middleNames){
            this.middleName = middleNames;
            return this;
        }

        public Name build(){
            return new Name(this);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public List<String> getMiddleNames() {
        return middleNames;
    }

    public String getLastName() {
        return lastName;
    }
}

class Address{
    private int houseNumber;
    private String street;
    private String zipcode;
    private String city;

    private Address(Builder builder) {
        this.houseNumber = builder.houseNumber;
        this.street = builder.street;
        this.zipcode = builder.zipcode;
        this.city = builder.city;
    }

    public static class Builder{
        private int houseNumber;
        private String street;
        private String zipcode;
        private String city;

        public Builder houseNumber(final int houseNumber){
            this.houseNumber = houseNumber;
            return this;
        }

        public Builder street(final String street){
            this.street = street;
            return this;
        }

        public Builder zipcode(final String zipcode){
            this.zipcode = zipcode;
            return this;
        }

        public Builder city(final String city){
            this.city = city;
            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }
}