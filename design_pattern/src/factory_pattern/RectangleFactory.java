package factory_pattern;

/**
 * 长方形工厂类
 */
public class RectangleFactory implements Factory {
    @Override
    public Shape getShape() {
        return new Rectangle();
    }
}
