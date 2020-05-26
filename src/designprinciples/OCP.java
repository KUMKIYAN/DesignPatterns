package designprinciples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

enum Color{
    BLUE,GREEN,RED,BLACK;
}

enum Size{
    S, M, L, XL
}

class Product{
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
}

class ProductFilter{
    public Stream<Product> filterByColor(List<Product> products, Color color){
        return products.stream().filter(p -> p.color == color);
    }

    // we need to add the below code when this specification come. This modifcation makes above code to be tested again
    public Stream<Product> filterBySize(List<Product> products, Size size){
        return products.stream().filter(p -> p.size == size);
    }

    // we need to add the below code when this new specification come. This modifcation again makes above code to be tested again
    public Stream<Product> filterByColorAndSize(List<Product> products, Size size, Color color){
        return products.stream().filter(p -> p.size == size &&  p.color == color);
    }

}

interface Specication<T>{
    boolean isSatisfied(T item);
}

interface Filter<T>{
    Stream<T> filter(List<T> items, Specication<T> spec);
}


class ColorSpecification implements  Specication<Product>{
    private Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.color == color;
    }

}

class SizeSpecification implements Specication<Product>{
    private Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.size == size;
    }

}

class AndSpecification<T> implements Specication<T>{
    private Specication first, second;

    public AndSpecification(Specication first, Specication second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}

class BetterFilter implements Filter<Product>{

    @Override
    public Stream<Product> filter(List<Product> items, Specication<Product> spec) {
        return items.stream().filter(p -> spec.isSatisfied(p));
    }
}



public class OCP
{
    public static void main(String[] args) {
        Product product1 = new Product("product1", Color.BLACK, Size.L);
        Product product2 = new Product("product2", Color.BLACK, Size.M);
        Product product3 = new Product("product3", Color.BLACK, Size.S);
        Product product4 = new Product("product4", Color.GREEN, Size.XL);

        List<Product> products = new ArrayList<Product>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        System.out.println("Before OCP");

        ProductFilter pf = new ProductFilter();
        System.out.println("Filter by Color :");
        pf.filterByColor(products, Color.BLACK).forEach(a ->
                System.out.println(a.name));

        System.out.println("Filter by Size :");
        pf.filterBySize(products, Size.L).forEach(a ->
                System.out.println(a.name));

        System.out.println("Filter by Size and color :");
        pf.filterByColorAndSize(products, Size.XL, Color.GREEN).forEach(a ->
                System.out.println(a.name));

        System.out.println("After OCP");

        BetterFilter bf = new BetterFilter();
        bf.filter(products,new ColorSpecification(Color.BLACK)).forEach(s -> System.out.println(s.name));
        bf.filter
          (products, new AndSpecification<>(new ColorSpecification(Color.BLACK), new SizeSpecification(Size.S))).forEach(s -> System.out.println(s.name));
    }
}