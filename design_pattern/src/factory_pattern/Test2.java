package factory_pattern;

public class Test2 {
    public static void main(String[] args){
        Circle circle = (Circle)ShapeFactory2.getClass(Circle.class);
        circle.draw();
        Rectangle rectangle = (Rectangle) ShapeFactory2.getClass(Rectangle.class);
        rectangle.draw();
    }
}
