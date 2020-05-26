package designprinciples;

public class Bridge {
}


interface Renderer{
    void renderCircle(float radius);
}

class VectorRenderer implements Renderer{

    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing a circle of radius "+ radius);
    }
}

class RosterRenderer implements Renderer{

    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing pixels a circle of radius "+ radius);
    }
}

abstract class Shape{
    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    abstract void draw();
    abstract void reSize(float factor);
}


class Circle extends Shape{

    public float radius;

    public Circle(Renderer renderer) {
        super(renderer);
    }

    public Circle(Renderer renderer, float radius) {
        super(renderer);
        this.radius = radius;
    }

    @Override
    void draw() {
        renderer.renderCircle(radius);
    }

    @Override
    void reSize(float factor) {
        radius *= factor;
    }
}

class Demo31{
    public static void main(String[] args) {
        RosterRenderer roster = new RosterRenderer();
        VectorRenderer vector = new VectorRenderer();
        Circle circle = new Circle(vector, 5);
        circle.draw();
        circle.reSize(10);
        circle.draw();
    }
}
