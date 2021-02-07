package factory_pattern;

/**
 * 圆形工厂类
 */
public class CircleFactory implements Factory {
    @Override
    public Shape getShape() {
        return new Circle();
    }
}
