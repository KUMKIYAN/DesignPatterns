package designprinciples;

class FluentBuilderInheritance {
}

class Person{
    public String name;
    public String position;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}


class PersonBuilder<SELF extends PersonBuilder<SELF>>{

    protected Person person = new Person();
    public SELF withName(String name){
        person.name = name;
        return  self();
    }
    public Person build(){
        return person;
    }
    protected SELF self(){
        return (SELF) this;
    }

}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>{

    public EmployeeBuilder WorkingAs(String posistion){
        person.position = posistion;
        return self();
    }

    protected EmployeeBuilder self(){
        return this;
    }
}

class Demo4{
    public static void main(String[] args) {

        PersonBuilder pb = new PersonBuilder();
        Person k = pb.withName("kiyandoor").build();
        System.out.println(k);

        EmployeeBuilder e1 = new EmployeeBuilder();
        Person p1 = e1.withName("kiyan").WorkingAs("SE").build();
        System.out.println(p1);
    }
}
