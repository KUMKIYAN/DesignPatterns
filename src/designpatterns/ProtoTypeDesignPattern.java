package designpatterns;

public class ProtoTypeDesignPattern {
}

interface Animals extends Cloneable{
    public Animals makeCopy();
}

class Sheep implements Animals{

    public Sheep() {
        System.out.println("Sheep is made");
    }

    @Override
    public Animals makeCopy() {
        System.out.println("Sheep is being made");
        Sheep sheepObject = null;
        try {
            sheepObject = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return sheepObject;
    }

    @Override
    public String toString() {
        return "Hero...";
    }
}

class CloneFactory{
    public Animals getClone(Animals animalSample){
        return animalSample.makeCopy();
    }
}

class TestCloning{
    public static void main(String[] args) {

        CloneFactory cloneFactory = new CloneFactory();
        Sheep sally = new Sheep();
        Sheep clonedSheep = (Sheep) cloneFactory.getClone(sally);

        System.out.println(sally);
        System.out.println(clonedSheep);

        System.out.println(System.identityHashCode(System.identityHashCode(sally)));
        System.out.println(System.identityHashCode(System.identityHashCode(clonedSheep)));

    }
}