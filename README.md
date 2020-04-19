# DesignPatterns

3. Categories
Creational pattern
Structural pattern
Behavioural pattern


Single Responsibility principle: 
Only one primary responsibility. Do not give more responsibility. 
If you take lots of responsibilities we end up with something called a god object which is an anti-pattern.
eg: The menu class here has limited(desired) responsibilities (single responsible principle).  adding any other method make it break this principle. 
Refer :

OpenClosePrinciple:
Open for extension but Close for modification. This approach is useful when we have specifications. 
Assume, In business we get a specification to filter products by color first. then another filter by price. then another filter by size.
in such cases we keep on try to modification to existing code (which could make production code /already tested code make into risk).
In search cases go far interface with generic parameters. 
so that for each new specification create new class (open for extention but closed for modification) and implement spefications.
Refer :


Liskov Substitution Principle
We should able to substitute a subclass for a base class. If we have some API which takes a base class we should be able to stick a subclass
In there without the things breaking in any way and we're going to see how we can actually violate that principle.
we no need to have sub class. parent class with some simple methods servers the subclass implementation. 
Refer : 


Interface Segregation Principle:
Creating an interface as many methods as possible end up with adopter clases in which we see empty implemenation / implemenation with throw Exception(). both of them not good. 
Instead cleate as manay interfaces as possible with exact requirement of each interface create another interface that extend few previosly created interface as per requirement and go...


Dependancy Inversion Principal:
High level module should not dependant on low level module. Both should dependant on Abstractions.
Abstractions should not depant on details. Details should depend on Obstractions.

Abstraction means either an abstract class or an interface. We get a signature of something which performs a particular operation.
We don't necessarily work with the concrete implementation.


Builder Design Pattern :  
Creation of object is not with single line. instead construction of object is piece by piece.
The builder is a separate component whose only purpose in life is for building up one particular object.

Existing java builder example : StringBuilder 

StringBuilder sb = new StringBuilder();
sb.append("Hello");
sb.append" World");
sb.append("Good Morning");
System.out.println(sb);

For UserDefined Builder eg refer the link: 

Fluent Builder: Adding append method on another apeend method.
StringBuilder sb = new StringBuilder();
sb.append("Hello").append("World").append("good morning") we can keep on append n number of times. this is called fluent builder.
Same thing can be achieved with userDefined builder by changing the method return type to Class and return this.
Refer eg for the user defined fluent builder: 


Fluent Builder with Inheritance: We not going to be surprised to know that sometimes builders inherit from other builders. 
But when you do this kind of thing you end up with a bit of a problem in terms of how to actually preserve the fluent interface.

Refer Eg:

Faceted builders:
If we have an object that's so complicated that you have to have several builders what you can do is you can give them a common interface or a common class.
In our case and person builder is the one that can actually expose the different builders. 
The fact that it's a fluent interface allows us to jump from one to another.
Just by using a single dot just by calling on the appropriate method.
So this is neat trick to allow us to sort of build up complicated objects through more than one builder.

Refer Eg: 
