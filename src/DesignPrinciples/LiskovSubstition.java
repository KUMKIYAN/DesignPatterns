package DesignPrinciples;

class LiskovSubstition {

}

class Rectangle{
    int width, height;

    public Rectangle(){

    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea(){
        return width * height ;
    }

    @Override
    public String toString() {
        return "Rectable{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}


class Square extends Rectangle {

    public Square() {
    }

    public Square(int size) {
        width = height = size;
    }


    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }


    public void setHeight(int height) {
        this.width = height;
        this.height = height;
    }

}


class Demo {
    public static void useIt(Rectangle r) {
        int width = r.getWidth();
        r.setHeight(10);
        System.out.println("Expected area of " + width * 10 + " Got :" + r.getArea());
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(2, 3);
        useIt(r); // perfectly working for rectangle

        Square s = new Square();
        s.setWidth(5);
        useIt(s);
        // use it not working perfectly because of squre setters and getters are setting sides equally - in implicit manner
        // Completely remove subclass
        // To over come this issue creat a method is the rectangle like => boolean isSquare(int width, int height{return width == height).
        // we can use factory methods to create Rectangle and squre as shwon below.
    }
}

class RectableFactory {

    public static Rectangle newRectable(int width, int height){
        return newRectable(width,height);
    }

    public static Rectangle newSqure(int side){
        return newRectable(side,side);
    }

}