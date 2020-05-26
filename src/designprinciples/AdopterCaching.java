package designprinciples;

import java.util.*;
import java.util.function.Consumer;

public class AdopterCaching {
}

class Point4
{
    public int x, y;

    public Point4(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point4 point = (Point4) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode()
    {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString()
    {
        return "Point{" +
                "first=" + x +
                ", second=" + y +
                '}';
    }
}

class Line1
{
    public Point4 start, end;

    public Line1(Point4 start, Point4 end)
    {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line1 line = (Line1) o;

        if (!start.equals(line.start)) return false;
        return end.equals(line.end);
    }

    @Override
    public int hashCode()
    {
        int result = start.hashCode();
        result = 31 * result + end.hashCode();
        return result;
    }
}

class VectorObject1 extends ArrayList<Line1> {}

class VectorRectangle1 extends VectorObject1
{
    public VectorRectangle1(int x, int y, int width, int height)
    {
        add(new Line1(new Point4(x,y), new Point4(x+width, y) ));
        add(new Line1(new Point4(x+width,y), new Point4(x+width, y+height) ));
        add(new Line1(new Point4(x,y), new Point4(x, y+height) ));
        add(new Line1(new Point4(x,y+height), new Point4(x+width, y+height) ));
    }
}

class LineToPointAdapter1 implements Iterable<Point4>
{
    private static int count = 0;
    private static Map<Integer, List<Point4>> cache = new HashMap<>();
    private int hash;

    public LineToPointAdapter1(Line1 line)
    {
        hash = line.hashCode();
        if (cache.get(hash) != null) return; // we already have it

        System.out.println(
                String.format("%d: Generating points for line [%d,%d]-[%d,%d] (no caching)",
                        ++count, line.start.x, line.start.y, line.end.x, line.end.y));

        ArrayList<Point4> points = new ArrayList<>();

        int left = Math.min(line.start.x, line.end.x);
        int right = Math.max(line.start.x, line.end.x);
        int top = Math.min(line.start.y, line.end.y);
        int bottom = Math.max(line.start.y, line.end.y);
        int dx = right - left;
        int dy = line.end.y - line.start.y;

        if (dx == 0)
        {
            for (int y = top; y <= bottom; ++y)
            {
                points.add(new Point4(left, y));
            }
        }
        else if (dy == 0)
        {
            for (int x = left; x <= right; ++x)
            {
                points.add(new Point4(x, top));
            }
        }

        cache.put(hash, points);
    }

    @Override
    public Iterator<Point4> iterator()
    {
        return cache.get(hash).iterator();
    }

    @Override
    public void forEach(Consumer<? super Point4> action)
    {
        cache.get(hash).forEach(action);
    }

    @Override
    public Spliterator<Point4> spliterator()
    {
        return cache.get(hash).spliterator();
    }
}

class AdapterDemo1
{
    private static final List<VectorObject1> vectorObjects =
            new ArrayList<>(Arrays.asList(
                    new VectorRectangle1(1,1,10,10),
                    new VectorRectangle1(3,3,6,6)
            ));

    public static void drawPoint(Point4 p)
    {
        System.out.print(".");
    }

    private static void draw()
    {
        for (VectorObject1 vo : vectorObjects)
        {
            for (Line1 line : vo)
            {
                LineToPointAdapter1 adapter = new LineToPointAdapter1(line);
                adapter.forEach(AdapterDemo1::drawPoint);
            }
        }
    }

    public static void main(String[] args)
    {
        draw();
        draw();
    }
}
