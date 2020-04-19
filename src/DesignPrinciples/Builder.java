package DesignPrinciples;

import java.util.ArrayList;
import java.util.Collections;

class Demo1 {
    public static void main(String[] args) {
        String hello = "Hello";
        System.out.println("<p>" + hello + "</P>");

        // here we need to keep on use cancatenation or + operator for building a String.

        String[] words = {"Hello","World"};
        StringBuilder sb = new StringBuilder();
        sb.append("<ul>\n");
        for (String word: words) {
            sb.append((String.format("  <li>%s</li>\n", word)));
        }
        sb.append("</ul>\n");
        System.out.println(sb);
    }

}


class HtmlElment{
    public String name, text;
    public ArrayList<HtmlElment> elements = new ArrayList<>();
    private final int indentSize = 2;
    private final String newLine = System.lineSeparator();

    public HtmlElment() {
    }

    public HtmlElment(String name, String text) {
        this.name = name;
        this.text = text;
    }

    private String toStringImpl(int indent){
        StringBuilder sb = new StringBuilder();
        String i = String.join("", Collections.nCopies(indent * indentSize, " "));
        sb.append(String.format("%s<%s>%s", i, name, newLine));
        if(text!= null && !text.equals("")) {
            sb.append(String.join("", Collections.nCopies(indentSize * (indent + 1), " ")));
            sb.append(text);
            sb.append(newLine);
        }
        for (HtmlElment e: elements)
            sb.append(e.toStringImpl(indent+1));
        sb.append(String.format("%s</%s>%s", i, name, newLine));
        return sb.toString();
    }

    @Override
    public String toString() {
        return toStringImpl(1);
    }
}

class HtmlBuilder{
    private String rootName;
    private HtmlElment root = new HtmlElment();

    public HtmlBuilder(String rootName) {
        this.rootName = rootName;
        root.name = rootName;
    }

    public void addChild(String childName, String childText){
        HtmlElment e = new HtmlElment(childName, childText);
        root.elements.add(e);
    }

    public HtmlBuilder addChildBuilder(String childName, String childText){
        //for fluent builder
        HtmlElment e = new HtmlElment(childName, childText);
        root.elements.add(e);
        return this;
    }

    public void clear(){
        root = new HtmlElment();
        root.name = rootName;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}

class Demo3{
    public static void main(String[] args) {
        HtmlBuilder builder = new HtmlBuilder("ul");
        builder.addChild("li","Hello");
        builder.addChild("li","world");
        System.out.println(builder);

        //Fluent Builder

        HtmlBuilder builder1 = new HtmlBuilder("ul");
        builder1
                .addChildBuilder("a", "link0")
                .addChildBuilder("a", "link1")
                .addChildBuilder("a", "link1");
        System.out.println(builder1);
    }


}
