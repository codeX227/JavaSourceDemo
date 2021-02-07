package factory_pattern;

/**
 * 圆形
 */
public class Circle implements Shape {
    public Circle(){
        System.out.println("cicle");
    }
    @Override
    public void draw() {
        System.out.println("darw circle");
    }

}
