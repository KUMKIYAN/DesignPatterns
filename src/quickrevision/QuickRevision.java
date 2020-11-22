package quickrevision;

class QuickRevision2{
    static {
        System.out.println("static block");
    }
}
class QuickRevision1{
    static {
        System.out.println("static block1");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("QuickRevision2");
    }
}

